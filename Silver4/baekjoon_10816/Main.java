package Silver4.baekjoon_10816;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());

            if(hm.containsKey(value))
                hm.put(value, hm.get(value) + 1);
            else
                hm.put(value, 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        while(st2.hasMoreTokens()){
            int value = Integer.parseInt(st2.nextToken());

            if(hm.containsKey(value))
                bw.write(hm.get(value) + " ");
            else
                bw.write(0 + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
