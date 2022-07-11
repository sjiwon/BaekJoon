package Gold5.baekjoon_1107;

import java.io.*;
import java.util.*;
public class Main {

    static StringTokenizer st;
    static String N; // 이동하려는 채널의 번호
    static final int START_CHANNEL = 100; // 채널의 시작 위치
    static boolean [] broken = new boolean[10]; // 버튼 중 고장난 버튼 false로 설정

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = br.readLine();
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        if(M>0) { // "고장난 버튼이 존재할 경우에만 고장난 버튼이 주어진다"
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int check = Integer.parseInt(st.nextToken());
                broken[check] = true;
            }
        }

        if(Integer.parseInt(N) == START_CHANNEL) // 이동하려는 채널이 100이면 이동안해도 된다
            bw.write(0 + "\n");
        else if(!isBroken(broken)) {
            /*
            고장난 버튼이 없다 -> Min(100 ~ N까지 +/- 누르기, N의 길이)
             */
            int result = Math.min(Math.abs(100 - Integer.parseInt(N)), N.length());
            bw.write(result + "\n");
        }
        else{
            // (1) +, -를 통해서 100에서 N으로 이동?
            int count = Math.abs(100-Integer.parseInt(N));

            // (2) 최대한 N 근처로 이동해서 +, - 누르기
            for(int i=0; i<1000000; i++){
                // 누를 수 있는 채널 범위 = 0 ~ 999999
                // 각 채널 전부 check?
                int b_count = count_press(i); // i를 버튼만 누르고 가는 경우

                if(b_count != 0){
                    // 채널 i까지 버튼만 누르고 갈 수 있는 경우
                    // 이제 i에서 N까지 +, -를 통해서 접근
                    int cnt = Math.abs(i - Integer.parseInt(N));

                    if(count > b_count + cnt)
                        count = b_count + cnt;
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isBroken(boolean [] broken){
        for (boolean b : broken) {
            if (b)
                return true;
        }
        return false; // 고장난 버튼 없으면 false 리턴
    }

    static int count_press(int n){
        // random한 채널 n에 대해서, n을 단순히 버튼만 눌러서 갈 수 있는가?
        // n에 포함된 숫자버튼들은 고장이 없는지
        int count = 0; // n채널은 버튼 몇번 눌러서 가는지 check
        if(n == 0){
            // n이 0일 경우
            if(broken[0])
                // 0번이 고장 났을 경우 = 못감
                return 0;
            else
                return 1;
        }

        while(n>0){
            int tmp = n%10; // n의 끝자리부터 하나하나 탐색
            if(broken[tmp])
                return 0; // 고장이 났으면 이미 버튼만 누르고 갈 수 없는 상태
            count++;
            n/=10;
        }
        return count;
    }
}
