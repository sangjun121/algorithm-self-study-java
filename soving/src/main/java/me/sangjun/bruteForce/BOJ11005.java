package me.sangjun.bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int target = Integer.parseInt(input[0]);
        int base = Integer.parseInt(input[1]);

        StringBuilder result = new StringBuilder();
        while ((target / base) > 0) {
            result.insert(0, parse(target % base));
            target /= base;
        }
        if (target % base != 0) {
            result.insert(0, parse(target % base));
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    private static String parse(int target) {
        if (10 <= target && target <= 35) {
            return Character.toString(target - 10 + 'A');
        }
        return Integer.toString(target);
    }
}
