package lc;

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
     * 225-error
     * 106-1
     * 270-0
     * 76-0
     * 315-3
     * 28-error
     * 124-0
     * 273-2
     * 77-1
     * 232-error
     * 97-0
     * 107-1
     * 4-error
     * 862-0
     * 428-2
     * 974-2
     * 426-1
     * 94-0
     * 516-error
     * 42-0
     * 91-1
     * 41-error
     * 47-1
     * 84-1
     * 98-0
     * 48-0
     * 33-1
     * 95-0
     * 56-0
     * 206-0
     * 92-1
     * 25-0
     * 2-0
     * 21-0
     * 23-1
     * 257-2
     * 160-0
     * 316-2
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> all = List.of(1143, 97, 72, 115, 5, 312, 516, 300, 53, 152, 547, 305, 128, 78, 90, 46, 47, 77, 127, 490, 1,
                16, 18, 3, 76, 992, 342, 28, 307, 315, 382, 384, 208, 745, 270, 450, 98, 96, 95, 144, 94, 145, 107, 297, 428,
                105, 106, 426, 235, 236, 124, 257, 206, 92, 25, 2, 23, 142, 287, 203, 82, 83, 138, 160, 234, 253, 218, 56, 57, 560,
                862, 209, 4, 410, 496, 503, 739, 316, 42, 84, 239, 862, 1425, 146, 460, 225, 232, 155, 772, 273, 20, 32, 22, 912,
                48, 207, 33, 200, 93, 89, 91, 402, 31, 148, 974, 166, 41, 21);
        Set<Integer> errorList = Set.of(1425, 225, 28, 232, 4, 516, 41);
        Set<Integer> done = Set.of(20, 5, 155, 209, 78, 450, 127, 128, 96, 235, 992, 144, 739, 145, 384, 18, 300, 503, 106, 270, 76,
                315, 124, 273, 77, 97, 107, 862, 428, 974, 426, 94, 42, 91, 47, 84, 98, 48, 33, 95, 56, 206, 92, 25, 2, 21, 23, 257,
                160, 316);
        Random random = new Random();
        int r = 0;
        int f = 0;
        for (int i = 0; i < all.size(); i++) {
            Integer v = all.get(i);
            if (!done.contains(v) && !errorList.contains(v)) {
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
