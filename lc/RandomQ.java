package lc;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
     * 225-2
     * 106-1
     * 270-0
     * 76-0
     * 315-2
     * 28-error
     * 124-0
     * 273-2
     * 77-1
     * 232-1
     * 97-0
     * 107-1
     * 4-error
     * 862-0
     * 428-2
     * 974-2
     * 426-1
     * 94-0
     * 516-1
     * 42-0
     * 91-1
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
     * 32-2
     * 146-0
     * 460-2
     * 142-0
     * 148-1
     * 305-0
     * 22-1
     * 253-0
     * 912-0
     * 207-1
     * 236-0
     * 200-0
     * 105-0
     * 560-0
     * 39-1
     * 83-2
     * 402-2
     * 79-1
     * 234-1
     * 103-0
     * 215-1
     * 90-2
     * 62-0
     * 347-error
     * 239-1
     * 287-2
     * 89-1
     * 468-1
     * 57-error
     * 41-2
     * 82-1
     * 72-1
     * 410-0
     * 772-1
     * 547-0
     * 139-2
     * 152-3
     * 69-0
     * 382-0
     * 3-0
     * 138-3
     * 8-error
     * 166-3
     * 10051-1
     * 53-0
     * 752-1
     * 93-1
     * 297-0
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> all = List.of(1143, 97, 72, 115, 5, 312, 516, 300, 53, 152, 547, 305, 128, 78, 90, 46, 47, 77, 127, 490, 1,
                16, 18, 3, 76, 992, 342, 28, 307, 315, 382, 384, 208, 270, 450, 98, 96, 95, 144, 94, 145, 107, 297, 428, 166,
                105, 106, 426, 235, 236, 124, 257, 206, 92, 25, 2, 23, 142, 287, 203, 82, 83, 138, 160, 234, 253, 218, 56, 57, 560,
                862, 209, 4, 410, 496, 503, 739, 316, 42, 84, 239, 62, 64, 1425, 146, 460, 225, 232, 155, 772, 273, 20, 32, 22, 912,
                48, 207, 33, 200, 93, 89, 91, 402, 31, 148, 974, 21, 743, 215, 151, 468, 93, 752, 39, 8, 103, 89, 69, 210,
                41, 337, 79, 109, 139, 347, 143, 283, 10051);
        Set<Integer> errorList = Set.of(1425, 28, 4, 743, 347, 57, 8);
        Set<Integer> done = Set.of(20, 5, 155, 209, 78, 450, 127, 128, 96, 235, 992, 144, 739, 145, 384, 18, 300, 503, 106, 270, 76,
                315, 124, 273, 77, 97, 107, 862, 428, 974, 426, 94, 42, 91, 47, 84, 98, 48, 33, 95, 56, 206, 92, 25, 2, 21, 23, 257,
                160, 316, 32, 146, 460, 142, 148, 305, 225, 232, 516, 22, 253, 912, 208, 207, 236, 200, 105, 560, 39, 83, 402, 79,
                234, 103, 215, 90, 62, 239, 89, 468, 287, 41, 82, 72, 410, 772, 547, 139, 152, 69, 382, 3, 138, 10051, 53, 752, 93,
                297, 166);
        Random random = new Random();
        int r = 0;
        int f = 0;
        //来个水塘抽样
        for (int i = 0; i < all.size(); i++) {
            Integer v = all.get(i);
            if (!done.contains(v) && !errorList.contains(v)) {
                int ran = random.nextInt(++f);
                if (ran == 0) {
                    r = v;
                }
            }
        }
        BigDecimal donePercent = BigDecimal.valueOf(100.0 * done.size() / all.size()).setScale(2, RoundingMode.HALF_DOWN);
        System.out.println("共计" + all.size() + "题");
        System.out.println("已完成" + done.size() + "题");
        System.out.println("已完成" + donePercent + "%的题");
        System.out.println(r);
    }
}
