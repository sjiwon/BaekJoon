package Gold4.baekjoon_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
전체 벽세우기 경우의 수 = 64C3 = 64*63*62/6 = 41664
>> 완전 탐색 (모든 벽세우기 경우의 수) + Backtracking
    -> 벽세우고(Backtracking) + 안전 영역 탐색(BFS)
 */

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int safeArea = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BuildingWall(0); // Backtracking
        System.out.println(safeArea);
    }

    static void BuildingWall(int count){
        if(count == 3){
            // 벽 3개 다세우고 bfs 통해서 바이러스 퍼뜨리기
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1; // 벽 세우기
                    BuildingWall(count + 1);
                    map[i][j] = 0; // 벽 제거 (rollback)
                }
            }
        }
    }

    static void bfs(){
        int[][] copyMap = copyMap();
        Queue<Point> queue = new LinkedList<>();
        insertVirus(queue, copyMap);

        while(!queue.isEmpty()){
            Point poll = queue.poll();
            visited[poll.getX()][poll.getY()] = true;

            for(int i=0; i<4; i++){
                // 동서남북 바이러스 퍼뜨리기
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];

                if(isRange(nextX, nextY) && !visited[nextX][nextY] && copyMap[nextX][nextY] == 0){
                    copyMap[nextX][nextY] = 2; // (nextX, nextY)에 바이러스 놓기
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }

        getSafeArea(copyMap);
        initVisited(); // 방문 여부 초기화
    }

    static void initVisited(){
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }

    static void getSafeArea(int[][] map){
        int count = 0;

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }

        safeArea = Math.max(safeArea, count);
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static int[][] copyMap(){
        int[][] copyMap = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }

    static void insertVirus(Queue<Point> queue, int[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 2){
                    queue.offer(new Point(i, j));
                }
            }
        }
    }
}
