package Bronze4.baekjoon_10808;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] count = new int[26];

        String s = br.readLine();
        char [] word = s.toCharArray();

        // 아스키 코드 a ~ z = 97 ~ 122

        for(char w : word){
            count[w-97]++;
        }

        for(int n : count)
            bw.write(n + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
