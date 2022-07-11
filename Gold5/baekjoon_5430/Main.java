package Gold5.baekjoon_5430;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        boolean reverse = false; // 함수에 R나오면 true로 바꾸고 앞에서 삭제

        int T = Integer.parseInt(br.readLine()); // 테스트 개수
        for(int i=0; i<T; i++){
            String text = br.readLine(); // 함수 p
            String [] p = text.split("");
            int n = Integer.parseInt(br.readLine()); // 배열 개수
            String text2 = br.readLine(); // 배열에 들어 있는 수
            StringTokenizer st = new StringTokenizer(text2, "[],");
            while(st.hasMoreTokens()){
                dq.offer(Integer.parseInt(st.nextToken()));
            }
            bw.write(AC(dq, p) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    static String AC(ArrayDeque<Integer> dq, String[]p){
        boolean reverse = false; // 함수에 R나오면 true로 바꾸고 앞에서 삭제
        for(int j=0; j<p.length; j++){
            if(p[j].equals("R")){
                reverse = !reverse;
            }
            else{
                if(dq.size() == 0)
                    return "error";
                else{
                    if(reverse)
                        dq.pollLast();
                    else
                        dq.pollFirst();
                }
            }
        } // 함수 연산 실행

        StringBuilder sb = new StringBuilder("[");
        while(!dq.isEmpty()){ // dq에 남아있는 정수들 출력
            sb.append(reverse ? dq.pollLast() : dq.pollFirst());
            if(dq.size() != 0)
                sb.append(',');
        }
        sb.append("]");

        return sb.toString();
    }
}
