package Silver1.baekjoon_1991;

import java.io.*;
import java.util.*;

public class Main {

    static class Tree{
        private String node;
        private Tree left;
        private Tree right;

        public Tree(){

        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }
    }

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Tree [] t = new Tree[N];

        for(int i=0; i<N; i++){
            t[i] = new Tree();
        }

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            // '.' : ASCII Code = 46

            int index_node = node.charAt(0) - 65;
            int index_left = left.charAt(0) - 65;
            int index_right = right.charAt(0) - 65;

            t[index_node].setNode(node);

            if(!left.equals(".")){
                t[index_node].setLeft(t[index_left]);
            }
            else{
                t[index_node].setLeft(null);
            }

            if(!right.equals(".")){
                t[index_node].setRight(t[index_right]);
            }
            else{
                t[index_node].setRight(null);
            }
        }

        preorder(t[0]); sb.append("\n");
        inorder(t[0]); sb.append("\n");
        postorder(t[0]); sb.append("\n");

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void preorder(Tree t) throws IOException {
        if(t != null){
            sb.append(t.getNode());
            preorder(t.getLeft());
            preorder(t.getRight());
        }
    }

    static void inorder(Tree t) throws IOException {
        if(t != null){
            inorder(t.getLeft());
            sb.append(t.getNode());
            inorder(t.getRight());
        }
    }

    static void postorder(Tree t)  throws IOException {
        if(t != null){
            postorder(t.getLeft());
            postorder(t.getRight());
            sb.append(t.getNode());
        }
    }
}

