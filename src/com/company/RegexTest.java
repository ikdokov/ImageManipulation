package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RegexTest{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            Pattern pattern = Pattern.compile("<([a-zA-Z1-9]\\w+(\\s[a-zA-Z1-9]\\w+)*)>(?<content>.*)<\\/\\1>");

            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                System.out.println(matcher.group("content"));
            } else {
                System.out.println("None");
            }

            testCases--;
        }
    }
}