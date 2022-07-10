package Bronze2.baekjoon_10953;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int [] num = new int[T];

        for(int i=0; i<T; i++){
            String text = br.readLine();
            String [] arr = text.split(",");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            num[i] = A+B;
        }

        for(int n : num)
            bw.write(n + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
