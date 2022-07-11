package Silver3.baekjoon_1929;

import java.io.*;
import java.util.*;
public class Main {
    static boolean [] eratos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Eratos(N);

        for(int i=M; i<=N; i++){
            if(eratos[i])
                bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void Eratos (int n){
        if(n<=1) return;

        eratos = new boolean[n+1];

        for(int i=2; i<=n; i++)
            eratos[i] = true;

        for(int i=2; i*i<=n; i++){
            if(eratos[i]){
                for(int j=i*i; j<=n; j+=i)
                    eratos[j] = false;
            }
        }
    }
}
