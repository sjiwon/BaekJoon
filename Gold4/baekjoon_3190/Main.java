package Gold4.baekjoon_3190;

import java.io.*;
import java.util.*;

public class Main {
    static int [][] map; // 보드판 (N x N)
    static int N;
    static StringTokenizer st;
    static int count = 0; // 게임 진행 시간
    static int [] d = {0, 1}; // d[0] = dx, d[1] = dy
    // 방향 변환이 없는 이상, 계속 오른쪽으로 가기 때문에 dx=0, dy=1로 설정
    static HashMap<Integer, String> hm; // key : 시간, value : 방향 정보
    static String direct; // 현재 진행 방향

    static class Point{
        private int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y ;
        }
        int getX(){
            return this.x;
        }
        int getY(){
            return this.y;
        }

        @Override
        public boolean equals(Object o){
            Point other = (Point) o;

            return (this.getX() == other.getX()) && (this.getY() == other.getY());
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine()); // 사과 개수
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1][y-1] = 1; // 좌표값이 1이면 해당 좌표에 사과 존재
        }

        int L = Integer.parseInt(br.readLine()); // 방향 변환 정보 개수
        hm = new HashMap<>(); // key : 시간, value : 방향 정보
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            hm.put(X, C);
        }

        Dummy();

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Dummy(){
        Deque<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        direct = "R"; // 초기 방향 = 오른쪽으로 직진

        while(!q.isEmpty()){
            Point p = q.peekLast();

            int cur_x = p.getX() + d[0];
            int cur_y = p.getY() + d[1];

            count += 1; // 시간 증가

            System.out.println("터치 여부 : " + isTouch(q, cur_x, cur_y));

            if(!isRange(cur_x, cur_y) || isTouch(q, cur_x, cur_y))
                // (cur_x, cur_y)가 map안에 없거나(:: 벽과 부딪힘), 본인과 부딪힌다면 즉시 종료
                return;
            else
                q.offer(new Point(cur_x, cur_y));

            // (cur_x, cur_y)에 사과가 있으면 poll()하지 않고, 사과가 없으면 그냥 poll()
            if(map[cur_x][cur_y] != 1)
                q.pollFirst();
            else
                map[cur_x][cur_y] = 0;

            if(hm.containsKey(count)) {
                changeDirect(direct, hm.get(count), d);
                direct = hm.get(count);
            }

            System.out.println("q : (" + p.getX() + " " + p.getY() + "), " + "cur : (" + cur_x + " " + cur_y + ")" +
                    ", 시간 : " + count + ", 방향 : " + d[0] + " " + d[1] + " " + direct + ", 큐 사이즈 : " + q.size());
            printMap(q);
            System.out.println();
        }
    }

    static void printMap(Queue<Point> q){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(q.contains(new Point(i, j)))
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

    static boolean isRange(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    static boolean isTouch(Queue<Point> q, int x, int y){
        return q.contains(new Point(x, y));
    }

    static void changeDirect(String direct, String change, int [] d){
        /*
        (원래 방향 : direct / 전환 방향 : change)
        초기 방향 = R (dx = 0, dy = 1)
        R -> D : dx = 1, dy = 0
        R -> L : dx = -1, dy = 0
        D -> D || L -> D
            (1) {0, 1} : dx = 1, dy = 0
            (2) {1, 0} : dx = 0, dy = -1
            (3) {0, -1} : dx = -1, dy = 0
            (4) {-1, 0) : dx = 0, dy = 1
        D -> L || L -> L
            (1) {0, 1} : dx = -1, dy = 0
            (2) {1, 0} : dx = 0, dy = 1
            (3) {0, -1} : dx = 1, dy = 0
            (4) {-1, 0} : dx = 0, dy = -1
         */
        if(direct.equals("R")){
            if(change.equals("D")) {
                d[0] = 1;
            }
            else{
                d[0] = -1;
            }
            d[1] = 0;
        }
        else if(direct.equals("D") || direct.equals("L")){
            if(change.equals("D")){
                if(d[0] == 0 && d[1] == 1){
                    d[0] = 1;
                    d[1] = 0;
                }
                else if(d[0] == 1 && d[1] == 0){
                    d[0] = 0;
                    d[1] = -1;
                }
                else if(d[0] == 0 && d[1] == -1){
                    d[0] = -1;
                    d[1] = 0;
                }
                else if(d[0] == -1 && d[1] == 0){
                    d[0] = 0;
                    d[1] = 1;
                }
            }
            else{
                if(d[0] == 0 && d[1] == 1){
                    d[0] = -1;
                    d[1] = 0;
                }
                else if(d[0] == 1 && d[1] == 0){
                    d[0] = 0;
                    d[1] = 1;
                }
                else if(d[0] == 0 && d[1] == -1){
                    d[0] = 1;
                    d[1] = 0;
                }
                else if(d[0] == -1 && d[1] == 0){
                    d[0] = 0;
                    d[1] = -1;
                }
            }
        }
    }
}

