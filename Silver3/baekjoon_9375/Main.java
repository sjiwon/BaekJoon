package Silver3.baekjoon_9375;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            HashMap<String, Integer> hm = new HashMap<>();
            // key : 의상 종류, value : 해당 종류의 개수
            // 종류에 어떤 옷이 있는지는 상관 X, 해당 종류안에 옷이 몇개나 있나

            int n = Integer.parseInt(br.readLine());
            for(int c=0; c<n; c++){
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String kind = st.nextToken();

                if(hm.containsKey(kind))
                    hm.put(kind, hm.get(kind) + 1);
                else
                    hm.put(kind, 1);
            }
            /*
            A = 2가지 :: 경우의 수 3 -> (안입음, 둘중 하나, 나머지 하나)
            B = 3가지 :: 경우의 수 4 -> (안입음, 셋중 하나, 나머지 둘중 하나, 나머지 하나)
            C = 2가지 :: 경우의 수 3 -> (안입음, 둘중 하나, 나머지 하나)
            >> 다곱해서 최종적으로 안입는 경우의 수 = 1 빼기
             */

            int result = 1;
            for(Integer N : hm.values()){
                result *= (N + 1);
            }

            bw.write((result-1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
