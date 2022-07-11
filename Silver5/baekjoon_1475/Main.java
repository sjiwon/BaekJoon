package Silver5.baekjoon_1475;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<10; i++){
            char s = (char) (i + '0');
            hm.put(s, 0);
        }

        char [] N = br.readLine().toCharArray();

        for(char c : N)
            hm.put(c, hm.get(c) + 1);

        double s_n = hm.get('6') + hm.get('9');

        hm.put('6', (int) Math.round(s_n/2));
        hm.put('9', (int) Math.round(s_n/2));

        bw.write(Collections.max(hm.values()) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
