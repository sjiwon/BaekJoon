package Gold5.baekjoon_18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N;
    static int K;
    static int[][] map;

    // S초 뒤에 (X-1, Y-1)상에 존재하는 바이러스 종류 -> map을 row/column 1씩 빼서 저장했기 때문에
    static int S;
    static int X;
    static int Y;

    static class Virus{
        private int idx; // 바이러스 종류
        private int x; // x좌표
        private int y; // y좌표

        public Virus(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public int getIdx() {
            return idx;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // 바이러스 보관 리스트
    static List<List<Virus>> virus = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<K; i++){
            virus.add(new ArrayList<>()); // 초기화
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0){
                    virus.get(map[i][j] - 1).add(new Virus(map[i][j], i, j)); // 바이러스 리스트에 담기
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for(int i=0; i<S; i++){
            if(!isAllSpread()) {
                spreadVirus();
            }
        }

        if(map[X-1][Y-1] == 0){
            System.out.println("0");
        } else{
            System.out.println(map[X-1][Y-1]);
        }
    }

    static void spreadVirus(){
        for(int i=0; i<virus.size(); i++){
            List<Virus> virusList = virus.remove(0);
            List<Virus> virusSpreadList = new ArrayList<>(); // remove(0)의 전염된 모든 좌표 저장 리스트

            for (Virus checkVirus : virusList) {
                for (int j = 0; j < 4; j++) {
                    int nextX = checkVirus.getX() + dx[j];
                    int nextY = checkVirus.getY() + dy[j];

                    if (canSpread(nextX, nextY)) {
                        map[nextX][nextY] = checkVirus.getIdx();
                        virusSpreadList.add(new Virus(checkVirus.getIdx(), nextX, nextY)); // 전염 좌표 리스트에 추가
                    }
                }
            }

            virus.add(virusSpreadList); // remove(0)에 대한 모든 전염 좌표 리스트를 최종적으로 virus list에 추가해주기
        }
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static boolean canSpread(int x, int y){
        return isRange(x, y) && map[x][y] == 0;
    }

    static boolean isAllSpread(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}

/*
3 3
1 0 2
0 0 0
3 0 0
2 3 2
>> 3

3 3
1 0 2
0 0 0
3 0 0
1 2 2
>> 0

2 2
2 0
0 0
1 2 2
>> 0

3 2
1 0 0
0 0 0
0 0 2
1 2 3
>> 2

2 3
3 0
1 2
0 1 1
>> 3

3 3
1 0 2
0 0 0
3 0 0
0 3 2
>> 0

4 2
1 0 0 0
0 0 0 0
0 0 0 0
0 0 0 2
3 3 2
>> 1
 */
