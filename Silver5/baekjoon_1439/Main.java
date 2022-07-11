package Silver5.baekjoon_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().strip();

        int oneToZero = 0; // 1 -> 0로 변경
        int zeroToOne = 0; // 0 -> 1으로 변경

        if(line.charAt(0) == '0'){
            // 0 -> 1로 변경하는 케이스에서 첫번째 숫자가 0이면
            zeroToOne++;
        } else {
            // 1 -> 0으로 변경하는 케이스에서 첫번째 숫자가 1이면
            oneToZero++;
        }

        for(int i=0; i<line.length() - 1; i++){
            if(line.charAt(i) != line.charAt(i + 1)){ // 비교하는 두 숫자가 다른 경우 (0 -> 1 or 1 -> 0)
                if(line.charAt(i + 1) == '0'){
                    zeroToOne++;
                } else {
                    oneToZero++;
                }
            }
        }

        System.out.println(Math.min(oneToZero, zeroToOne));
    }
}

