package Silver1.baekjoon_1931;

import java.io.*;
import java.util.*;
public class Main {

    static class Room{
        private int start;
        private int end;
        Room(int start, int end){
            this.start = start;
            this.end = end;
        }
        int getStart(){
            return start;
        }
        int getEnd(){
            return end;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Room [] r = new Room[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            r[i] = new Room(start, end);
        }

        Arrays.sort(r, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if(o1.getEnd() < o2.getEnd())
                    return -1;
                else if(o1.getEnd() > o2.getEnd())
                    return 1;
                else {
                    if(o1.getStart() < o2.getStart())
                        return -1;
                    else
                        return 1;
                }
            }
        });

        int count = 1; // 초기 회의 횟수
        int end = r[0].getEnd(); // 초기 회의 종료 시간

        for(int i=1; i<r.length; i++){
            if(r[i].getStart() >= end){
                end = r[i].getEnd();
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
