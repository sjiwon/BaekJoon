package Silver4.baekjoon_1018;

import java.util.*;
import java.io.*;
public class Main {
    static char[][] white = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };
    static char[][] black = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chess = new char[N][M];

        for(int i=0; i<N; i++){ // 체스판 입력
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'B')
                    chess[i][j] = 'B';
                else
                    chess[i][j] = 'W';
            }
        }

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++)
                result = Math.min(result, find(i, j, chess));
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int x, int y, char[][] chess){
        char first = chess[0][0];
        int whiteCount = 0;
        int blackCount = 0;
        // first가 'w' or 'b'

        // 1. first = 'W'
        for(int i=x; i<x+8; i++){
            for(int j=y; j<y+8; j++){
                if((i+j)%2 == 0){
                    if(chess[i][j] != white[i-x][j-y])
                        whiteCount++;
                }
                else{
                    if(chess[i][j] != white[i-x][j-y])
                        whiteCount++;
                }
            }
        }

        // 2. first = 'B'
        for(int i=x; i<x+8; i++){
            for(int j=y; j<y+8; j++){
                if((i+j)%2 == 0){
                    if(chess[i][j] != black[i-x][j-y])
                        blackCount++;
                }
                else{
                    if(chess[i][j] != black[i-x][j-y])
                        blackCount++;
                }
            }
        }

        return Math.min(whiteCount, blackCount);
    }
}
