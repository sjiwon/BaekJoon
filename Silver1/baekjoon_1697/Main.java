package Silver1.baekjoon_1697;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int K;
    static boolean [] visited = new boolean[200001];
    static int [] time = new int[200001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N==K)
            bw.write(0 + "\n");
        else{
            int result = bfs(N);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int N){
        Queue<Integer> q = new LinkedList<>();
        time[N] = 0;
        visited[N] = true;
        q.offer(N);

        while(!q.isEmpty()){
            int cur_x = q.poll();

            if(cur_x == K)
                return time[K];

            int next = -1;
            for(int i=0; i<3; i++){
                if(i == 0)
                    next = cur_x - 1;
                else if(i == 1)
                    next = cur_x + 1;
                else if(i == 2)
                    next = cur_x * 2;

                if(next>=0 && next<=100000){
                    if(!visited[next]){
                        visited[next] = true;
                        time[next] = time[cur_x] + 1;
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
