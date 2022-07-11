package Silver3.baekjoon_1002;

import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double distance;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            distance = Math.sqrt(Math.pow((x2-x1) ,2)+Math.pow((y2-y1), 2));
            if(x1 == x2 && y1 == y2 && r1==r2)
                bw.write(-1 + "\n");
            else if(distance > r1+r2 || distance < Math.abs(r2-r1))
                bw.write(0 + "\n");
            else if(distance == r1+r2 || distance == Math.abs(r2-r1))
                bw.write(1+ "\n");
            else
                bw.write(2+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
