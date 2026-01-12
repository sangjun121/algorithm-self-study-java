package me.sangjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();

        int[] firstWord = new int[26];
        int[] secondWord = new int[26];

        for (char token : first.toCharArray()) {
            firstWord[token - 'a']++;
        }

        for (char token : second.toCharArray()) {
            secondWord[token - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(firstWord[i] - secondWord[i]);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
