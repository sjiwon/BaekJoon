package Gold5.baekjoon_21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 주변에 좋아하는 친구 많으면
 * 2. 주변에 빈칸 많으면
 * 3. x 작은 곳
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int student;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Map<Integer, List<Integer>> likes = new LinkedHashMap<>();
    static PriorityQueue<Point> stepLists = new PriorityQueue<>((o1, o2) -> {
        if (o1.likeCount > o2.likeCount) {
            return -1;
        } else if (o1.likeCount < o2.likeCount) {
            return 1;
        } else {
            if (o1.emptyCount > o2.emptyCount) {
                return -1;
            } else if (o1.emptyCount < o2.emptyCount) {
                return 1;
            } else {
                return Integer.compare(o1.x, o2.x);
            }
        }
    });
    final static int[] score = {0, 1, 10, 100, 1000};

    static class Point {
        int x;
        int y;
        int likeCount;
        int emptyCount;

        public Point(int x, int y, int likeCount, int emptyCount) {
            this.x = x;
            this.y = y;
            this.likeCount = likeCount;
            this.emptyCount = emptyCount;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        student = N * N;
        map = new int[N][N];

        for (int i = 0; i < student; i++) {
            applyLike(br.readLine().split(" "));
        }

        for (Integer student : likes.keySet()) {
            process(student);
        }

        System.out.println(getResult());
    }

    private static void applyLike(String[] like) {
        int student = Integer.parseInt(like[0]);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < like.length; i++) {
            list.add(Integer.parseInt(like[i]));
        }

        likes.put(student, list);
    }

    private static void process(Integer student) {
        stepLists.clear();

        for (int cx = 0; cx < N; cx++) {
            for (int cy = 0; cy < N; cy++) {
                if (map[cx][cy] != 0) {
                    continue;
                }

                int likeCount = 0;
                int emptyCount = 0;
                for (int i = 0; i < dx.length; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (isRange(nx, ny)) {
                        if (map[nx][ny] == 0) {
                            emptyCount++;
                        }
                        if (existsLikeFriend(student, nx, ny)) {
                            likeCount++;
                        }
                    }
                }

                stepLists.offer(new Point(cx, cy, likeCount, emptyCount));
            }
        }

        Point findPoint = stepLists.poll();
        map[findPoint.x][findPoint.y] = student;
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static boolean existsLikeFriend(int student, int x, int y) {
        return likes.get(student).contains(map[x][y]);
    }

    private static int getResult() {
        int result = 0;

        for (int cx = 0; cx < N; cx++) {
            for (int cy = 0; cy < N; cy++) {
                int count = 0;
                int student = map[cx][cy];

                for (int i = 0; i < dx.length; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (isRange(nx, ny) && existsLikeFriend(student, nx, ny)) {
                        count++;
                    }
                }

                result += score[count];
            }
        }

        return result;
    }
}

/*
3
4 2 5 1 7
3 1 9 4 5
9 8 1 2 3
8 1 9 3 4
7 2 3 4 8
1 9 2 5 7
6 5 2 3 4
5 1 9 2 8
2 9 3 1 4
>> 54

3
4 2 5 1 7
2 1 9 4 5
5 8 1 4 3
1 2 9 3 4
7 2 3 4 8
9 8 4 5 7
6 5 2 3 4
8 4 9 2 1
3 9 2 1 4
>> 1053
 */