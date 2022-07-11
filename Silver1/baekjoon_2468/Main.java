package Silver1.baekjoon_2468;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int maxSafeArea; // 안전한 영역의 최대 개수

    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    static class Point{
        private int x;
        private int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!isAllUnSafe(map)){
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j] > 0){
                        check(map, i, j);
                        count++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, count);

            Raining(map);
            initVisited(visited);
        }

        System.out.println(maxSafeArea);
    }

    static void check(int [][] map, int x, int y){
        Queue<Point> list = new LinkedList<>();
        list.offer(new Point(x, y));
        visited[x][y] = true;

        while(!list.isEmpty()){
            Point p = list.poll();

            for(int i=0; i<4; i++){
                int next_x = p.getX() + dx[i];
                int next_y = p.getY() + dy[i];

                if(isRange(next_x, next_y)){
                    if(!visited[next_x][next_y] && map[next_x][next_y] > 0) {
//                        System.out.println(next_x + " " + next_y);
                        visited[next_x][next_y] = true;
                        list.offer(new Point(next_x, next_y));
                    }
                }
            }
        }
    }

    static void initVisited(boolean [][] visited){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visited[i][j] = false;
            }
        }
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    static boolean isAllUnSafe(int [][] map){
        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] <= 0){
                    count++;
                }
            }
        }

        return count == N*N;
    }

    static void Raining(int [][] map){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] > 0){
                    map[i][j] -= 1;
                }
            }
        }
    }
}

