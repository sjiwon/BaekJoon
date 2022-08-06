package Gold5.baekjoon_2624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int T;
    static int k;
    static int[][] dp;
    static int[][] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        dp = new int[k + 1][T + 1]; // [k][T] = k번째 동전(coin[k])로 T원 만들기
        coin = new int[k + 1][2];

        coin[0][0] = 0;
        coin[0][1] = 0;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.parseInt(st.nextToken());
            coin[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0; // 0원은 못만듦
        }

        for (int i = 0; i <= T; i++) {
            dp[0][i] = 0; // 동전 0으로는 아무것도 못만듦
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= coin[i][1]; j++) {
                int value = coin[i][0] * j;
                if (value <= T) {
                    dp[i][value] = 1;
                }
            }
        }

        for (int coinIndex = 1; coinIndex <= k; coinIndex++) {
            // coin 차례대로 판별
            int cost = coin[coinIndex][0];
            int count = coin[coinIndex][1];
            for (int money = 1; money <= T; money++) {
                // coin[i]로 money원 만들기??
                for (int k = 0; k <= count; k++) {
                    // 개수에 따라서 만들기
//                    System.out.println("## 동전{금액, 개수} = {" + cost + "원, " + count + "개}으로 [" + money + "원]만들기 -> 개수 차례 = " + k + " ##");
                    if (money - (cost * k) < 0) {
                        // money을 초과해서 만들기 때문에 k개로는 만들 필요 X
                        break;
                    }
                    dp[coinIndex][money] += dp[coinIndex - 1][money - (cost * k)];
//                    print();
                }
            }
        }

        System.out.println(dp[k][T]);
    }

//    static void print() {
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j <= T; j++) {
//                System.out.print(dp[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
