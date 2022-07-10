package Bronze2.baekjoon_5585;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] mn = {500, 100, 50, 10, 5, 1};

        int cost = Integer.parseInt(br.readLine());
        int money = 1000-cost;

        int count = 0; // 잔돈 개수

        for (int j : mn) {
            while (money >= j) {
                count++;
                money -= j;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
