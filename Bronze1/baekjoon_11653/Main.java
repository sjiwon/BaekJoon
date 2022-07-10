package Bronze1.baekjoon_11653;

import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Factor(N);

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Factor(int n){
        int i = 2;
        while(n!=1){
            while(n%i == 0){
                sb.append(i).append('\n');
                n/=i;
            }
            i++;
        }
    }
}
