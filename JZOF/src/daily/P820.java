package daily;

import java.util.*;

/**
 * 820. 单词的压缩编码
 * 字典树
*/

class Trie{
    int count;
    Trie[] children;
    boolean hasChild;
    Trie(){
        children = new Trie[26];
        for(Trie t:children){
            t = null;
        }
        hasChild = false;
        count = 0;
    }
    Trie getChildren(char c){
        if(children[c-'a'] == null){
            Trie node = new Trie();
            node.count = count+1;
            children[c-'a'] = node;
        }
        hasChild = true;
        return children[c-'a'];
    }

}

public class P820 {

    public static void main(String[] args) {
        P820 test = new P820();
        String[] words = new String[]{"time", "me", "bell"};
        int res = test.minimumLengthEncoding(words);
        System.out.println(res);
    }

    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Set<Trie> set = new HashSet<>();
        Trie t = new Trie();
        for(String s:words){
            Trie leaf = t;
            for(int i = s.length()-1; i >= 0; --i){
                leaf = leaf.getChildren(s.charAt(i));
            }
            set.add(leaf);
        }
        for(Trie tmp:set){
            if(tmp.hasChild == false){
                res += (tmp.count+1);
            }
        }
        return res;
    }
}
