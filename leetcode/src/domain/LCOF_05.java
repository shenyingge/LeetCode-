package domain;

public class LCOF_05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        String res = replaceSpace(s);
        System.out.println(res);
        System.out.println(res.length());
    }
    public static String replaceSpace(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                cnt++;
            }
        }
        int len = cnt*2+s.length();
//        System.out.println("cnt="+len+"s.length="+s.length());
        char[] cs = new char[len];
        int index = len-1;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                cs[index] = '0'; index--;
                cs[index] = '2'; index--;
                cs[index] = '%'; index--;
            }else{
                cs[index] = s.charAt(i);
                index--;
            }
        }
        String res = new String(cs);
        return res;
    }
}
