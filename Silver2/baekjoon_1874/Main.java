package Silver2.baekjoon_1874;

import java.io.*;
import java.util.*;
public class Main {
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = 0; // arr에 접근하는 인덱스
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            s.push(i+1);
            sb.append("+\n");
            while(true){
                if (s.isEmpty()) break;
                else if (s.peek() != arr[k])
                    break;
                else{
                    s.pop();
                    sb.append("-\n");
                    k++;
                }
            }
        }
        if (!s.isEmpty())
            bw.write("NO\n");
        else
            bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
