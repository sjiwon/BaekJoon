package Silver1.baekjoon_18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static String[][] map;
    static final int MAX_OBSTACLE_COUNT = 3;
    static boolean canSurvive; // 모든 학생이 감시를 피할 수 있는 경우 true로 변환

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

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static List<Point> studentList = new ArrayList<>(); // 학생 위치 저장 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = st.nextToken();
                if(map[i][j].equals("S")){
                    studentList.add(new Point(i, j)); // 학생 위치 저장
                }
            }
        }

        installObtacle(0);

        if(canSurvive){
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

    static void installObtacle(int installCount){
        if(canSurvive){ // 3개 장애물 설치 후 모든 학생이 감시 피할 수 있다면 그 시점에서 stop
            return;
        }

        if(installCount == MAX_OBSTACLE_COUNT){ // 3개 다 설치했으면 감시 후 backtracking
            surveillance();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(canInstall(i, j)){
                    map[i][j] = "O"; // install
                    installObtacle(installCount + 1);
                    map[i][j] = "X"; // rollback
                }
            }
        }
    }

    static void surveillance() {
        String[][] copyMap = copyMap();
        Queue<Point> teacherList = new LinkedList<>();
        insertTeacher(teacherList, copyMap);

        for(Point teacher : teacherList){
            for(int i=0; i<4; i++){

                int nextX = teacher.getX() + dx[i];
                int nextY = teacher.getY() + dy[i];

                if(i == 0){ // 동쪽 전부 감시
                    while(canSurveillance(nextX, nextY, copyMap)){
                        copyMap[nextX][nextY] = "T"; // (nextX, nextY) 감시 완료
                        nextY += 1;
                    }
                } else if(i == 1){ // 서쪽 전부 감시
                    while(canSurveillance(nextX, nextY, copyMap)){
                        copyMap[nextX][nextY] = "T"; // (nextX, nextY) 감시 완료
                        nextY -= 1;
                    }
                } else if(i == 2){ // 남쪽 전부 감시
                    while(canSurveillance(nextX, nextY, copyMap)){
                        copyMap[nextX][nextY] = "T"; // (nextX, nextY) 감시 완료
                        nextX += 1;
                    }
                } else{ // 북쪽 전부 감시
                    while(canSurveillance(nextX, nextY, copyMap)){
                        copyMap[nextX][nextY] = "T"; // (nextX, nextY) 감시 완료
                        nextX -= 1;
                    }
                }
            }
        }
        canAllSurvive(copyMap);
    }

    static void canAllSurvive(String[][] copyMap){ // 3개 장애물 설치한 copyMap상에서 모든 학생이 감시 피할 수 있는지
        boolean isSurvive = true;
        for(Point student : studentList){
            if (!copyMap[student.getX()][student.getY()].equals("S")) { // 감시 당했다면
                isSurvive = false;
                break;
            }
        }

        if(isSurvive){
            canSurvive = true;
        }
    }

    static String[][] copyMap() { // 감시용 copyMap 생성
        String[][] copyMap = new String[map.length][map.length];

        for(int i=0; i<N; i++){
            System.arraycopy(map[i], 0, copyMap[i], 0, N);
        }

        return copyMap;
    }

    static void insertTeacher(Queue<Point> q, String[][] copyMap){ // 선생 좌표 Queue에 넣어주기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(copyMap[i][j].equals("T")){
                    q.offer(new Point(i, j));
                }
            }
        }
    }

    static boolean isRange(int x, int y){ // (x, y)가 맵 안에 존재하는지
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static boolean canInstall(int x, int y){ // (x, y)에 장애물 설치할 수 있는지
        return Objects.equals(map[x][y], "X");
    }

    static boolean canSurveillance(int x, int y, String[][] copyMap){ // (x, y)를 선생이 감시할 수 있는가
        // (x, y)를 감시할 수 있는가
        return isRange(x, y) && !copyMap[x][y].equals("O");
    }
}

/*
[x, y, z]라는 선생이 존재할 경우 x가 감시 완료한 지역에 대해서 visited 배열을 true로 줘버리면 다른 선생의 감시 범위에 영향을 미침

Example)
N = 3
(0, 0)에 학생 존재
(1, 1), (0, 2)에 선생 존재
-> 여기서 (1, 1)이 감시를 하다가 (0, 1)에 대해서 visited = true로 줘버릴 경우 (0, 2)의 선생이 서쪽 감시중 더 감시를 못하는 경우 발생
    >> 따라서 (0, 2) 선생은 (0, 0) 학생을 감시할 수 있지만 이전에 (1, 1) 선생의 visited = true로 인해서 감시를 못함
        -> 이거때문에 41%에서 오답처리
 */

/*
5
X S X X T
T X S X X
X X X X X
X T X X X
X X T X X
>> YES

4
S S S T
X X X X
X X X X
T T T X
>> NO

4
X S X T
X X S X
X X X X
T T T X
>> Yes

5
X X S X X
X X X X X
S X T X S
X X X X X
X X S X X
>> NO

5
X T X T X
T X S X T
X S S S X
T X S X X
X T X X X
>> YES

5
X S S S X
T X X S X
X T X S X
X X T X S
X X X T X
>> Yes
 */