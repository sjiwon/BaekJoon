package Gold5.baekjoon_2447;

import java.io.*;
public class Main {
    static String [][] star;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        star = new String[N][N];

        for(int i=0; i<star.length; i++){
            for(int j=0; j<star[i].length; j++)
                star[i][j] = " ";
        }

        star_print(0, 0, N);

        for(int i=0; i<star.length; i++){
            for(int j=0; j<star[i].length; j++){
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void star_print(int x, int y, int num){
        if(num==1){
            star[x][y] = "*";
            return;
        }

        int n = num/3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i==1 && j==1))
                    star_print(x + i*n, y + j*n, n);
            }
        }
    }
}
