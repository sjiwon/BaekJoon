package Bronze1.baekjoon_4344;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        for(int i=0; i<C; i++){
            int count = 0; // 평균 넘는 학생 count
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int [] arr = new int[N];

            for(int j=0; j<N; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            double average = get_avg(arr);

            for(int num : arr){
                if(num > average)
                    count++;
            }

            sb.append(String.format("%.3f%%", ((double) count / N)*100)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static double get_avg(int [] arr){
        double sum = 0;
        for(int n : arr)
            sum += n;
        return sum/arr.length;
    }
}
