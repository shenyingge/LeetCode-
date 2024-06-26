package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
*/
public class P1160 {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> m = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < chars.length(); i++){
            char c = chars.charAt(i);
            if(!m.containsKey(c)){
                m.put(c,1);
            }else{
                m.put(c, m.get(c)+1);
            }
        }
        for(int i = 0; i < words.length; i++){
            Map<Character,Integer> tmp_m = new HashMap<>();
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if(!tmp_m.containsKey(c)){
                    tmp_m.put(c,1);
                }else{
                    tmp_m.put(c, tmp_m.get(c)+1);
                }
            }
            boolean tag = true;
            for(char c : tmp_m.keySet()){
                System.out.println(c+" "+tmp_m.get(c));
                if(!m.containsKey(c) || tmp_m.get(c) > m.get(c)){
                    tag = false;
                    break;
                }
            }
            if(tag) cnt += words[i].length();
        }
        return cnt;
    }

}
