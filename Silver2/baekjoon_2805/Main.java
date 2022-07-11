package Silver2.baekjoon_2805;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] tree = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<tree.length; i++)
            tree[i] = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = get_max(tree);


        while(min <= max){
            int height = (min+max)/2; // 초기 높이
            long sum = 0; // 자른 나무 합
            for(int t : tree)
                if(t > height)
                    sum += (t-height);
            if(sum >= M)
                min = height+1;
            else
                max = height-1;
        }

        bw.write((max) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int get_max(int [] tree){
        int max = tree[0];
        for(int i=1; i<tree.length; i++){
            if(tree[i] > max)
                max = tree[i];
        }
        return max;
    }
}
