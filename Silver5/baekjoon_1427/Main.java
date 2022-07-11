package Silver5.baekjoon_1427;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] count = new int[10];

        while(N != 0){
            count[N%10]++;
            N/=10;
        }
        for(int i=9; i>=0; i--){
            while(count[i]-- > 0)
                System.out.print(i);
        }
    }
}
