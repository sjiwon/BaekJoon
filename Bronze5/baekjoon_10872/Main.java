package Bronze5.baekjoon_10872;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(factorial(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int factorial(int num){
        if (num == 0)
            return 1;
        else
            return num*factorial(num-1);
    }
}
