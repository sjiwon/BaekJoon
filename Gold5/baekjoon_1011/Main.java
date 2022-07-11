package Gold5.baekjoon_1011;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            bw.write(get_count(x, y) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long get_count(long x, long y){
        long distance = y-x;
        long sqrt_d = (long) Math.sqrt(distance);

        if(distance == sqrt_d) // 제곱수
            return 2*sqrt_d - 1;
        else if((distance > Math.pow(sqrt_d, 2)) && (distance <= sqrt_d*(sqrt_d + 1)))
            return 2*sqrt_d;
        else if((distance > sqrt_d*(sqrt_d + 1)) && (distance <= sqrt_d*(sqrt_d + 2)))
            return 2*sqrt_d + 1;

        return -1;
    }
}
