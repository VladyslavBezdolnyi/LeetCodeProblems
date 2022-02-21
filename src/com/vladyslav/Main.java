package com.vladyslav;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("xaabacxcabaaxcabaax"));
    }


}

class Solution {


    /*    Given a string s, return the longest palindromic substring in s.*/
    public String longestPalindrome(String s) {

        if (s.length() == 1){
            return s;
        }

        class PalindromeNode {
            private final int[] indexes = new int[2];

            PalindromeNode(int firstIndex, int lastIndex){
                indexes[0] = firstIndex;
                indexes[1] = lastIndex;
            }

            public int getFirst(){
                return indexes[0];
            }

            public int getLast(){
                return indexes[1];
            }
        }

        Map<String, ArrayList<Integer>> groupByCharAndIndex = new HashMap<>();
        String[] splitArray = s.split("");
        TreeMap<Integer, PalindromeNode> finalResultNodes = new TreeMap<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < s.length(); i++){
            if (groupByCharAndIndex.containsKey(splitArray[i])){
                groupByCharAndIndex.get(splitArray[i]).add(i);
            }
            else {
                groupByCharAndIndex.put(splitArray[i], new ArrayList<Integer>(List.of(i)));
            }
        }

        //change this to priority queue
        Map<Integer, PalindromeNode> sortedNodes = new TreeMap<>((o1, o2) -> o2 - o1);
        for (var entry : groupByCharAndIndex.entrySet()) {
            if (entry.getValue().size() == 1) {
                continue;
            }
            for (int i = 0; i < entry.getValue().size() - 1; i++) {
                for (int j = i + 1; j < entry.getValue().size(); j++) {
                    sortedNodes.put(Math.abs(entry.getValue().get(i) - entry.getValue().get(j)) + 1,
                            new PalindromeNode(entry.getValue().get(i), entry.getValue().get(j)));
                }
            }
        }

        Function<PalindromeNode, Boolean> isPalindrome = (node) -> {
                for (int i = node.getFirst(), j = node.getLast(); i < j; i++, j--){
                    if (!splitArray[i].equals(splitArray[j])){
                        return false;
                    }
                }
                return true;
            };

        for (var sortedEntry : sortedNodes.entrySet()){
            if(isPalindrome.apply(sortedEntry.getValue())){
                finalResultNodes.put(sortedEntry.getKey(), sortedEntry.getValue());
                break;
            }
        }

        if (finalResultNodes.isEmpty()){
            return splitArray[0];
        }
        return s.substring(finalResultNodes.firstEntry().getValue().getFirst(), finalResultNodes.firstEntry().getValue().getLast() + 1);
    }

   /* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.*/
    public boolean wordBreak(String s, List<String> wordDict) {

        StringBuilder resultString = new StringBuilder(s);
        for (String value : wordDict){
            int indexOfContainedValue = resultString.indexOf(value);
            if(indexOfContainedValue == -1){
                return false;
            }
            else {
                resultString.delete(indexOfContainedValue, indexOfContainedValue + value.length());
                if (resultString.length() == 0){return true;}
            }

        }
        return resultString.length() == 0 || wordBreak(resultString.toString(), wordDict);

    }
   /* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.*/
    public int singleNumber(int[] nums) {  // 2, 2, 3
        Set<Integer> counterMap = new HashSet<>();
        for (int num : nums) {
            if (counterMap.contains(num)) {
                counterMap.remove(num);
            } else {
                counterMap.add(num);
            }
        }
        return new ArrayList<Integer>(counterMap).get(0);
    }

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
