package Silver4.baekjoon_13305;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long cost = 0; // 총 비용

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        long [] city = new long[N]; // 해당 도시 비용
        long [] distance = new long[N-1]; // 도시 사이의 거리

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<distance.length; i++)
            distance[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<city.length; i++)
            city[i] = Long.parseLong(st.nextToken());

        for(int i=0; i<N-1; i++)
            if(city[i] < city[i+1])
                city[i+1] = city[i];

        for(int i=0; i<N-1; i++)
            cost += city[i] * distance[i];

        bw.write(cost + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
