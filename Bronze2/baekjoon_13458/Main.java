package Bronze2.baekjoon_13458;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 시험장 개수
        long count = N; // 감독관 초기 필요 인원

        int [] arr = new int[N]; // 각 시험장 응시자 수 저장 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 총감독관 감시
        int C = Integer.parseInt(st.nextToken()); // 부감독관 감시

        for(int i=0; i<N; i++)
            arr[i]-=B;

        for(int n : arr){
            if(n < 0)
                continue;
            else{
                if(n%C != 0){
                    count += n/C + 1;
                }
                else
                    count += n/C;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
