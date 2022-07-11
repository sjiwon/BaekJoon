package Bronze5.baekjoon_2744;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        char [] arr = word.toCharArray();

        for(char c : arr){
            if(Character.isUpperCase(c))
                bw.write(Character.toLowerCase(c));
            else
                bw.write(Character.toUpperCase(c));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
