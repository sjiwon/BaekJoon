package Silver5.baekjoon_2941;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String line = br.readLine();

        for(String s : croatia){
            int index = line.indexOf(s);
            if(index != -1)
                line = line.replace(s, "#");
        }

        bw.write(line.length() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
