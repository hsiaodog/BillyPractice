package com.billy.Java8;

import java.util.HashSet;
import java.util.Set;

public class ISinkDistinct<T> implements ISink<T>{
    private final ISink<T> downstream;
    private Set<T> set;

    public ISinkDistinct(ISink<T> downstream) {
        this.downstream = downstream;
    }
    /**
     *  distinct sink
     *      begin => seen = new HashSet<>();
     *        end => downstreamSink.end();
     *  accept(v) =>
     *    if(seen.add(v)) {
     *         downstreamSink.accept(v);
     *    }
     */
    @Override
    public void begin(long size) {
        set = new HashSet<>();
    }

    @Override
    public void end() {
        downstream.begin(-1);
        downstream.end();
    }

    @Override
    public void accept(T t) {
        if (set.add(t)) {
            downstream.accept(t);
        }
    }
}
