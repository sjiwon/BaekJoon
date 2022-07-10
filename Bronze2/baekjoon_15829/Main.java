package Bronze2.baekjoon_15829;

import java.io.*;
import java.util.*;

public class Main {
    static final int n = 31;
    static final int mod = 1234567891;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=1; i<=26; i++)
            hm.put((char)(i+96), i);

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char [] arr = s.toCharArray();

        long result = 0;
        long pow = 1;

        double r = Math.pow(31, 0);
        for(int i=0; i<L; i++){
            result += hm.get(arr[i]) * pow;
            pow = (pow*=n)%mod;
        }

        bw.write(result%mod + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
