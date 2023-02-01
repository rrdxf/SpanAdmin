package leetcode;

import java.util.*;

public class leetcode49_字母异位词 {
    public static void main(String[] args) {
        List<List<String>> lists=groupAnagrams(new String [] {"eat", "tea", "tan", "ate", "nat", "bat"},1);
        for (List<String> list:lists){
            for (String s: list){
                System.out.println(s);
            }
            System.out.println();
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        byte [][] juge = new byte [strs.length][26];
        String s;
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            s = strs[i];
            for (int j = 0; j < s.length(); j++){
                juge[i][(int)s.charAt(j)-'a']++;
            }
            StringBuilder ss=new StringBuilder("");
            for (int k = 0; k < 26; k++){
                if (juge[i][k] > 0){
                    ss.append((char) k + 'a');
                    ss.append(juge[i][k]);
                }
            }
            String key = ss.toString();
            if (result.containsKey(key)){
                result.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                result.put(key,list);
            }
        }
        return new ArrayList<>(result.values());
    }
    public static List<List<String>> groupAnagrams(String[] strs,int num) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs){
            char [] ss = s.toCharArray();
            Arrays.sort(ss);
            String s1 = new String(ss);
            if (result.containsKey(s1)){
                result.get(s1).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                result.put(s1,list);
            }
        }
        return new ArrayList<>(result.values());
    }
}
