package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args != null) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            String fileName = rd.readLine();
            rd.close();

            switch (args[0]) {
                case "-u": {
                    String id = getStr(args[1],8);
                    String productName = getStr(getProdName(args), 30);
                    String price = getStr(args[args.length - 2], 8);
                    String quantity = getStr(args[args.length - 1], 4);
                    String res = id + productName + price + quantity;

                    ArrayList<String> text = new ArrayList<>();
                    BufferedReader rd2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                    while (true) {
                        String s = rd2.readLine();
                        if (s == null)
                            break;
                        text.add(s);
                    }
                    rd2.close();

                    FileWriter wr = new FileWriter(fileName);
                    for (int i = 0; i < text.size(); i++){
                        if (text.get(i).startsWith(id)){
                            wr.write(res);
                        } else
                            wr.write(text.get(i));
                        wr.write("\r\n");
                    }
                    wr.close();
                    break;
                }
                case "-d": {
                    ArrayList<String> text = new ArrayList<>();
                    BufferedReader rd2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                    while (true) {
                        String s = rd2.readLine();
                        if (s == null)
                            break;
                        text.add(s);
                    }
                    rd2.close();

                    FileWriter wr = new FileWriter(fileName);
                    for (int i = 0; i < text.size(); i++){
                        if (text.get(i).startsWith(args[1])){
                            continue;
                        } else
                            wr.write(text.get(i));
                        wr.write("\r\n");
                    }
                    wr.close();
                    break;
                }
            }
        }
    }

    private static String getProdName(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 2; i < args.length - 2; i++) {
            str.append(args[i]).append(" ");
        }
        return str.toString().trim();
    }

    private static String getStr(String arg, int len) {
        if (arg.length() < len) {
            int size = arg.length();
            for (int i = 0; i < len - size; i++) {
                arg += " ";
            }
        }
        if (arg.length() > len)
            arg = arg.substring(0, len);
        return arg;
    }

}
