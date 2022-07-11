package Gold4.baekjoon_1717;

import java.io.*;
import java.util.*;

public class Main {
    static int [] parent;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        for(int i=0; i<=N; i++)
            parent[i] = i;

        for(int t=0; t<M; t++){
            st = new StringTokenizer(br.readLine());

            int check = Integer.parseInt(st.nextToken()); // 0 or 1
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(check){
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if(find(a) == find(b))
                        bw.write("YES\n");
                    else
                        bw.write("NO\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) {
            if (a < b)
                parent[b] = a;
            else
                parent[a] = b;
        }
    }
    static int find(int x){
        if(parent[x] ==x) return x;

        return parent[x] = find(parent[x]);
    }
}
