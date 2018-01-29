package com.javarush.task.task20.task2002;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", "test_2.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            for (User x: javaRush.users) {
                x.setFirstName("Ivan");
                x.setLastName("Ivanov");
                x.setMale(true);
                x.setBirthDate(new Date());
                x.setCountry(User.Country.RUSSIA);
            }
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(users != null);
            if (users != null) {
                printStream.println(users.size());
                for (User x: users) {
                    printStream.println(x.getFirstName());
                    printStream.println(x.getLastName());
                    printStream.println(x.getBirthDate().getTime());
                    printStream.println(x.getCountry());
                    printStream.println(x.isMale());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            if (Boolean.valueOf(rd.readLine())) {
                int size = Integer.valueOf(rd.readLine());
                for (int i = 0; i < size; i++) {
                    this.users.add(new User());
                    this.users.get(i).setFirstName(rd.readLine());
                    this.users.get(i).setLastName(rd.readLine());
                    this.users.get(i).setBirthDate(new Date(Long.valueOf(rd.readLine())));
                    String countryX = rd.readLine();
                    if (countryX.equals("UKRAINE"))
                        this.users.get(i).setCountry(User.Country.UKRAINE);
                    if (countryX.equals("OTHER"))
                        this.users.get(i).setCountry(User.Country.OTHER);
                    if (countryX.equals("RUSSIA"))
                        this.users.get(i).setCountry(User.Country.RUSSIA);
                    this.users.get(i).setMale(Boolean.valueOf(rd.readLine()));
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
