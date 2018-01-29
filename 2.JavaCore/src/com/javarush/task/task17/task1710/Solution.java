package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length == 4 && args[0].equals("c")){
            if (args[2].equals("m")){
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[3])));
            }
            if (args[2].equals("f")){
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[3])));
            }
        }
        if (args.length == 5 && args[0].equals("-u")){
            if (args[3].equals("m")){
                allPeople.add(Integer.parseInt(args[1]), Person.createMale(args[1], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[4])));
            }
            if (args[3].equals("f")){
                allPeople.add(Integer.parseInt(args[1]), Person.createFemale(args[1], new SimpleDateFormat("DD/MM/yyyy", Locale.ENGLISH).parse(args[4])));
            }
        }
        if (args.length == 2 && args[0].equals("-d")){
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
        }
        if (args.length == 2 && args[0].equals("-i")){
            Person pers = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(pers.getName() + " " + pers.getSex() + " " + new SimpleDateFormat("DD-MM-yyyy", Locale.ENGLISH).format(pers.getBirthDay()));
        }
    }
}
