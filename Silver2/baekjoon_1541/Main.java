package Silver2.baekjoon_1541;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;

        String str = br.readLine();
        String [] plus_split = str.split("-");
        int [] plus = new int[plus_split.length];

        for(int i=0; i<plus_split.length; i++){
            plus[i] = plus(plus_split[i].split("\\+"));
        }

        result = plus[0];
        for(int i=1; i<plus.length; i++)
            result -= plus[i];

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int plus(String [] input){
        int result = 0;
        for(String s : input)
            result += Integer.parseInt(s);

        return result;
    }
}
