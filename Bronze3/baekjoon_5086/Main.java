package Bronze3.baekjoon_5086;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0)
                break;

            if(a < b){
                if(b%a == 0)
                    bw.write("factor\n");
                else
                    bw.write("neither\n");
            }
            else{
                if(a%b == 0)
                    bw.write("multiple\n");
                else
                    bw.write("neither\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
