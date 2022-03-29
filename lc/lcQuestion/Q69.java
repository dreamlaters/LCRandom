package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/29 16:26
 *
 * @author huajie.zuo
 */
public class Q69 {
    public int mySqrt(int x) {
        int l = 0, r = 46340, mid = 0;
        while (true) {
            mid = l + (r - l) / 2;
            if (mid == l) {
                if (check(l, x) == 0) {
                    return l;
                } else {
                    return r;
                }
            }
            int c = check(mid, x);
            if (c == 0) {
                return mid;
            } else if (c < 0) {
                l=mid;
            } else {
                r=mid;
            }
        }
    }

    private int check(int mid, int x) {
        int r = mid * mid;
        int b = (mid + 1) * (mid + 1);
        if (r == x || (r < x && x < b)) {
            return 0;
        }
        if (r > x) {
            return 1;
        }
        return -1;
    }
}
