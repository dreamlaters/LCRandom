package lc.lcQuestion;

import java.util.HashMap;
import java.util.HashSet;

public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            return "-" + fractionToDecimal(Math.abs((long) numerator), Math.abs((long) denominator));
        } else {
            return fractionToDecimal(Math.abs((long) numerator), Math.abs((long) denominator));
        }
    }

    private String fractionToDecimal(long b, long c) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        if (b >= c) {
            stringBuilder.append(b / c);
        } else {
            stringBuilder.append('0');
        }
        long ys = b % c;
        if (ys == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append('.');
        int i = stringBuilder.length();
        do {
            map.put(ys, i++);
            ys *= 10;
            if (ys >= c) {
                stringBuilder.append(ys / c);
            } else {
                stringBuilder.append('0');
            }
            ys = ys % c;
            if (ys == 0) {
                break;
            }
            if (map.containsKey(ys)) {
                int in = map.get(ys);
                stringBuilder.insert(in, '(');
                stringBuilder.append(')');
                break;
            }
        } while (true);
        return stringBuilder.toString();
    }
}
