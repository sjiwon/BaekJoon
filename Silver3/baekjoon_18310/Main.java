package Silver3.baekjoon_18310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] house = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);
        if(house.length % 2 == 0){
            System.out.println(house[house.length/2 - 1]);
        } else {
            System.out.println(house[house.length/2]);
        }
    }
}
