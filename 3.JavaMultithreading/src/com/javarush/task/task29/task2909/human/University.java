package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for (Student st: students) {
            if (averageGrade == st.getAverageGrade())
                student = st;
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        int  max = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > students.get(max).getAverageGrade())
                max = i;
        }
        return students.get(max);
    }

    public Student getStudentWithMinAverageGrade() {
        double min = Double.MIN_VALUE;
        for (int i = 0; i < students.size() - 1; i++) {
            if (students.get(i).getAverageGrade() < min)
                return students.get(i);
            else
                return students.get(i+1);
        }
        return null;
    }

    public void expel(Student student) {
        if (student != null && students.contains(student))
            students.remove(student);
    }

}