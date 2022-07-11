package Silver5.baekjoon_10814;

import java.io.*;
import java.util.*;
public class Main {

    static class Human{
        private int age;
        private String name;
        Human(int age, String name){
            this.age = age;
            this.name = name;
        }
        int getAge(){
            return age;
        }
        String getName(){
            return name;
        }
        public String toString(){
            return age + " " + name + "\n";
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Human [] h = new Human[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            h[i] = new Human(age, name);
        }

        Arrays.sort(h, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(int i=0; i<N; i++)
            bw.write(h[i].toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
