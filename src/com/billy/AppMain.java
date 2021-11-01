
package com.billy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//class Student {
//    String name;
//    int age;
//    int id;
//    public String getName() {
//        return name;
//    }
//    public int getAge() {
//        return age;
//    }
//    public int getId() {
//        return id;
//    }
//    Student(String n, int a, int i){
//        name = n;
//        age = a;
//        id = i;
//    }
//    @Override public String toString() {
//        return ("Student[ "+"Name:"+this.getName()+
//                " Age: "+ this.getAge() +
//                " Id: "+ this.getId()+"]");
//    }
//}
//class Person {
//    String firstName;
//    String lastName;
//    int age;
//    public Person(String firstName, String lastName, int age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//    public boolean equals(Object o) {
//        if (o instanceof Person) {
//            Person p = (Person) o;
//            return Objects.equals(this.firstName,p.firstName)
//                    && Objects.equals(this.lastName, p.lastName)
//                    && this.age == p.age;
//        }
//        return false;
//    }
//}
//class Apple {
//    private int price;
//    private String color;
//    public Apple(String color,int price) {
//
//        this.price = price;
//        this.color = color;
//
//    }
//
//    public boolean equals(Object o) {
//        if (o instanceof Apple) {
//            Apple a = (Apple) o;
//            return Objects.equals(this.color, a.color);
//        }
//        return false;
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(color);
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    @Override
//    public String toString() {
//        return "Apple{" +
//                "color='" + color + '\'' +
//                '}';
//    }
//}
//class Students {
//    List<Student> list;
//    Map<String, Integer> cache;
//
//    Students(List<Student> list) {
//        this.list = list;
//        cache = new HashMap<>();
//    }
//
//    /**
//     * 根据name查找score，找到返回score，未找到返回-1
//     */
//    int getScore(String name) {
//        // 先在Map中查找:
//        Integer score = this.cache.get(name);
//        if (score == null) {
//            // TODO:
//            score = findInList(name);
//            if (score != null) {
//                this.cache.put(name,score);
//            }
//        }
//        return score == null ? -1 : score.intValue();
//    }
//
//    Integer findInList(String name) {
//        for (var ss : this.list) {
//            if (ss.name.equals(name)) {
//                return ss.score;
//            }
//        }
//        return null;
//    }
//}
//
//class Student {
//    String name;
//    int score;
//
//    Student(String name, int score) {
//        this.name = name;
//        this.score = score;
//    }
//}

public class AppMain {
    public static void main(String[] args) {
//        int[] array1 = {1,2,4};
//        int[] array2 = {1,2,4};
//        ArrayToListNode listNode1 = new ArrayToListNode();
//        ArrayToListNode listNode2 = new ArrayToListNode();
//        ListNode listNodes1 = listNode1.arrayToListNode(array1);
//        ListNode listNodes2 = listNode2.arrayToListNode(array2);
//        Solution ans = new Solution();
//        ListNode ans2 = ans.mergeTwoLists(listNodes1,listNodes2);
        String[] input = {"aaa","aaa","bbb","ccc","aaa","bbb","ccc","ddd"};
//        int[] input = {4,1,3,3,5,2};
        Solution solution = new Solution();
        String[] ans = solution.removeDup(input);
        Arrays.stream(ans).forEach(System.out::println);
    }
}
