package me.sangjun.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tryCount = Integer.parseInt(br.readLine());

        Integer[] triArray = makeTriple();

        for (int i = 0; i < tryCount; i++) {
            int input = Integer.parseInt(br.readLine());
            if (bruteForce(input, triArray)) {
                bw.write("1\n");
                bw.flush();
            } else {
                bw.write("0\n");
                bw.flush();
            }
        }
        bw.close();
    }

    private static boolean bruteForce(int target, Integer[] tri) {
        for (Integer value : tri) {
            for (Integer item : tri) {
                for (Integer integer : tri) {
                    if ((value + item + integer) == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Integer[] makeTriple() {
        List<Integer> tri = new ArrayList<>();
        int i = 1;

        while (true) {
            int j = i * (i + 1) / 2;
            if (j > 1000) {
                return tri.toArray(new Integer[0]);
            }
            tri.add(j);
            i++;
        }
    }
}
