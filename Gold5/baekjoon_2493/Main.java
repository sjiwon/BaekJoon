package Gold5.baekjoon_2493;

import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static class Top{
        private int id; // 본인 순서 번호
        private int height; // 본인 ID
        Top(int id, int height){
            this.id = id;
            this.height = height;
        }
        int getId(){
            return id;
        }
        int getHeight(){
            return height;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Top> s = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int value = Integer.parseInt(st.nextToken());

            while(!s.isEmpty()){
                if(value <= s.peek().getHeight()){
                    sb.append(s.peek().getId()).append(" ");
                    break;
                }
                else
                    s.pop();
                // peek() 값이 본인보다 작다면 -> 어차피 peek()값은 본인 이후 누구한테도 영향을 주지 못한다
                // 그렇기 때문에 pop()해서 아예 없애버리기
            }

            if(s.isEmpty())
                sb.append(0).append(" ");

            s.push(new Top(i, value));
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

