package Bronze3.baekjoon_10995;

import java.io.*;
import java.util.*;
public class Main {
    static char [][] star;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N==1)
            bw.write("*");
        else{
            star = new char[N][2*N];
            for(int i=0; i<N; i++){
                for(int j=0; j<2*N; j++){
                    if((i%2==0) && (j%2==0))
                        star[i][j] = '*';
                    else if((i%2!=0) && (j%2!=0))
                        star[i][j] = '*';
                    else
                        star[i][j] = ' ';
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<2*N; j++)
                    sb.append(star[i][j]);
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
