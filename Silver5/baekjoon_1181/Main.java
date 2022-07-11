package Silver5.baekjoon_1181;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++)
            set.add(br.readLine());

        String [] arr = set.toArray(new String[0]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    if(o1.length() < o2.length())
                        return -1;
                    else
                        return 1;
                }
                else
                    return o1.compareTo(o2);
            }
        });

        for(String s : arr)
            bw.write(s + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
