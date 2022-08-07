package Silver1.baekjoon_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N;
    static int r;
    static int c;
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Z(0, 0, (int)Math.pow(2, N));
    }

    static void Z(int i, int j, int size) {
        if (i == r && j == c) { // 도달하면 return
            System.out.println(index);
            return;
        }

        int newSize = size / 2;
        /*
        (r, c)가 size 기준 어느 사분면에 위치한지 찾아서 해당 사분면에서 다시 탐색
        -> size에 의해서 전체적인 탐색 range가 정해진다 (size * size의 정사각형 탐색)
         */
        if (isFirstPage(i, j, size)) {
            Z(i, j, newSize);
        } else if (isSecondPage(i, j, size)) {
            index += Math.pow(newSize, 2) * 1;
            Z(i, j + newSize, newSize);
        } else if (isThirdPage(i, j, size)) {
            index += Math.pow(newSize, 2) * 2;
            Z(i + newSize, j, newSize);
        } else {
            index += Math.pow(newSize, 2) * 3;
            Z(i + newSize, j + newSize, newSize);
        }
    }

    static boolean isFirstPage(int x, int y, int size) {
        return (x <= r && r < x + size / 2)
                && (y <= c && c < y + size / 2);
    }

    static boolean isSecondPage(int x, int y, int size) {
        return (x <= r && r < x + size / 2)
                && (y + size / 2 <= c && c < y + size);
    }

    static boolean isThirdPage(int x, int y, int size) {
        return (x + size / 2 <= r && r < x + size)
                && (y <= c && c < y + size / 2);
    }

    static boolean isFourthPage(int x, int y, int size) {
        return (x + size / 2 <= r && r < x + size)
                && (y + size / 2 <= c && c < y + size);
    }
}
