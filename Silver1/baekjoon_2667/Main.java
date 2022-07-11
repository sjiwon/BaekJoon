package Silver1.baekjoon_2667;

import java.io.*;
import java.util.*;
public class Main {
    static int N; // 지도의 크기 (정사각형)
    static int [][] apart; // 아파트 2차원 배열 N * N
    static boolean [][] visited; // 방문 여부 파악
    static int [] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int [] dy = {0, 0, -1, 1}; // 상 하 좌 우
    static ArrayList<Integer> list = new ArrayList<>(); // 단지 각각에 있는 집 개수 저장

    static class Point{
        private int x, y;
        Point(int x, int y){
            this.x = x; this.y = y;
        }
        int getX(){return x;}
        int getY(){return y;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        apart = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                apart[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(apart[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");
        for(int i=0; i<list.size(); i++)
            bw.write(list.get(i) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y){
        int house_count = 0; // 단지 내에 있는 집의 개수
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            house_count++;
            // Queue에 존재하는 좌표들은 전부 해당 좌표의 값이 1
            // 그러므로 단지내에 형성된 아파트라서 개수세기

            for(int i=0; i<4; i++){
                // 0 = 상, 1 = 하, 2 = 좌, 3 = 우
                // 상,하 = x변화
                // 좌,우 = y변화
                int cur_x = p.getX() + dx[i];
                int cur_y = p.getY() + dy[i];
                if(cur_x>=0 && cur_y>=0 && cur_x<N && cur_y<N){
                    if(apart[cur_x][cur_y] == 1 && !visited[cur_x][cur_y]) {
                        queue.offer(new Point(cur_x, cur_y));
                        visited[cur_x][cur_y] = true;
                    }
                }
            }
        }
        list.add(house_count);
    }
}
