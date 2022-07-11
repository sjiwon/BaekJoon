package Silver2.baekjoon_18111;

import java.io.*;
import java.util.*;
public class Main {
    static int N; // 세로
    static int M; // 가로
    static int B; // 보유한 블록
    static int [][] mine;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 블록 캐기 = 2초, 블록 쌓기 = 1초

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        mine = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                mine[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = get_min(mine);
        int max = get_max(mine);
        int min_Time = Integer.MAX_VALUE;
        int height = 0; // 최대 256

        for(int i=min; i<=max; i++){
            int second = 0;
            int inventory = B;

            for(int j=0; j<mine.length; j++){
                for(int k=0; k<mine[j].length; k++){
                    int diff = mine[j][k] - i; // 해당 블록에서 최대 / 최소의 차이

                    if(diff>0){ // 블록 제거
                        second += Math.abs(diff)*2;
                        inventory += Math.abs(diff);
                    }
                    else if(diff<0){
                        second += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory >= 0){
                if(second <= min_Time){
                    min_Time = second;
                    height = i;
                }
            }
        }

        bw.write(min_Time + " " +height);

        bw.flush();
        bw.close();
        br.close();
    }

    static int get_max(int [][] mine){
        int max = mine[0][0];
        for(int i=0; i<mine.length; i++){
            for(int j=0; j<mine[i].length; j++){
                if(mine[i][j] > max)
                    max = mine[i][j];
            }
        }
        return max;
    }

    static int get_min(int [][] mine){
        int min = mine[0][0];
        for(int i=0; i<mine.length; i++){
            for(int j=0; j<mine[i].length; j++){
                if(mine[i][j] < min)
                    min = mine[i][j];
            }
        }
        return min;
    }
}
