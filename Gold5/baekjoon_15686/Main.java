package Gold5.baekjoon_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static int [][] city;

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
    static List<Point> homeList = new ArrayList<>(); // 집 위치 리스트
    static List<Point> chickenHomeList = new ArrayList<>(); // 치킨 집 위치 리스트
    static boolean [] visited; // 치킨집 고르기 (M개)
    static int result = Integer.MAX_VALUE; // 도시의 치킨 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N]; // ~ 10MB

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1){
                    // 집
                    homeList.add(new Point(i, j));
                } else if(city[i][j] == 2){
                    // 치킨집
                    chickenHomeList.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chickenHomeList.size()];
        chicken(0, 0);
        System.out.println(result);
    }

    static void chicken(int chickenIndex, int visitedChicken){
        if(visitedChicken == M){
            // M개 골랐으면 '도시의 치킨 거리' check하고 backtracking
            int sumChickenDistance = 0;

            for(int i=0; i<homeList.size(); i++){
                int subDistance = Integer.MAX_VALUE; // home[i]의 최소 치킨거리 value (고른 M개의 치킨집 중에서 가장 가까운 치킨집까지의 치킨거리)
                for(int j=0; j<chickenHomeList.size(); j++){
                    // home[i]에 대한 각 치킨집 chickenHome[i]까지의 치킨 거리
                    if(visited[j]) {
                        int distance = getDistance(homeList.get(i), chickenHomeList.get(j));
                        subDistance = Math.min(subDistance, distance); // 매번 최솟값 고르기
                    }
                }

                sumChickenDistance += subDistance;
            }

            // 결과 : 도시의 치킨거리의 '최솟값'
            result = Math.min(result, sumChickenDistance);
            return; // Backtracking
        }

        for(int i=chickenIndex; i<chickenHomeList.size(); i++){
            if(!visited[i]){ // 안고른 치킨집중에서 선택
                visited[i] = true; // select
                chicken(i + 1, visitedChicken + 1);
                visited[i] = false; // rollback
            }
        }
    }

    static int getDistance(Point a, Point b){
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}
