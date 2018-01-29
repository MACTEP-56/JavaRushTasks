package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(rd.readLine())));
        List<String> words = new ArrayList<>();
        while (file.ready()) {
            Collections.addAll(words, file.readLine().split(" "));
        }
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                StringBuilder str = new StringBuilder(words.get(j));
                if (words.get(i).equals(str.reverse().toString())) {
                    Pair p = new Pair();
                    p.first = words.get(j);
                    p.second = words.get(i);
                    result.add(p);
                    words.remove(j-1);
                    break;
                }
            }

        }

        for (Pair x: result)
            System.out.println(x);

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
