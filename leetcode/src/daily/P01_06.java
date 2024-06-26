package daily;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。
 * 利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你
 * 可以假设字符串中只包含大小写英文字母（a至z）。
*/
public class P01_06 {
    public String compressString(String S) {
        StringBuilder res = new StringBuilder();
        if(S.length() == 0)return res.toString();
        int cnt = 1;
        char c = S.charAt(0);
        for(int i = 1; i < S.length(); i++){
            if(c == S.charAt(i)) cnt++;
            else{
                res.append(c);
                res.append(cnt);
                cnt = 1;
                c = S.charAt(i);
            }
        }
        res.append(c);
        res.append(cnt);
        return res.length() < S.length() ? res.toString() : S;
    }
}
