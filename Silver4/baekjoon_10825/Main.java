package Silver4.baekjoon_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Student{
        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName(){
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }
    }

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            studentList.add(new Student(name, kor, eng, math));
        }

        studentList.sort((o1, o2) -> {
            if(o1.getKor() > o2.getKor()){
                return -1;
            } else if(o1.getKor() < o2.getKor()){
                return 1;
            } else{
                if(o1.getEng() < o2.getEng()){
                    return -1;
                } else if(o1.getEng() > o2.getEng()){
                    return 1;
                } else{
                    if(o1.getMath() > o2.getMath()){
                        return -1;
                    } else if(o1.getMath() < o2.getMath()){
                        return 1;
                    } else{
                        return o1.getName().compareTo(o2.getName());
                    }
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append(student.getName()).append("\n");
        }

        System.out.println(sb);
    }
}
