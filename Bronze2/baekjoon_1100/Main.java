package Bronze2.baekjoon_1100;

import java.io.*;
import java.util.*;
public class Main {
    static char [][] chess = {
            {'.', 'F', '.', 'F', '.', 'F', '.', 'F'},
            {'F', '.', 'F', '.', 'F', '.', 'F', '.'},
            {'.', 'F', '.', 'F', '.', 'F', '.', 'F'},
            {'F', '.', 'F', '.', 'F', '.', 'F', '.'},
            {'.', 'F', '.', 'F', '.', 'F', '.', 'F'},
            {'F', '.', 'F', '.', 'F', '.', 'F', '.'},
            {'.', 'F', '.', 'F', '.', 'F', '.', 'F'},
            {'F', '.', 'F', '.', 'F', '.', 'F', '.'}
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char [][] com = new char[8][8];

        for(int i=0; i<8; i++){
            String s = br.readLine();
            char [] arr = s.toCharArray();
            for(int j=0; j<8; j++)
                com[i][j] = arr[j];
        }

        int count = 0;

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(chess[i][j] == '.' && com[i][j] != '.')
                    count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
