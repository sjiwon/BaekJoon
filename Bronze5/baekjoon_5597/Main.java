package Bronze5.baekjoon_5597;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] count = new int[31];
        count[0] = 1;

        for(int i=0; i<28; i++)
            count[Integer.parseInt(br.readLine())]++;

        for(int i=0; i<31; i++){
            if(count[i] == 0)
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
