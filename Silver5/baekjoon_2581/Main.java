package Silver5.baekjoon_2581;

import java.io.*;
public class Main {
    static boolean [] eratos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        eratos = new boolean[N+1];
        Eratos(N);

        int sum = 0;

        for(int i=M; i<=N; i++){
            if(eratos[i])
                sum += i;
        }

        int min = find_prime(M, N);

        if(sum == 0)
            bw.write(-1 + "\n");
        else {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void Eratos(int n){
        if(n<=1) return;

        for(int i=2; i<=n; i++)
            eratos[i] = true;

        for(int i=2; i*i<=n; i++){
            if(eratos[i]){
                for(int j=i*i; j<=n; j+=i)
                    eratos[j] = false;
            }
        }
    }

    static int find_prime(int M, int N){
        for(int i=M; i<=N; i++){
            if(eratos[i])
                return i;
        }
        return -1;
    }
}
