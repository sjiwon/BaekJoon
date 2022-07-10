package Bronze2.baekjoon_10996;

import java.io.*;
import java.util.*;
public class Main {
    static char [][] star;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if(N == 1)
            bw.write("*\n");
        else{
            star = new char[N*2][N];
            for(int i=0; i<2*N; i++){
                for(int j=0; j<N; j++){
                    if((i%2==0) && (j%2==0))
                        star[i][j] = '*';
                    else if((i%2!=0) && (j%2!=0))
                        star[i][j] = '*';
                    else
                        star[i][j] = ' ';
                }
            }

            for(int i=0; i<star.length; i++){
                for(int j=0; j<star[i].length; j++)
                    sb.append(star[i][j]);
                sb.append("\n");
            }

            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
