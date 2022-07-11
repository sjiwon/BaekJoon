package Silver2.baekjoon_9020;

import java.io.*;
public class Main {
    static boolean [] eratos;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            Eratos(n);

            int left = n/2;
            int right = n/2;
            while(true){
                if(eratos[left] && eratos[right]) {
                    sb.append(left).append(" ").append(right).append("\n");
                    break;
                }
                left--;
                right++;
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Eratos(int n){
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
