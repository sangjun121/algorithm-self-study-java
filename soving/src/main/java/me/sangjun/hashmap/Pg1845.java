package me.sangjun.hashmap;

import java.util.*;

public class Pg1845 {
    public int solution(int[] nums) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int keyCount = map.size();

        if(N/2 >= keyCount){
            return keyCount;
        } else{
            return N/2;
        }
    }
}

