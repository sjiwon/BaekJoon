package Bronze3.baekjoon_10817;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        bw.write(arr[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
