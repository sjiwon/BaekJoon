package Bronze1.baekjoon_1193;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int line=1, line_sum=0;
        // line_sum = 해당 line전까지 누적 line

        while(true){
            if(X <= line+line_sum){
                if(line%2 == 0){
                    bw.write((X-line_sum) + "/" + (line-(X-line_sum-1)));
                    break;
                }
                else{
                    bw.write((line-(X-line_sum-1)) + "/" + (X-line_sum));
                    break;
                }
            }
            else{
                line_sum+=line;
                line++;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
