package lc.lcQuestion;

import java.util.Arrays;

/**
 * Description:
 * date: 2022/3/30 16:31
 *
 * @author huajie.zuo
 */
public class Q151 {
    public static void main(String[] args) {
        System.out.println(reverseWords(" a good   example  "));
    }
    static char[] cs;
    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        int l=0;
        while(sb.charAt(l)==' '){
            sb.deleteCharAt(l);
        }
        int r=sb.length()-1;
        while(sb.charAt(r)==' '){
            sb.deleteCharAt(r--);
        }
        for (int i = 0; i < sb.length();) {
            if(sb.charAt(i)==' ' && sb.charAt(i-1)==' '){
                sb.deleteCharAt(i);
            }else {
                i++;
            }
        }
        cs=sb.toString().toCharArray();
        reverse(0,cs.length-1);
        l=0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i]==' '){
                reverse(l,i-1);
                l=i+1;
            }
        }
        reverse(l,cs.length-1);
        return String.valueOf(cs);
    }

    public static void reverse(int l,int r){
        for (int i = 0; i <= (r-l)/2; i++) {
            char z=cs[i+l];
            cs[i+l]=cs[r-i];
            cs[r-i]=z;
        }
    }
}
