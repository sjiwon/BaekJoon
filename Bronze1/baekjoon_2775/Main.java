package Bronze1.baekjoon_2775;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][]arr = new int[15][15];
        for(int i=0; i<15; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(arr[k][n]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
