package com.vladyslav;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
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
