package Bronze2.baekjoon_1009;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int data = 1;

            for(int j=1; j<=b; j++){
                data = (data*a)%10;
            }

            if(data == 0)
                bw.write(10 + "\n");
            else
                bw.write(data + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
