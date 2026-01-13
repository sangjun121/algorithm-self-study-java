package me.sangjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String docs = br.readLine();
        String word = br.readLine();

        /**
         * 1. 새 객체 String을 만드는 방법 -> 객체생성 포인트에서 손해
         */
//        int count = 0;
//        while (true) {
//            int index = docs.indexOf(word);
//            if (index == -1) {
//                break;
//            } else {
//                count++;
//                docs = docs.substring(index + word.length());
//            }
//        }

        /**
         * 2. 새 객체를 만들지 않고 탐색하는 방법
         */
        int count = 0;
        int pos = 0;
        while (true) {
            int index = docs.indexOf(word, pos);
            if (index == -1) {
                break;
            } else {
                count++;
                pos = word.length() + index;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
