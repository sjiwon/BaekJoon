package Silver5.baekjoon_11650;

import java.io.*;
import java.util.*;

class Point{
    private int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() < o2.getX())
                    return -1;
                else if(o1.getX() > o2.getX())
                    return 1;
                else{
                    if(o1.getY() > o2.getY())
                        return 1;
                    else
                        return -1;
                }
            }
        });

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(x, y));
        }

        for(int i=0; i<N; i++){
            Point p = pq.poll();
            int x = p.getX();
            int y = p.getY();
            bw.write(x + " " + y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
