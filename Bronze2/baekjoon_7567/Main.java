package Bronze2.baekjoon_7567;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char [] arr = br.readLine().toCharArray();

        int height = 10; // 초기 높이

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1])
                height += 5;
            else
                height += 10;
        }

        bw.write(height + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
