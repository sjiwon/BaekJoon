package Silver5.baekjoon_10815;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] standard = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            standard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(standard); // BinarySearch는 정렬된 배열에서만 올바르게 동작

        int M = Integer.parseInt(br.readLine());
        int [] compare = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            compare[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int exist = BinarySearch(standard, 0, standard.length - 1, compare[i]);

            if(exist != -1){
                sb.append("1 ");
            }
            else{
                sb.append("0 ");
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int BinarySearch(int [] list, int left, int right, int K){
        if (left > right){
            return -1;
        }

        int mid = (left + right) / 2;

        if(list[mid] > K){
            return BinarySearch(list, left, mid - 1, K);
        }
        else if(list[mid] < K){
            return BinarySearch(list, mid + 1, right, K);
        }
        else{
            return mid;
        }
    }
}

