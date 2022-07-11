package Silver5.baekjoon_11723;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> s = new HashSet<>();

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            String [] c = br.readLine().split(" ");
            switch(c[0]){
                case "add":
                    s.add(Integer.parseInt(c[1]));
                    break;
                case "remove":
                    s.remove(Integer.parseInt(c[1]));
                    break;
                case "check":
                    if(s.contains(Integer.parseInt(c[1])))
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "toggle":
                    if(s.contains(Integer.parseInt(c[1])))
                        s.remove(Integer.parseInt(c[1]));
                    else
                        s.add(Integer.parseInt(c[1]));
                    break;
                case "all":
                    s.clear();
                    for(int j=1; j<=20; j++)
                        s.add(j);
                    break;
                case "empty":
                    s.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
