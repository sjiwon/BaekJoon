package Silver4.baekjoon_1158;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++)
            list.add(i);

        int index = 0;
        while(list.size() != 1){
            index = (index+(K-1))%list.size();
            int value = list.remove(index);
            sb.append(value).append(", ");

        }
        sb.append(list.remove(0)).append(">");

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
