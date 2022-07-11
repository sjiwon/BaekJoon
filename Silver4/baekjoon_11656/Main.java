package Silver4.baekjoon_11656;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String line = br.readLine();

        String [] arr = new String[line.length()];

        for(int i=0; i<arr.length; i++){
            arr[i] = line.substring(i);
        }

        Arrays.sort(arr);

        for(String s : arr){
            sb.append(s).append("\n");
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}