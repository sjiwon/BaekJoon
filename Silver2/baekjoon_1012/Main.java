package Silver2.baekjoon_1012;

import java.io.*;
import java.util.*;

public class Main {
    static int M; // 가로 길이
    static int N; // 세로 길이
    static int K; // 배추 개수
    static int [][] ground; // 배추 밭
    static boolean [][] visited; // 방문 여부
    static int [] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int [] dy = {0, 0, -1, 1}; // 상 하 좌 우

    static StringTokenizer st;

    static class Point{
        private int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){return x;}
        int getY(){return y;}
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int bug_count = 0; // 벌레 개수

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            ground = new int[N][M];
            visited = new boolean[N][M];

            for(int k=0; k<K; k++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                ground[Y][X] = 1;
                /*
                문제에서 가로 길이 -> 세로 길이 순으로 입력을 받으니까
                배열의 인덱스는 [세로][가로]로 insert를 해야 index error가 발생하지 않는다
                 */
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(ground[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        bug_count += 1;
                    }
                }
            }

            bw.write(bug_count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y){
        // bfs가 종료 되면 bfs 완료지역은 벌레 1마리 존재
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int cur_x = p.getX() + dx[i];
                int cur_y = p.getY() + dy[i];
                // 상 하 좌 우 탐색

                if (isRange(cur_x, cur_y)) {
                    if (!visited[cur_x][cur_y] && ground[cur_x][cur_y] == 1) {
                        visited[cur_x][cur_y] = true;
                        q.offer(new Point(cur_x, cur_y));
                    }
                }
            }
        }
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }
}
