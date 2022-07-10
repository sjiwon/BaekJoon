package Bronze2.baekjoon_3040;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arr = new int[9];

        int sum = 0;
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int spy1 = 0, spy2 = 0;

        for(int i=0; i<9; i++){
            for(int j=1; j<9; j++){
                if(sum-arr[i]-arr[j] == 100){
                    spy1 = arr[i];
                    spy2 = arr[j];
                    break;
                }
            }
        }

        for(int n : arr){
            if(n==spy1 || n==spy2)
                continue;
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
