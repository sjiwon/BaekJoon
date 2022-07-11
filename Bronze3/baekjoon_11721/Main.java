package Bronze3.baekjoon_11721;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = br.readLine();

        for(int i=0; i<text.length(); i++){
            bw.write(text.charAt(i));
            if(i%10 == 9)
                bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
