package Silver3.baekjoon_3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int count = 0, sum = 0;
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start =0, end = n-1;

        while(start < end){
            sum = arr[start] + arr[end];
            if(sum == x) {
                count++;
                end--;
                start++;
            }
            else if (sum < x) start++;
            else if (sum > x) end--;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
