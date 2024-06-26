package daily;

/**
 * 8. 字符串转换整数 (atoi)
*/

public class P8 {
    public static void main(String[] args) {
        P8 test = new P8();
        System.out.println(test.myAtoi("1095502006p8"));
    }
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean empty_tag = true;
        boolean negative_tag = false;
        for(int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if (c == ' ' && empty_tag) {
                sb.deleteCharAt(i);
                --i;
            } else if (c == '+' && empty_tag) {
                sb.deleteCharAt(i);
                empty_tag = false;
                --i;
            } else if (c == '-' && empty_tag) {
                sb.deleteCharAt(i);
                empty_tag = false;
                negative_tag = true;
                --i;
            } else if (!Character.isDigit(c)) {
                sb.delete(i,sb.length());
                break;
            } else{
                empty_tag = false;
            }
        }
        for(int i = 0; i < sb.length(); ++i){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
                --i;
            }else break;
        }
        String s = sb.toString();
        if(s.equals(""))return 0;
        else if(negative_tag){
            String min = Integer.toString(Integer.MIN_VALUE);
            min = min.substring(1);
            if(s.length() > min.length())return Integer.MIN_VALUE;
            else if(s.length() < min.length()){
                String res = "-" + s;
                return Integer.parseInt(res);
            }
            else{
                for(int i = 0; i < s.length(); ++i){
                    if(s.charAt(i) > min.charAt(i))return Integer.MIN_VALUE;
                    else if(s.charAt(i) < min.charAt(i))break;
                }
                String res = "-" + s;
                return Integer.parseInt(res);
            }
        }
        else{
            String max = Integer.toString(Integer.MAX_VALUE);
            if(s.length() > max.length())return Integer.MAX_VALUE;
            else if(s.length() < max.length())return Integer.parseInt(s);
            else{
                for(int i = 0; i < s.length(); ++i){
                    if(s.charAt(i) > max.charAt(i))return Integer.MAX_VALUE;
                    else if(s.charAt(i) < max.charAt(i))break;
                }
                return Integer.parseInt(s);
            }
        }
    }
}
