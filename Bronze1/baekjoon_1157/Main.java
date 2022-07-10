package Bronze1.baekjoon_1157;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine().toUpperCase();
        String [] arr = word.split("");

        HashMap<String, Integer> hm = new HashMap<>();

        for(String s : arr){
            if(hm.containsKey(s))
                hm.put(s, hm.get(s) + 1);
            else
                hm.put(s, 1);
        }

        List<String> keySet = new ArrayList<>(hm.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(hm.get(o1) > hm.get(o2))
                    return -1;
                else if(hm.get(o1) < hm.get(o2))
                    return 1;
                else
                    return 0;
            }
        });

        String maxA = keySet.remove(0);
        int max = hm.get(maxA);

        boolean check = false;
        for(String key : keySet){
            if(max == hm.get(key))
                check = true;
        }

        if(check)
            bw.write("?\n");
        else
            bw.write(maxA + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
