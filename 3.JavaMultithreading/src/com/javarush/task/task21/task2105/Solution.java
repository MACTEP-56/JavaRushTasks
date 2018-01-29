package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        if (first != null ? !first.equals(n.first) : n.first != null)
            return false;
        return last != null ?  n.last.equals(last) : n.last == null;
    }

    @Override
    public int hashCode() {
        return  31 * (first != null ? first.hashCode() : 0) + (last != null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
