package Silver4.baekjoon_1920;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            hm.put(Integer.parseInt(st.nextToken()), 0);

        int M = Integer.parseInt(br.readLine());
        int [] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i]))
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
