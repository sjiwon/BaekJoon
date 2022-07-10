package Bronze2.baekjoon_10820;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = null;
        while((s = br.readLine()) != null){
            String Lower = s.replaceAll("[^a-z]", "");
            String Upper = s.replaceAll("[^A-Z]", "");
            String Num = s.replaceAll("[^0-9]", "");
            String Space = s.replaceAll("[^\\s]", "");

            sb.append(Lower.length()).append(" ").append(Upper.length()).append(" ")
                    .append(Num.length()).append(" ").append(Space.length()).append("\n");

        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
