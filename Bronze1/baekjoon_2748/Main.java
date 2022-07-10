package Bronze1.baekjoon_2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [] Memoization = new long[91];


        Memoization[0] = 0;
        Memoization[1] = 1;

        for(int i=2; i<=n; i++){
            Memoization[i] = Memoization[i-1] + Memoization[i-2];
        }

        System.out.println(Memoization[n]);
    }
}
