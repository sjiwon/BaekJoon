package Silver4.baekjoon_10828;
import java.io.*;

class Stack{
    static final int MAX_STACK_SIZE = 10000;
    private int top;
    private int[] stack;
    public Stack(){
        this.top = -1;
        this.stack = new int[MAX_STACK_SIZE];
    }
    int is_empty(){
        if(top == -1) return 1;
        return 0;
    }
    int size(){
        return this.top+1;
    }
    void push(int item){
        this.stack[++top] = item;
    }
    int pop(){
        if(top == -1) return -1;
        return this.stack[top--];
    }
    int peek(){
        if(top == -1) return -1;
        else return this.stack[top];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 명령의 수 입력

        Stack s = new Stack();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(str.contains("push")){
                String[] spt = str.split(" ");
                s.push(Integer.parseInt(spt[1]));
            }
            else if(str.contains("pop"))
                bw.write(s.pop() +"\n");
            else if(str.contains("size"))
                bw.write(s.size() +"\n");
            else if(str.contains("empty"))
                bw.write(s.is_empty() +"\n");
            else if(str.contains("top"))
                bw.write(s.peek() +"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
