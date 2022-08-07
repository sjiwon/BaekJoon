package Silver5.baekjoon_1676;

/*
5! = 120 (1개)
    -> 5 / 5 = 1
10! = 3628800 (2개)
    -> 10 / 5 = 2
15! = 1307674368000 (3개)
    -> 15 / 5 = 3
20! = 2432902008176640000 (4개)
    -> 20 / 5 = 4
25! = 15511210043330985984000000 (6개)
    -> 25 / 5 = 5 (+1)
30! = 265252859812191058636308480000000 (7개)
    -> 30 / 5 = 6 (+1)
35! = 10333147966386144929666651337523200000000 (8개)
    -> 35 / 5 = 7 (+1)
40! = 815915283247897734345611269596115894272000000000 (9개)
    -> 40 / 5 = 8 (+1)
45! = 119622220865480194561963161495657715064383733760000000000 (10개)
    -> 45 / 5 = 9 (+1)
50! = 30414093201713378043612608166064768844377641568960512000000000000 (12개)
    -> 50 / 5 = 10 (+2)

>> 나머지가 5이상이면 5로 나눈 몫을 한번 더 더해주기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while (N >= 5) {
            result += N / 5; // 5로 나눈 몫 누적으로 더하기
            N /= 5;
        }
        System.out.println(result);
    }
}
