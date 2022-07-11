package Silver5.baekjoon_7785;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String record = st.nextToken(); // "enter" or "leave"

            if (record.equals("enter")) // 출근이면 1
                hm.put(name, 1);
            else // 퇴근이면 0
                hm.put(name, 0);
        }

        ArrayList<String> list = new ArrayList<>();

        for (String s : hm.keySet()) {
            if (hm.get(s) == 1) // 출근 상태인 name만 list에 add
                list.add(s);
        }

        list.sort(Collections.reverseOrder()); // 내림차순 정렬

        for(String s : list)
            bw.write(s + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
