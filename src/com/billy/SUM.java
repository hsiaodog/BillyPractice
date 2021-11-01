package com.billy;
import java.util.HashMap;
import java.util.Map;

public class SUM {
    private int[] array;
    private int total = 0;

    public SUM(int[] array) {
        this.array = array;
    }

    public int sum(){
        Map<Integer,Integer> dict = new HashMap<>();
        for (int i : array) {
            Integer tmp = dict.getOrDefault(i,0);
            tmp++;
            dict.put(i,tmp);
        }
        for (Integer integer : dict.keySet()) {
            if (dict.get(integer)==1) {
                total+=integer;
            }
        }
        return total;
    }
}
