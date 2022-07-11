package Silver4.baekjoon_1620;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도감에 있는 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제 개수

        HashMap<String, Integer> hm = new HashMap<>(); // 이름 -> 인덱스
        String [] list = new String[N+1]; // 인덱스 -> 이름
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            hm.put(name, i);
            list[i] = name;
        }

        for(int t=0; t<M; t++){
            // 내가 문제 맞추기
            String qst = br.readLine();

            if(Character.isDigit(qst.charAt(0))){
                // qst가 숫자인 경우
                bw.write(list[Integer.parseInt(qst)] + "\n");
            }
            else{
                bw.write(hm.get(qst) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

