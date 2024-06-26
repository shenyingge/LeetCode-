package daily;

/**
 * 1071. 字符串的最大公因子
 * 方法一：枚举
 * 方法二：若str1+str2 != str2+str1，则一定没有符合，反之一定有
 * 且子串长度为最大公约数
*/
public class P1071 {
    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        String s = gcdOfStrings(s1, s2);
        System.out.println(s);
    }

    //方法一

    public static String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }else if(str1.length() == str2.length()){
            if(str1.equals(str2))return str1;
            else return "";
        }
        int times = 1;
        while(times < str2.length()){
            if(str2.length() % times == 0){
                int len = str2.length() / times;
                if(str1.length() % len == 0){
                    String s = str1.substring(0,len);
                    String s1 = s;
                    for(int i = 1; i < times; i++){
                        s1 += s;
                    }
                    if(s1.equals(str2)){
                        int times2 = str1.length()/len;
                        String s2 = s;
                        for(int i = 1; i < times2; i++){
                            s2 += s;
                        }
                        if(s2.equals(str1)) return s;
                    }
                }
            }
            times++;
        }
        return "";
    }

    //方法二

    public String gcdOfStrings1(String str1, String str2){
        if(!(str1 + str2).equals(str2+str1)){
            return "";
        }else{
            return str1.substring(0,GCD(str1.length(),str2.length()));
        }
    }

    public int GCD(int m, int n) {
        int result;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }
}
