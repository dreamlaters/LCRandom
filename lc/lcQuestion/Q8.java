package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/31 14:45
 *
 * @author huajie.zuo
 */
public class Q8 {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (sb.length() != 0 && sb.charAt(i) == ' ') {
            sb.deleteCharAt(i);
        }
        if (sb.length() == 0) {
            return 0;
        }
        boolean zs = true;
        int num = 0;
        if (Character.isDigit(sb.charAt(i)) || sb.charAt(i) == '+') {
            if (Character.isDigit(sb.charAt(i))) {
                num = sb.charAt(i) - '0';
            }
        } else if (sb.charAt(i) == '-') {
            zs = false;
        } else {
            return 0;
        }
        int all = 0;
        while (i < sb.length() - 1 && Character.isDigit(sb.charAt(++i))) {
            all = num * 10 + (sb.charAt(i) - '0');
            if (all / 10 != num) {
                return zs ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = all;
        }
        return zs ? num : -num;
    }
}
