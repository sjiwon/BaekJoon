package Gold5.baekjoon_7569;

import java.io.*;
import java.util.*;
public class Main {
    static int M; // 상자 세로 수
    static int N; // 상자 가로 수
    static int H; // 상자 높이
    static int [][][] tomato;
    static int [] dx = {-1, 1, 0, 0, 0, 0}; // 상 하
    static int [] dy = {0, 0, -1, 1, 0, 0}; // 좌 우
    static int [] dz = {0, 0, 0, 0, 1, -1}; // 위 아래
    static StringTokenizer st;
    static Queue<Point> q = new LinkedList<>();

    static class Point{
        private int x, y, z;

        Point(){

        }

        Point(int z, int x, int y){
            this.x = x; this.y = y; this.z = z;
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

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++)
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(tomato[i][j][k] == 1)
                        q.offer(new Point(i, j, k));
                }
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<6; i++){
                int cur_x = p.getX() + dx[i];
                int cur_y = p.getY() + dy[i];
                int cur_z = p.getZ() + dz[i];
                if(cur_x >= 0 && cur_y >= 0 && cur_z >= 0 && cur_x < N && cur_y < M && cur_z < H){
                    if(tomato[cur_z][cur_x][cur_y] == 0){
                        q.offer(new Point(cur_z, cur_x, cur_y));
                        tomato[cur_z][cur_x][cur_y] = tomato[p.getZ()][p.getX()][p.getY()] + 1;
                    }
                }
            }
        }
        if(get_zero(tomato))
            return -1;
        if(get_max(tomato) == 1)
            return 0;
        else
            return get_max(tomato) - 1;
    }

    static int get_max(int [][][] tomato){
        int max = -2;
        for(int i=0; i<tomato.length; i++){
            for(int j=0; j<tomato[i].length; j++){
                for(int k=0; k<tomato[i][j].length; k++){
                    if(tomato[i][j][k] > max)
                        max = tomato[i][j][k];
                }
            }
        }
        return max;
    }

    static boolean get_zero(int [][][] tomato){
        for(int i=0; i<tomato.length; i++){
            for(int j=0; j<tomato[i].length; j++){
                for(int k=0; k<tomato[i][j].length; k++){
                    if(tomato[i][j][k] == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
