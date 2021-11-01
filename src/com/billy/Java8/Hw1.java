package com.billy.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  new feature
 *      functional interface (1 abstract method)
 *          1. Function => 1 input, 1 output
 *          2. Supplier => 0 input, 1 output
 *          3. Consumer => 1 input, 0 output
 *          4. Predicate=> 1 input, boolean output
 *      lambda expression
 *      stream api
 *          1. intermediate operation
 *                 a. stateful operation : sorted, distinct
 *                 b. stateless operation : map, filter, ..
 *          2. terminal operation : collect, reduce, max..
 *
 *      1. stream()  [1, 2, 3]
 *            get iterator  obj1 = Object[1, 2, 3]
 *                map(x -> x * 2) obj1 = Object[2, 4, 6]
 *                      map(x -> new String(x)) obj2 = ["2", "4", "6"]
 *          0           1                           2                           3
 *      2. stream -> stateful op(sorted()) <-> stateless op(x -> x * 2) <-> stateless op(convert to string) <-> terminal op
 *                    Sink1                 ->       Sink2               ->      Sink3
 *                 begin(long size)
 *                 end
 *                 accept
 *              iterator[1, 2, 3]
 *                      1                   ->   1 ->   1 *  2              ->   2 -> "2"           -> ["2"]
 *                      2                   ->   2 ->   2 *  2              ->   4 -> "4"           -> ["4"]
 *                      3...
 *
 *                map(x -> x * 2).distinct()
 *                distinct sink
 *                      begin => seen = new HashSet<>();
 *                      end => downstreamSink.end();
 *                      accept(v) =>
 *                          if(seen.add(v)) {
 *                              downstreamSink.accept(v);
 *                          }
 *                sorted sink
 *                      begin => list
 *                      end =>  list.sort(cpt)
 *                              for loop list
 *                                  downstreamSink.accept(v)
 *                              downstreamSink.end()
 *                      accept => list.add(v)
 *                stateless sink
 *                      begin =>
 *                      end => downstreamSink.end()
 *                      accept => downstreamSink.accept(function.apply(v))
 */

//interface MyStream<T> {
//    <R> R map(Function<T, R> mapper);
//
//    static <T> MyStream<T> of(T... val) {
//        return new MyPipeline(val);
//    }
//}
//
//class MyPipeline<T> implements MyStream<T>{
//    private Object[] val;
//
//    public MyPipeline(T... val) {
//        this.val = val;
//    }
//
//    @Override
//    public <R> R map(Function<T, R> mapper) {
//        for(int i = 0; i < val.length; i++) {
//            val[i] = mapper.apply((T)val[i]);
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        Stream.of(1, 2, 3).map(x -> x * 2);
//    }
//}

class Hw1 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(3);
        IStream<Integer> stream = IStream.of(l);
        l.add(2);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(1);
        //List<String> ans = stream.map(x -> x * 2).filter(x -> x < 5).map(x -> String.valueOf(x)).collect(() -> new ArrayList(), (res, val) -> res.add(val));
        //System.out.println(ans);
//        List<Integer> ans1 = stream.sorted((s1,s2) -> s1.compareTo(s2)).collect(() -> new ArrayList<>(), (res,val) -> res.add(val));
//        System.out.println(ans1);
        List<Integer> ans1 = stream.sorted().collect(() -> new ArrayList<>(), (res,val) -> res.add(val));
        System.out.println(ans1);
        //List<Integer> ans2 = stream.distinct().collect(()->new ArrayList<>(), (res,val) -> res.add(val));
        //System.out.println(ans2);
//        int total = stream.reduce(0, (res, val) -> res + val);
//        System.out.println(total);
    }
}
/**
 *  homework
 *      1. create my stream project
 *      2. sorted(), sorted(comparator), distinct(), reduce()
 */