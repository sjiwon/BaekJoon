package Gold4.baekjoon_3190;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N; // 보드의 크기 : N x N
    static int [][] board;
    static int K; // 사과의 개수
    static int L; // 방향 변환 횟수
    static Map<Integer, String> snakeDirectionInfo = new HashMap<>(); // 방향 전환 정보 [시간:방향]

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return getX() == point.getX() && getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
    static Deque<Point> snakePosition = new LinkedList<>();
    static int time = 0; // 게임 시간
    static String direction = "R"; // 초기 방향 = 오른쪽
    static int [] dXY = {0, 1}; // d[0] = dx, d[1] = dy (초기 방향 = 오른쪽)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x-1][y-1] = 1; // (x-1, y-1)에 사과 존재
        }

        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            snakeDirectionInfo.put(time, direction);
        }

        snakePosition.add(new Point(0, 0)); // 초기 뱀 위치
        snakeGame();
        System.out.println(time);
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static boolean isTouch(int x, int y){
        return snakePosition.contains(new Point(x, y));
    }

    static void snakeGame(){
        while(true){
            if(snakeDirectionInfo.containsKey(time)){
                // time[초]에 방향 전환이 이루어지면
                changeDirection(snakeDirectionInfo.get(time));
            }

            Point headPosition = snakePosition.peek(); // 머리 위치 꺼내기

            assert headPosition != null;
            int nextX = headPosition.getX() + dXY[0];
            int nextY = headPosition.getY() + dXY[1];

            if(!isRange(nextX, nextY) || isTouch(nextX, nextY)){
                // 벽 부딪히거나 자신과 부딪히면 게임 끝
                time++; // (nextX, nextY)는 다음 time 기준이고, 다음 time때 여기서 걸린다면 break
                return;
            }

            snakePosition.offerFirst(new Point(nextX, nextY)); // 머리 늘리기
            if(board[nextX][nextY] == 1){
                // 이동할 위치에 사과가 있다면
                board[nextX][nextY] = 0; // 사과 먹기
            } else {
                // 이동할 위치에 사과가 없다면
                snakePosition.pollLast(); // 꼬리 자르기
            }

            time += 1;
        }
    }

    static void changeDirection(String changeD){
        if(changeD.equals("L")){
            switch (direction) {
                case "R" -> {
                    direction = "U";
                    dXY = new int[]{-1, 0};
                }
                case "L" -> {
                    direction = "D";
                    dXY = new int[]{1, 0};
                }
                case "D" -> {
                    direction = "R";
                    dXY = new int[]{0, 1};
                }
                default -> {
                    direction = "L";
                    dXY = new int[]{0, -1};
                }
            }
        }
        else{
            switch (direction) {
                case "R" -> {
                    direction = "D";
                    dXY = new int[]{1, 0};
                }
                case "L" -> {
                    direction = "U";
                    dXY = new int[]{-1, 0};
                }
                case "D" -> {
                    direction = "L";
                    dXY = new int[]{0, -1};
                }
                default -> {
                    direction = "R";
                    dXY = new int[]{0, 1};
                }
            }
        }
    }
}