package com.billy.Java8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Operation<IN, OUT> extends AbstractPipeline<IN, OUT> {


    public Operation(Collection<OUT> source) {

        super(source);
    }

    public Operation(AbstractPipeline<?, IN> upstream) {

        super(upstream);
    }

    @Override
    public <R> IStream<R> map(Function<OUT, R> mapper) {
        return new Operation<OUT, R>(this) {
            @Override
            ISink<OUT> onWrapSink(ISink<R> downstreamSink) {
                return val -> {
                    R r = mapper.apply(val);
                    downstreamSink.accept(r);
                };
            }
        };
    }
    //  x -> x < 5 pass / x >= fail
    @Override
    public IStream<OUT> filter(Predicate<OUT> predicate) {
        return new Operation<OUT, OUT>(this) {
            @Override
            ISink<OUT> onWrapSink(ISink<OUT> downstreamSink) {
                return val -> {
                    if(predicate.test(val)) {
                        downstreamSink.accept(val);
                    }
                };
            }
        };
    }
/**
 *  distinct sink
 *      begin => seen = new HashSet<>();
 *        end => downstreamSink.end();
 *  accept(v) =>
 *    if(seen.add(v)) {
 *         downstreamSink.accept(v);
 *    }
 *  distinct    ->  stateful
 *              ->  predicate
 */
    @Override
    public IStream<OUT> distinct() {
        return new Operation<OUT, OUT>(this) {
            @Override
            ISink<OUT> onWrapSink(ISink<OUT> downstreamSink) {
                return new ISinkDistinct<>(downstreamSink);
            }
        };
    }
    /**
     *                sorted sink
     *                      begin => list
     *                      end =>  list.sort(cpt)
     *                              for loop list
     *                                  downstreamSink.accept(v)
     *                              downstreamSink.end()
     *                      accept => list.add(v)
     */
    @Override
    public IStream<OUT> sorted(Comparator<OUT> cpt) {
        return new Operation<OUT,OUT>(this) {
            @Override
            ISink<OUT> onWrapSink(ISink<OUT> downstreamSink) {
                return new ISinkSort<OUT>(downstreamSink, cpt);
            }
        };
    }

    @Override
    public IStream<OUT> sorted() {
        return new Operation<OUT,OUT>(this) {
            @Override
            ISink<OUT> onWrapSink(ISink<OUT> downstreamSink) {
                return new ISinkSort<OUT>(downstreamSink);
            }
        };
    }

    @Override
    ISink<IN> onWrapSink(ISink<OUT> sink) {
        throw new UnsupportedOperationException("need to be implemented");
    }

}
