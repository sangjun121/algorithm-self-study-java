package me.sangjun.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ( 'A' <= chars[i] && chars[i] <= 'Z'){
                chars[i] = (char) (chars[i] - 'A' + 'a');
            }
            else if( 'a' <= chars[i] && chars[i] <= 'z'){
                chars[i] = (char) (chars[i] - 'a' + 'A');
            }
        }

        String result = new String(chars);

        bw.write(result);
        bw.close();
    }
}
