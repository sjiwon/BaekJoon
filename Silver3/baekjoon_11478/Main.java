package Silver3.baekjoon_11478;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();

        String S = br.readLine();

        for(int i=0; i<S.length(); i++){
            for(int j=i+1; j<=S.length(); j++){
                String make = S.substring(i, j);
                set.add(make);
            }
        }

        bw.write(set.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
