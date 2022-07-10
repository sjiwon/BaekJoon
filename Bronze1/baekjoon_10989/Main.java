package Bronze1.baekjoon_10989;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int [] result = counting_sort(arr);

        for(int i=0; i<result.length; i++)
            bw.write(result[i] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int get_max(int [] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++)
            if (arr[i]>max)
                max = arr[i];
        return max;
    }

    static int [] counting_sort(int[] arr){
        int [] c = new int[get_max(arr)+1];
        int [] result = new int[arr.length];

        for(int i=0; i<arr.length; i++)
            c[arr[i]]++;

        for(int i=1; i<c.length; i++)
            c[i] += c[i-1];

        for(int i=arr.length-1; i>=0; i--){
            int value = arr[i];
            c[value]--;
            result[c[value]] = value;
        }

        return result;
    }
}
