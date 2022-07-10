package Bronze2.baekjoon_10987;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        String new_w = word.replaceAll("[^aeiou]", "");

        bw.write(new_w.length() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
