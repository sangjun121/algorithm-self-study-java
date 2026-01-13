package me.sangjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = bufferedReader.readLine();

        int[] arr = new int[26];

        for (char token : input.toCharArray()) {
            if ('A' <= token && token <= 'Z') {
                arr[token - 'A']++;
            }
            if ('a' <= token && token <= 'z') {
                arr[token - 'a']++;
            }
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max && arr[i] > 0) {
                max = arr[i];
            }
        }

        int maxCount = 0;
        char maxChar = '?';
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                maxCount++;
                maxChar = (char) (i + 'A');
            }
        }

        if (maxCount == 1) {
            bufferedWriter.write(maxChar);
        } else {
            bufferedWriter.write('?');
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
