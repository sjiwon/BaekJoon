package Gold5.baekjoon_2671;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(100+1+|01)+$");
        String line = br.readLine();
        Matcher check = pattern.matcher(line);

        if (check.find()) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }
    }
}

/*
10010111
>> NOISE

100000000001101
>> SUBMARINE
 */