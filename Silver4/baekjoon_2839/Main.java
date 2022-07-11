package Silver4.baekjoon_2839;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while(true){
            if(N%5==0){
                result+=N/5;
                bw.write(result+"\n");
                break;
            }
            else{
                N-=3;
                result++;
            }
            if(N<0) {
                bw.write("-1\n");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
