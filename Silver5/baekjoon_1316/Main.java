package Silver5.baekjoon_1316;

import java.io.*;
public class Main {
    static String [] word;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        word = new String[N];

        for(int i=0; i<N; i++)
            word[i] = br.readLine();

        int count = N;
        for(String s : word){
            char [] c = s.toCharArray();

            check :
            for(int i=0; i<c.length-1; i++){
                if(c[i] != c[i+1]){
                    for(int j=i+1; j<c.length; j++)
                        if(c[i] == c[j]) {
                            count -= 1;
                            break check;
                        }
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
