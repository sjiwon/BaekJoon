package Bronze2.baekjoon_2798;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st1;
    static StringTokenizer st2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N]; // 보유한 카드 저장 배열
        int[] result = new int[(N*(N-1)*(N-2))/6]; // N장 중 3개씩 뽑는 경우의 수

        st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        int z = 0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    result[z] = arr[i]+arr[j]+arr[k];
                    z++;
                }
            }
        }
        Arrays.sort(result);
        int max = result[0];
        for(int i=0; i<result.length; i++){
            if(max<M)
                max = result[i];
            if(max > M){
                max = result[i-1];
                break;
            }
        }
        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
