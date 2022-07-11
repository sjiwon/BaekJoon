package Gold3.baekjoon_16236;

/*
1. 좌표 (x, y)에 존재하는 물고기 > 아기 상어 : 못 지나간다
2. 좌표 (x, y)에 존재하는 물고기 = 아기 상어 : 지나갈 수는 있는데 먹을 수는 없다
3. 좌표 (x, y)에 존재하는 물기고 < 아기 상어 : 지나갈 수도 있고 먹을 수도 있다

## 먹을 수 있는 물고기가 map안에 없으면 종료
(1) 먹을 수 있는 물고기가 1마리 : 그 물고기만 먹기
(2) 먹을 수 있는 물고기 여러마리
    -> 1) 가장 가까운 물고기 먹기 :: dTime
         -> 1)) 가장 가까운 물고기 여러마리 : 가장 위에 있는 물고기 :: dx
             -> 1))) 가장 위에 있는 물고기 여러마리 : 가장 왼쪽에 있는 물고기 :: dy

## 아기 상어는 자신의 크기만큼 물고기를 먹어야 자신의 크기가 1 증가한다
-> ex) 현재 크기 5인 아기상어 : 물고기 5마리 먹어야 크기 6이 된다
 */

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N; // map 크기 N x N
    static int [][] map;
    static boolean [][] visited;
    static int sharkSize = 2; // 처음 아기상어 크기 = 2
    static int [] dx = {0, 0, 1, -1}; // 동 서 남 북
    static int [] dy = {1, -1, 0, 0}; // 동 서 남 북
    static Vector<Integer> ate = new Vector<>();
    // 아기 상어가 먹은 물고기의 개수 (어차피 본인 사이즈보다 작은 물고기만 먹을 수 있음)
    static Vector<Point> canEat = new Vector<>();
    // 현재 아기상어의 위치로부터 먹을 수 있는 물고기의 좌표 목록
    // canEat.size() == 1이면 그냥 해당 물고기 먹기
    // canEat.size() > 1이면 조건에 맞는 물고기 먹기
    static int time = 0; // 아기 상어가 엄마 상어 도움 받지 않고 물고기 먹을 수 있는 시간

    static class Point{
        private int x, y, time; // shark로 부터 (x, y)까지 가는 time
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
        int getTime(){
            return time;
        }
        void setX(int x){
            this.x = x;
        }
        void setY(int y){
            this.y = y;
        }
        void setTime(int time){
            this.time = time;
        }
    }

    static Point shark; // 상어의 위치를 따로 check

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9){
                    // 아기 상어가 존재하는 좌표도 어차피 빈칸과 똑같음 :: 물고기 없으니까
                    shark = new Point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        shark();

        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isRange(int x, int y){
        return 0<=x && 0<=y && x<N && y<N;
    }

    static void shark(){
        Queue<Point> q = new LinkedList<>();
        // 이동 가능한 좌표 저장 
        q.offer(shark);
        visited[shark.getX()][shark.getY()] = true;

        while(true) {
            while (!q.isEmpty()) {
                Point p = q.poll();
                int cur_x = p.getX();
                int cur_y = p.getY();
                int time = p.getTime();

                for (int i = 0; i < 4; i++) {
                    // "동 서 남 북" 탐색
                    int nx = cur_x + dx[i];
                    int ny = cur_y + dy[i];

                    if (isRange(nx, ny) && !visited[nx][ny]) {
                        if (canMove(nx, ny)) {
                            // 해당 좌표가 이동가능한 좌표이기만 하면 Queue에 넣기
                            // 해당 좌표가 먹을수도 있으면 Vector :: canEat에도 넣기
                            if (canEat(nx, ny)) {
                                q.offer(new Point(nx, ny, time + 1));
                                visited[nx][ny] = true;
                                canEat.add(new Point(nx, ny, time + 1));
                            } else {
                                q.offer(new Point(nx, ny, time + 1));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            // 현재 좌표(cur_x, cur_y)로부터 map상의 모든 좌표를 결국 Queue에 offer/poll 완료
            // 이 중 먹을 수 있는 좌표들만 Vector :: canEat에 add

            if(!canEat.isEmpty()){
                eat();

                /*
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++) {
                        if (i == shark.getX() && j == shark.getY())
                            System.out.print("#" + " ");
                        else
                            System.out.print("." + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                 */

                q.clear(); // 이동을 했으니까 이동 가능한 좌표 list 초기화
                visited = new boolean[N][N]; // 방문여부 초기화
                q.offer(shark); // Update된 shark정보 Queue에 넣기
                visited[shark.getX()][shark.getY()] = true; // 아기상어 새로 넣은 좌표 방문여부 체크
            }
            else
                // canEat이 비어있다는거는 더 이상 map상에서 아기상어가 혼자힘으로 먹을 수 있는 물고기 X
                break;

            if(canUpgrade()){
                sharkSize++;
                ate.clear();
            }
        }
    }

    static void eat(){
        canEat.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // 우선순위 : (1) 타임 (dTime) / (2) 위에 있는지 (dX) / (3) 왼쪽에 있는지 (dY)
                if (o1.getTime() < o2.getTime())
                    return -1;
                else if (o1.getTime() > o2.getTime())
                    return 1;
                else {
                    if (o1.getX() < o2.getX())
                        return -1;
                    else if (o1.getX() > o2.getX())
                        return 1;
                    else {
                        if (o1.getY() < o2.getY())
                            return -1;
                        else
                            return 1;
                    }
                }
            }
        });

        Point eat = canEat.remove(0);
        // 결국 compare에 의해서 canEat의 가장 첫번째 Point가 조건을 만족하는 Point

        shark.setX(eat.getX());
        shark.setY(eat.getY());
        shark.setTime(0);
        // 아기 상어를 물고기 먹은 위치로 옮기기, Time 초기화

        time += eat.getTime();

        ate.add(1); // 어떤 값을 넣어도 상관없다 :: 어차피 ate.size()만 사용
        map[eat.getX()][eat.getY()] = 0; // 먹었으니까 빈칸으로 설정
        canEat.clear(); // 물고기를 먹었으니까 먹을 수 있는 물고기 list 초기화
    }

    static boolean canEat(int x, int y){
        // 본인(아기 상어)보다 크기가 작은 물고기만 먹을 수 있다
        return map[x][y] < sharkSize && map[x][y] != 0;
    }

    static boolean canMove(int x, int y){
        // 본인(아기상어)보다 크기가 작거나 같은 물고기가 존재하는 칸은 이동 가능
        return map[x][y] <= sharkSize || map[x][y] == 0;
    }

    static boolean canUpgrade(){
        /*
        ## 아기 상어는 자신의 크기만큼 물고기를 먹어야 자신의 크기가 1 증가한다
        -> ex) 현재 크기 5인 아기상어 : 물고기 5마리 먹어야 크기 6된다
         */
        return ate.size() == sharkSize;
    }
}
