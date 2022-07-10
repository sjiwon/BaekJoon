package Bronze1.baekjoon_1259;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String line = br.readLine();
            if(line.equals("0"))
                break;
            StringBuilder s1 = new StringBuilder(line).reverse();

            if(line.equals(s1.toString()))
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
