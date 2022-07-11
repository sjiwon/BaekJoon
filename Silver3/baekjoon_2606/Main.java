package Silver3.baekjoon_2606;

import java.io.*;
import java.util.*;
public class Main {
    static boolean [] virus; // virus걸리면 true로
    static int [][] mat;
    static int C; // 컴퓨터 수
    static int connect; // 연결된 컴퓨터 쌍의 수
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine()); // 컴퓨터 수
        connect = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수

        mat = new int[C+1][C+1];
        virus = new boolean[C+1];

        for(int i=0; i<connect; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            mat[start][end] = mat[end][start] = 1;
        }

        bw.write(virus_count(1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void init_virus(boolean [] virus){
        Arrays.fill(virus, false);
    }

    static int virus_count(int v){ // 시작 = 1
        Queue<Integer> q = new LinkedList<>();

        virus[v] = true;
        q.offer(v);

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=1; i<=C; i++){
                if(!virus[i] && mat[tmp][i] == 1) {
                    q.offer(i);
                    virus[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
