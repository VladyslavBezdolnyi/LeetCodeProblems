package com.vladyslav;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] myResultSet = {2,7,11,15};
        System.out.println(Arrays.toString(sol.twoSum(myResultSet, 18)));

    }
}

class Solution {
    
    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.*/
    public int[] twoSum(int[] nums, int target) { // 2, 7, 11, 15

        int[] resultTwoNumsIndexes = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    resultTwoNumsIndexes[0] = i;
                    resultTwoNumsIndexes[1] = j;
                }
            }
        }
        return resultTwoNumsIndexes;

        /*
        O(n)
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;*/
    }

    public int[] getConcatenation(int[] nums) {

        int[] ans = new int[nums.length * 2];
        for (int i = 0, j = 0; i < nums.length * 2; i++, j++){
            if (i == nums.length){
                j = 0;
            }
            ans[i] = nums[j];
        }
        return ans;
    }
}

class CustomTest{

    public static int[] arrayOfMultiples(int num, int length) {
        int[] resultArray = new int[length];
        resultArray[0] = num;
        for (int i = 1; i < length; i++){
            resultArray[i] = num;
            num += num;
        }
        return resultArray;
    }

    public static String sevenBoom(int[] arr) {
        for (int value : arr){
            for(String character : String.valueOf(value).split("")){
                if (character.equals("7")){
                    return "Boom!";
                }
            }
        }
        return "there is no 7 in the array";
    }


    public static String nameShuffle(String s) {
        String[] splitName = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(splitName[1])
                .append(" ")
                .append(splitName[0]);

        return stringBuilder.toString();
    }

    public static String stutter(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder firstTwoLetters =
                new StringBuilder()
                        .append(word.charAt(0))
                        .append(word.charAt(1));

        stringBuilder
                .append(firstTwoLetters)
                .append("...")
                .append(" ")
                .append(firstTwoLetters)
                .append("...")
                .append(" ")
                .append(word)
                .append("?");

        return stringBuilder.toString();
    }
}
