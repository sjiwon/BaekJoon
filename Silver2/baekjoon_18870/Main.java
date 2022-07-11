package Silver2.baekjoon_18870;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = sort[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sort);

        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        for(int n : sort){
            if(!hm.containsKey(n)){
                hm.put(n, i);
                i++;
            }
        }

        for(int n : arr)
            bw.write(hm.get(n) + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
