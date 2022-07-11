package Silver3.baekjoon_2108;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int [] result = solution(arr);

        for(int n : result)
            bw.write(n + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int [] solution(int [] arr){
        /*
        arr = 정수 배열
        return : new int[4] : 산술평균, 중앙값, 최빈값, 범위
         */
        int [] result = new int[4];

        Arrays.sort(arr);

        // 1. 산술평균
        double sum = 0;
        for(int n : arr)
            sum += n;
        result[0] = (int) Math.round(sum/arr.length);

        // 2. 중앙값
        result[1] = arr[arr.length/2];

        // 3. 최빈값
        if(N==1){
            result[2] = arr[0];
        }
        else{
            HashMap<Integer, Integer> hm = new HashMap<>();

            for(int n : arr){
                if(hm.containsKey(n))
                    hm.put(n, hm.get(n) + 1);
                else
                    hm.put(n, 1);
            }

            int max_count = Collections.max(hm.values());
            // 최빈값의 count

            ArrayList<Integer> list = new ArrayList<>();
            // 최빈값 add list

            for(Integer n : hm.keySet()){
                if(hm.get(n) == max_count)
                    list.add(n);
            }

            Collections.sort(list);

            if(list.size() > 1)
                result[2] = list.get(1);
            else
                result[2] = list.get(0);
        }

        // 4. 범위
        result[3] = Math.abs(arr[0] - arr[arr.length-1]);

        return result;
    }
}
