package Gold5.baekjoon_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N; // map 크기
    static int L; // L명 이상
    static int R; // R명 이하
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Union{
        private int x;
        private int y;

        public Union(int x, int y) {
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

    static List<Union> unionList; // bfs통해서 연합을 찾을 때 할당
    static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        populationMove();
        System.out.println(moveCount);
    }

    static void populationMove(){
        while(true){
            boolean isMoved = false;
            visited = new boolean[N][N]; // step마다 국경선 열기위한 visited 배열

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]) { // (i, j)를 기준으로 국경선 열기
                        int unionSum = bfs(i, j); // 국경선 열고나서 계산한 연합의 총 인구수
                        if (unionList.size() > 1) {
                            integratePopulation(unionSum); // 인구 분배
                            isMoved = true; // 이동 완료
                        }
                    }
                }
            }

            if(!isMoved){ // 인구이동 없으면 종료
                return;
            }
            moveCount++;
        }
    }

    static int bfs(int x, int y){
        int unionSum = 0; // 연합의 총 인구수

        Queue<Union> queue = new LinkedList<>(); // 연합에 속한 나라 넣기 (For BFS)
        unionList = new ArrayList<>(); // 연합에 속한 나라 넣기 (인구 분배를 위한 리스트 할당)

        visited[x][y] = true; // (x, y)부터 연합 찾기
        queue.offer(new Union(x, y));
        unionList.add(new Union(x, y));
        unionSum += map[x][y];

        while(!queue.isEmpty()){
            Union union = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = union.getX() + dx[i];
                int nextY = union.getY() + dy[i];

                if(isRange(nextX, nextY) && !visited[nextX][nextY]){
                    if(canUnion(union, nextX, nextY)){ // 조건맞으면 국경선 열기
                        visited[nextX][nextY] = true; // 연합에 포함되었으니까 true
                        queue.offer(new Union(nextX, nextY));
                        unionList.add(new Union(nextX, nextY));
                        unionSum += map[nextX][nextY];
                    }
                }
            }
        }

        return unionSum;
    }

    static void integratePopulation(int unionSum){
        for(Union union : unionList){
            map[union.getX()][union.getY()] = (int)(unionSum / unionList.size()); // 연합 나라 size만큼 인구 분배
        }
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static boolean canUnion(Union current, int nextX, int nextY){
        int diff = Math.abs(map[current.getX()][current.getY()] - map[nextX][nextY]); // 국경선간 두 나라간의 인구수 차이
        return L <= diff && diff <= R;
    }
}

/*
2 20 50
50 30
20 40
>> 1

2 40 50
50 30
20 40
>> 0

2 20 50
50 30
30 40
>> 1

3 5 10
10 15 20
20 30 25
40 22 10
>> 2

4 10 50
10 100 20 90
80 100 60 70
70 20 30 40
50 20 100 10
>> 3
 */