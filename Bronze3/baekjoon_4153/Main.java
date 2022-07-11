package Bronze3.baekjoon_4153;

import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arr = new int [3];

        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
                break;

            if(check_tri(arr))
                bw.write("right\n");
            else
                bw.write("wrong\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check_tri(int [] arr){
        Arrays.sort(arr);

        int a = (int) Math.pow(arr[0], 2);
        int b = (int) Math.pow(arr[1], 2);
        int c = (int) Math.pow(arr[2], 2);

        if(c == a+b)
            return true;
        else
            return false;
    }
}