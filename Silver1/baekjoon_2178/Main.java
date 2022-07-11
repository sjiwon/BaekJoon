package Silver1.baekjoon_2178;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int M;
    static int [][] maze; // 미로
    static boolean [][] visited;
    static int [] dx = {-1, 1, 0, 0}; // 상 하
    static int [] dy = {0, 0, -1, 1}; // 좌 우

    static class Point{
        private int x, y;
        Point(int x, int y){
            this.x = x; this.y = y;
        }
        int getX(){return x;}
        int getY(){return y;}
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        bw.write(maze[N-1][M-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true ;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int cur_x = p.getX() + dx[i];
                int cur_y = p.getY() + dy[i];
                if(cur_x>=0 && cur_y>=0 && cur_x<N && cur_y<M){
                    if(maze[cur_x][cur_y] == 1 && !visited[cur_x][cur_y]){
                        queue.offer(new Point(cur_x, cur_y));
                        visited[cur_x][cur_y] = true;
                        maze[cur_x][cur_y] = maze[p.getX()][p.getY()] + 1;
                    }
                }
            }
        }
    }
}
