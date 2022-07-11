package Gold5.baekjoon_14503;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N; // map 세로 길이
    static int M; // map 가로 길이
    static int [][] map;
    static boolean [][] clean;
    static int [] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int [] dy = {0, 1, 0, -1}; // 북 동 남 서
    /*
    0 = 북, 1 = 동, 2 = 남, 3 = 서

    ## index를 이용해서 왼쪽으로 방향 전환
    0 -> 3 / 1 -> 0 / 2 -> 1 / 3 -> 2
    (index + 3) % 4

    ## index를 이용해서 뒤로 방향 전환
    0 -> 2 / 1 -> 3 / 2 -> 0 / 3 -> 1
    (index + 2) % 4
     */
    static int count = 0; // 로봇 청소기가 청소한 칸의 개수

    static class Point{
        private int x, y, direction; // x좌표, y좌표, (x, y)좌표에서의 바라보는 방향
        Point(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
        int getDirection(){
            return direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        clean = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 현재 로봇의 x좌표
        int y = Integer.parseInt(st.nextToken()); // 현재 로봇의 y좌표
        int direction = Integer.parseInt(st.nextToken()); // 현재 로봇이 바라보고 있는 방향

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Robot(x, y, direction);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }

    static void Robot(int x, int y, int direction){
        /*
        청소 가능한데 아직 안된 구역 >> "7"로 설정하기 : 청소 예약 구역
        -> "7"로 설정한 구역 : !clean이면 청소하기 / clean이면 이미 청소한 구역
         */
        Queue<Point> q = new LinkedList<>();
        // q.offer = 해당 구역으로 이동한다는 뜻
        map[x][y] = 7; // 청소 예약
        q.offer(new Point(x, y, direction));

        while(!q.isEmpty()){
            Point p = q.poll();
            int cur_d = p.getDirection();
            int cur_x = p.getX();
            int cur_y = p.getY();
            int nx, ny;
            int nd = cur_d;
            boolean check = false; // 네 방향 모두 청소 or 벽이면 "false" 유지

            if(map[cur_x][cur_y] == 7 && !clean[cur_x][cur_y]) {
                // 해당 칸이 청소 예약 칸(7)이고 아직 청소 안되어있으면(!clean)
                count++;
                clean[cur_x][cur_y] = true; // 청소 완료 표시
            }

            for(int i=0; i<4; i++){
                nd = (nd + 3) % 4; // 왼쪽으로 돌아본 방향
                /*
                nd = (cur_d + 3) % 4의 문제점
                -> for문을 돌 때마다 현재 좌표의 방향(cur_d)을 기준으로 계속 똑같은 곳을 바라보게 된다
                -> for문을 다시 돈다는 의미는, 현재 (x, y)에서 왼쪽은 청소가 이미 되어있거나 할 수 없는 구역
                -> 따라서, 현재 (x, y)의 왼쪽을 기준으로 다시 왼쪽을 바라봐야 한다
                 */
                nx = cur_x + dx[nd]; // 다음 x 좌표
                ny = cur_y + dy[nd]; // 다음 y 좌표

                if(map[nx][ny] != 0)
                    // 청소할 수 없는 구역이면 다시 왼쪽으로 한번 더 돌기
                    continue;

                if(isRange(nx, ny) && map[nx][ny] == 0) {
                    q.offer(new Point(nx, ny, nd));
                    map[nx][ny] = 7; // 7 = 청소 예약 위치 & 아직 청소 안함
                    check = true;
                    break;
                    // 이 상태는 왼쪽에 청소할 칸이 존재한다는 의미
                    // 따라서, 왼쪽으로 그냥 전진하고, for문을 다시 돌아서 왼쪽으로 또 돌 필요가 없다
                }
            }

            if(!check){
                // 네 방향 모두 청소 or 벽인 상태
                nd = (cur_d + 2) % 4; // 현재 바라보는 방향에서 뒤쪽을 본 상태
                nx = cur_x + dx[nd];
                ny = cur_y + dy[nd];

                if(map[nx][ny] == 1)
                    break;
                else{
                    map[nx][ny] = 7;
                    nd = (nd + 2) % 4; // 뒤집은 방향 다시 원상복구
                    // 원상복구를 안하면 (2-c)의 "바라보는 방향을 유지한 채로"에 어긋나게 된다
                    q.offer(new Point(nx, ny, nd));
                }
            }
        }
    }
}


