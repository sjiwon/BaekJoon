package Gold5.baekjoon_2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int[] list;
    static boolean[] visited;
    static int recursionStandard; // recursion을 통해서 list[idx]가 "recursionStandard"에 도달하면 list[idx]는 cycle을 만족
    static List<Integer> set; // 뽑힌 정수 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            // [3, 1, 1, 5, 5, 4, 6]
        }
        set = new ArrayList<>();

        // Cycle을 이루는 수들을 뽑게 되면 결국 두 집합이 일치 (첫번째 집합 = idx list, 두번째 집합 = value list)
        /*
        1 : 1(3) -> 3(1) = O
        2 : 2(1) -> 1(3) -> 3(1) = X
        3 : 3(1) -> 1(3) = O
        4 : 4(5) -> 5(5) = X
        5 : 5(5) -> 5(5) = O
        6 : 6(4) -> 4(5) -> 5(5) = X
        7 : 7(6) -> 6(4) -> 4(5) -> 5(5) = X
        >> 1, 3, 5 선택
         */
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            recursionStandard = i; // 재귀 기준 숫자
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(set);
        System.out.println(set.size());
        for (Integer value : set) {
            System.out.println(value);
        }
    }

    static void dfs(int idx) {
        int value = list[idx]; // 다음 idx

        if(recursionStandard == value){
            // 사이클이 발생했다면 value를 set에 추가 (cycle에 의해 도달된 idx)
            set.add(idx);
            return;
        }

        if(!visited[value]){ // 꼬리물면서 Cycle 탐색
            visited[value] = true;
            dfs(value);
            visited[value] = false;
        }
    }
}

/*
7
3
1
1
5
5
4
6
---
3
1
3
5
 */