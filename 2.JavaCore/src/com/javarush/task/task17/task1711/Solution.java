package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

            switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i+=3)
                synchronized (allPeople){
                if (args[i+1].equals("m")) {
                    allPeople.add(Person.createMale(args[i], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[i+2])));
                }
                if (args[i+1].equals("f")) {
                    allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[i+2])));
                }
            }
            case "-u":
                for (int i = 1; i < args.length; i+=4)
                synchronized (allPeople){
                if (args[i+2].equals("m")) {
                    allPeople.add(Integer.parseInt(args[i]), Person.createMale(args[i], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[i+3])));
                }
                if (args[i+2].equals("f")) {
                    allPeople.add(Integer.parseInt(args[i]), Person.createFemale(args[i], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[i+3])));
                }
            }
            case "-d":
                for (int i = 1; i < args.length; i++)
                synchronized (allPeople){
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
                allPeople.get(Integer.parseInt(args[i])).setName(null);
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
            }
            case "-i":
                for (int i = 1; i < args.length; i++)
                synchronized (allPeople){
                Person pers = allPeople.get(Integer.parseInt(args[i]));
                System.out.println(pers.getName() + " " + (pers.getSex().equals(Sex.MALE)?"Muzhik":"Telka") + " " + new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(pers.getBirthDay()));
            }
        }
    }
}
