package Bronze1.baekjoon_1292;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int [] arr = new int[1000];

        int index = 0;
        int i = 1;
        while(index <= 999){
            for(int c=0; c<i; c++){
                if(index <= 999){
                    arr[index] = i;
                    index++;
                }
            }
            i++;
        }

        int sum = 0;

        for(int k=A-1; k<B; k++)
            sum += arr[k];

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
