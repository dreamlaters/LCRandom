package lc.lcQuestion;

/**
 * Description:
 * date: 2022/3/28 17:10
 *
 * @author huajie.zuo
 */
public class Q468 {
    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334"));
    }
    public static String validIPAddress(String queryIP) {
        try {
            if (queryIP.startsWith(":") || queryIP.startsWith(".") || queryIP.endsWith(":") || queryIP.endsWith(".")) {
                return "Neither";
            }
            if (queryIP.contains(".")) {
                String[] nums=queryIP.split("\\.");
                if(nums.length==4){
                    for (String num : nums) {
                        Integer n=Integer.valueOf(num);
                        if(0<=n && n<256 && String.valueOf(n).equals(num)){
                            continue;
                        }else {
                            return "Neither";
                        }
                    }
                    return "IPv4";
                }
            } else if (queryIP.contains(":")) {
                String[] nums=queryIP.split(":");
                if(nums.length==8){
                    for (String num : nums) {
                        int l=num.length();
                        if(l>0 && l<=4){
                            Integer.parseInt(num,16);
                        }else {
                            return "Neither";
                        }
                    }
                    return "IPv6";
                }
            }
        }catch (Exception e){
            return "Neither";
        }
        return "Neither";
    }
}
