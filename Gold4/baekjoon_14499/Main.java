package Gold4.baekjoon_14499;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int N; // 지도 세로 크기
    static int M; // 지도 가로 크기
    static int x, y; // 주사위 좌표
    static int K; // 명령 개수
    static int [][] map; // 지도 N x M
    static int [] stone = {0, 0, 0, 0, 0, 0}; // 초기 주사위 각 면의 숫자
    /*
    정면에서 봤을 때 -> 상 하 좌 우 앞 뒤
     */

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        /*
        ## 명령 ##
        1 = 동쪽으로 굴리기
        2 = 서쪽으로 굴리기
        3 = 북쪽으로 굴리기
        4 = 남쪽으로 굴리기
         */
        int [] cmd = new int[K];
        for(int i=0; i<K; i++)
            cmd[i] = Integer.parseInt(st.nextToken());

        int cur_x = x; // 주사위의 현재 x좌표
        int cur_y = y; // 주사위의 현재 y좌표
        for(int n : cmd){
            // 명령 실행
            if(n == 1){
                // 동쪽으로 굴리기 | cur_y += 1
                if(isRange(cur_x, cur_y + 1)){
                    cur_y += 1;
                    roll(1);
                    changeTopStone(cur_x, cur_y);

                    bw.write(stone[0] + "\n");
                }
            }
            else if(n == 2){
                // 서쪽으로 굴리기 | cur_y -= 1
                if(isRange(cur_x, cur_y - 1)){
                    cur_y -= 1;
                    roll(2);
                    changeTopStone(cur_x, cur_y);

                    bw.write(stone[0] + "\n");
                }
            }
            else if(n == 3){
                // 북쪽으로 굴리기 | cur_x -= 1
                if(isRange(cur_x - 1, cur_y)){
                    cur_x -= 1;
                    roll(3);
                    changeTopStone(cur_x, cur_y);

                    bw.write(stone[0] + "\n");
                }
            }
            else{
                // 남쪽으로 굴리기 | cur_x += 1
                if(isRange(cur_x + 1, cur_y)){
                    cur_x += 1;
                    roll(4);
                    changeTopStone(cur_x, cur_y);

                    bw.write(stone[0] + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void changeTopStone(int cur_x, int cur_y){
        if(map[cur_x][cur_y] == 0){
            map[cur_x][cur_y] = stone[1];
        }
        else{
            stone[1] = map[cur_x][cur_y];
            map[cur_x][cur_y] = 0;
        }
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }

    static void roll(int n){
        // 명령에 따라 주사위 굴리기
        /* int [] stone 결과 = 굴리고 정면에서 본 각 면의 숫자
        -> 상 하 좌 우 앞 뒤 :: 0 1 2 3 4 5
         */
        if(n == 1){
            // 동쪽으로 굴리기 :: 정면에서 봤을 때 앞 뒤는 변화 X
            // 좌 -> 상 / 하 -> 좌 / 우 -> 하 / 상 -> 우
            int tmp = stone[0];
            stone[0] = stone[2]; // 좌 -> 상
            stone[2] = stone[1]; // 하 -> 좌
            stone[1] = stone[3]; // 우 -> 하
            stone[3] = tmp; // 상 -> 우

        }
        else if(n == 2){
            // 서쪽으로 굴리기 :: 정면에서 봤을 때 앞 뒤는 변화 X
            // 우 -> 상 / 하 -> 우 / 좌 -> 하 / 상 -> 좌
            int tmp = stone[0];
            stone[0] = stone[3]; // 우 -> 상
            stone[3] = stone[1]; // 하 -> 우
            stone[1] = stone[2]; // 좌 -> 하
            stone[2] = tmp; // 상 -> 좌
        }
        else if(n == 3){
            // 북쪽으로 굴리기 :: 정면에서 봤을 때 좌 우는 변화 X
            // 앞 -> 상 / 하 -> 앞 / 뒤 -> 하 / 상 -> 뒤
            int tmp = stone[0];
            stone[0] = stone[4]; // 앞 -> 상
            stone[4] = stone[1]; // 하 -> 앞
            stone[1] = stone[5]; // 뒤 -> 하
            stone[5] = tmp; // 상 -> 뒤
        }
        else{
            // 남쪽으로 굴리기 :: 정면에서 봤을 때 좌 우는 변화 X
            // 뒤 -> 상 / 하 -> 뒤 / 앞 -> 하 / 상 -> 앞
            int tmp = stone[0];
            stone[0] = stone[5]; // 뒤 -> 상
            stone[5] = stone[1]; // 하 -> 뒤
            stone[1] = stone[4]; // 앞 -> 하
            stone[4] = tmp; // 상 -> 앞
        }
    }
}
