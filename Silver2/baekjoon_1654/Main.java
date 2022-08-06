package Silver2.baekjoon_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static long K; // 보유하고 있는 랜선 개수
    static long N; // 필요한 랜선 개수
    static Long maxLength = Long.MIN_VALUE; // N개를 만들 수 있는 랜선의 최대 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        K = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        getMaxLength(list, 1, Collections.max(list));
        System.out.println(maxLength);
    }

    static void getMaxLength(List<Long> list, long left, long right) {
        if(left > right){
            return;
        }

        long mid = (left + right) / 2;
        Long lineCount = getLineCount(list, mid);

        if (lineCount < N) { // 개수 모자라면 자르는 기준 줄이기
            getMaxLength(list, left, mid - 1);
        } else { // 개수 충분하면 자르는 기준 일단 저장 & 자르는 기준 늘려서 더 많이 잘라도 충분한지 체크
            maxLength = Math.max(maxLength, mid);
            getMaxLength(list, mid + 1, right);
        }
    }

    static Long getLineCount(List<Long> list, long cut) {
        long count = 0L;
        for (Long value : list) {
            count += (value / cut);
        }
        return count;
    }
}

/*
4 11
802
743
457
539
>> 200

4 15
802
743
457
539
>> 152
 */