package Silver2.baekjoon_4948;

import java.io.*;
public class Main {
    static int T; // 테스트 케이스
    static boolean [] eratos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            T = Integer.parseInt(br.readLine());
            int count = 0;

            if(T==0)
                break;

            Eratos(2*T);
            for(int i=T+1; i<=2*T; i++){
                if(eratos[i])
                    count++;
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void Eratos(int n){
        if(n==0) return;

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
