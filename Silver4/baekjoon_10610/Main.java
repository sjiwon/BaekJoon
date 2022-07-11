package Silver4.baekjoon_10610;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        int [] count = new int[10];

        /*
        :: 30의 배수 조건
        -> (1) 각 자리 숫자 합이 3의 배수
        -> (2) 0이 무조건 1개 이상 존재해야 한다
         */

        int total = 0; // 각 자리 숫자 합
        for(int i=0; i<N.length(); i++){
            int n = Integer.parseInt(N.substring(i, i+1));
            count[n]++;
            total += n;
        }

        if(total%3 != 0 || count[0] == 0) {
            bw.write(-1 + "\n");
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=9; i>=0; i--)
                while(count[i] > 0){
                    sb.append(i);
                    count[i]--;
                }
            bw.write(sb + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
