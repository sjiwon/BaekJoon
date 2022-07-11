package Silver1.baekjoon_7562;

import java.io.*;
import java.util.*;
public class Main {
    static class Point{
        private int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }

    static StringTokenizer st;
    static boolean [][] visited;
    static int [][] chess;
    static int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int [] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int X; // 체스판 한 변의 길이
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            X = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            chess = new int[X][X];
            visited = new boolean[X][X];

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            // 현재 나이트 좌표 (x1, y1)

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 나이트 목표 좌표 (x2, y2)

            bw.write(bfs(x1, y1, x2, y2) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x1, int y1, int x2, int y2){
        Queue<Point> q = new LinkedList<>();
        visited[x1][y1] = true;
        q.offer(new Point(x1, y1));

        while(!q.isEmpty()){
            Point now = q.poll();

            if(now.getX() == x2 && now.getY() == y2)
                return chess[x2][y2];

            for(int i=0; i<8; i++){
                int cur_x = now.getX() + dx[i];
                int cur_y = now.getY() + dy[i];

                if(isRange(cur_x, cur_y)){
                    if(!visited[cur_x][cur_y]){
                        visited[cur_x][cur_y] = true;
                        chess[cur_x][cur_y] = chess[now.getX()][now.getY()] + 1;
                        q.offer(new Point(cur_x, cur_y));
                    }
                }
            }
        }
        return -1;
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<X && 0<=y && y<X;
    }
}
