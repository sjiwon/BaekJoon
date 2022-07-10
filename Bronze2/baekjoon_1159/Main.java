package Bronze2.baekjoon_1159;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] count = new int[26]; // 각 성에 대한 선수명 수

        for(int i=0; i<N; i++)
            count[(br.readLine().charAt(0))-97]++;

        boolean flag = false;
        for(int i=0; i<count.length; i++){
            if(count[i] >= 5){
                flag = true;
                bw.write((char)(i+97));
            }
        }
        if(!flag) bw.write("PREDAJA");

        bw.flush();
        bw.close();
        br.close();
    }
}
