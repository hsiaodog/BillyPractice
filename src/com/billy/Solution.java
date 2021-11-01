package com.billy;

import java.util.*;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return new ListNode();
    }
    public List<Character> highest1(String input) {
        Map<Character,Integer> hashMap = new HashMap<>();
        int tmp = 0;
        List<Character> ans = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            if (hashMap.containsKey(input.charAt(i))) {
                tmp = 1;
            } else {
                tmp = hashMap.get(input.charAt(i)) + 1;
            }
            hashMap.put(input.charAt(i), tmp);
            if (max < tmp) {
                max = tmp;
            }
        }
        for (Character character : hashMap.keySet()) {
            if (hashMap.get(character) == max) {
                ans.add(character);
            }
        }
        return ans;
    }
    public List<Character> highest2(String input) {
        Map<Character,Integer> hashMap = new HashMap<>();
        List<Character> ans = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            hashMap.put(input.charAt(i),hashMap.getOrDefault(input.charAt(i),0)+1);
            max = Math.max(max, hashMap.get(input.charAt(i)));
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : hashMap.entrySet()) {
            if (characterIntegerEntry.getValue()==max) {
                ans.add(characterIntegerEntry.getKey());
            }
        }
        for (Character character: hashMap.keySet()) {
            if (hashMap.get(character) == max) {

            }
        }
        return ans;
    }
    public List<String> highest3(String input) {
        Map<String,Integer> hasMap = Arrays.stream(input.split("")).collect(Collectors.toMap(
                s -> s,
                s -> 1,
                Integer::sum
        ));
        int max = Collections.max(hasMap.values());
        return hasMap.keySet().stream()
                .filter(s-> hasMap.get(s) == max).collect(Collectors.toList());
    }
    public String reverse(String input) {
        int l = 0;
        int r = input.length()-1;
        char[] chars = input.toCharArray();
        char tmp;
        while (l<r) {
            System.out.println(chars[l]);
            tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        String ans = String.valueOf(chars);
        return ans;

    }
    public String reverse2(String input) {
        StringBuffer ans = new StringBuffer();
        for (int i = input.length()-1; i >=0; i--) {
            ans.append(input.charAt(i));
        }
        return ans.toString();
    }
    public int[] sorting(int[] input) {
        int minIndex;
        int tmp;
        for (int i = 0; i < input.length; i++) {
            minIndex = i;
            for (int j = i; j < input.length; j++) {
                if (input[minIndex] > input[j]) {
                    minIndex = j;
                }
            }
            tmp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = tmp;
        }
        return input;
    }
    public String[] removeDup(String[] input) {
        Set<String> set = new HashSet<>();
        List<String> ans = new LinkedList();
        for (int i = 0; i < input.length; i++) {
            if (!set.contains(input[i])) {
                set.add(input[i]);
                ans.add(input[i]);
            }
        }
        return ans.toArray(String[]::new);
    }
}


