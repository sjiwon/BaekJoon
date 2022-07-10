package Bronze2.baekjoon_2920;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[8];

        for(int i=0; i<8; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        String text = "";
        for(int i=0; i<7; i++){
            if(arr[i+1] == arr[i] + 1)
                text = "ascending";
            else if(arr[i+1] == arr[i] - 1)
                text = "descending";
            else {
                text = "mixed";
                break;
            }
        }

        bw.write(text);
        bw.flush();
        bw.close();
        br.close();
    }
}
