package Silver5.baekjoon_11728;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> list = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        for(Integer n : list)
            bw.write(n + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
