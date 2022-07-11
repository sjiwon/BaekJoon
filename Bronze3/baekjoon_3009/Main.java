package Bronze3.baekjoon_3009;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] x = new int[3];
        int [] y = new int[3];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(count(x) + " " + count(y) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int count(int [] arr){
        int n1 = arr[0];
        int n2 = arr[1];
        int n3 = arr[2];

        if(n1 == n2)
            return n3;
        else if(n1 == n3)
            return n2;
        else
            return n1;
    }
}
