package Gold5.baekjoon_7576;

import java.io.*;
import java.util.*;
public class Main {
    static int M; // 상자 세로 수
    static int N; // 상자 가로 수
    static int [][] tomato;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    static StringTokenizer st;
    static Queue<Point> q = new LinkedList<>();

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

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<tomato.length; i++){
            for(int j=0; j<tomato[i].length; j++){
                if(tomato[i][j] == 1)
                    q.offer(new Point(i, j));
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
            for(int i=0; i<4; i++){
                int cur_x = p.getX() + dx[i];
                int cur_y = p.getY() + dy[i];
                if(cur_x >= 0 && cur_y >= 0 && cur_x < N && cur_y < M){
                    if(tomato[cur_x][cur_y] == 0){
                        tomato[cur_x][cur_y] = tomato[p.getX()][p.getY()] + 1;
                        q.offer(new Point(cur_x, cur_y));
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomato[i][j] == 0)
                    return -1;
            }
        }

        if(get_max(tomato) == 1)
            return 0;
        else
            return get_max(tomato) - 1;
    }

    static int get_max(int [][] tomato){
        int max = -2;
        for(int i=0; i<tomato.length; i++){
            for(int j=0; j<tomato[i].length; j++){
                if(tomato[i][j] > max)
                    max = tomato[i][j];
            }
        }
        return max;
    }
}
