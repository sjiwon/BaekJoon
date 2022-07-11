package Gold4.baekjoon_1261;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int [][] map; // 각 좌표(x, y)의 가중치 저장 배열
    static boolean [][] visited;
    static int [] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int [] dy = {0, 0, -1, 1}; // 상 하 좌 우
    static int N, M;

    static class Point implements Comparable<Point>{
        private int x, y, brk; // brk = 해당 좌표까지 가면서 깬 벽의 개수
        Point(int x, int y, int brk){
            this.x = x; this.y = y; this.brk = brk;
        }
        int getX(){return x;}
        int getY(){return y;}
        int getBrk(){return brk;}

        @Override
        public int compareTo(Point o) {
            return this.getBrk() - o.getBrk();
            // 벽돌 깬 수가 적은 좌표부터 판별
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String [] line = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        bw.write(dijkstra(N, M) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<M;
    }

    static int dijkstra(int N, int M){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while(!pq.isEmpty()){
            Point p = pq.poll();

            if(p.getX() == N-1 && p.getY() == M-1){
                return p.getBrk();
            }

            for(int i=0; i<4; i++){
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if(isRange(nx, ny)){
                    if(!visited[nx][ny] && map[nx][ny] == 0){
                        // 다음 좌표로 갈 때 벽이 없는 상태
                        pq.offer(new Point(nx, ny, p.getBrk()));
                    }
                    else if(!visited[nx][ny] && map[nx][ny] == 1){
                        // 다음 좌표로 갈 때 벽을 깨야 하는 경우
                        pq.offer(new Point(nx, ny, p.getBrk() + 1));
                    }
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}

