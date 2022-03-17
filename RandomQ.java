import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomQ {
    /**
     * wrong：
     * 20-0
     * 5-0
     * 155-1
     * 209-0
     * 78-1
     * 450-0
     * 127-2
     * 128-1
     * 96-0
     * 235-0
     * 992-0
     * 144-0
     * 739-0
     * 145-0
     * 384-0
     * 18-0
     * 300-0
     * 1425-error
     * 503-0
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> all = List.of(1143, 97, 72, 115, 5, 312, 516, 300, 53, 152, 547, 305, 128, 78, 90, 46, 47, 77, 127, 490, 1, 16, 18, 3, 76, 992, 342, 28, 307, 315, 382, 478, 384, 208, 745, 270, 450, 98, 96, 95, 144, 94, 145, 107, 297, 428, 105, 106, 426, 235, 236, 124, 257, 206, 92, 25, 2, 23, 142, 287, 203, 82, 83, 138, 160, 234, 253, 218, 56, 57, 560, 862, 209, 4, 410, 496, 503, 739, 316, 42, 84, 239, 862, 1425, 146, 460, 225, 232, 155, 772, 273, 20, 32, 22, 912);
        Set<Integer> listNode = Set.of(206, 92, 25, 2, 23, 142, 287, 203, 82, 83, 138, 160, 234);
        Set<Integer> done = Set.of(20, 5, 155, 209, 78, 450, 127, 128, 96, 235, 992, 144, 739, 145, 384, 18, 300, 503);
        Random random = new Random();
        int r = 0;
        int f = 0;
        for (int i = 0; i < all.size(); i++) {
            Integer v = all.get(i);
            if (!listNode.contains(v) && !done.contains(v)) {
                f++;
                int ran = random.nextInt(f);
                if (ran == 0) {
                    r = v;
                }
            }
        }
        System.out.println(r);
    }
}
