package Bronze2.baekjoon_1076;

import java.io.*;
import java.util.*;
public class Main {
    static HashMap<String, Integer> hm = new HashMap<>(){
        {
            put("black", 0);
            put("brown", 1);
            put("red", 2);
            put("orange", 3);
            put("yellow", 4);
            put("green", 5);
            put("blue", 6);
            put("violet", 7);
            put("grey", 8);
            put("white", 9);
        }
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String [] color = new String[3];

        for(int i=0; i<3; i++)
            color[i] = br.readLine();

        for(int i=0; i<2; i++){
            sb.append(hm.get(color[i]));
        }

        long result = Integer.parseInt(sb.toString());
        result *= Math.pow(10, hm.get(color[2]));

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
