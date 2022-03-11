import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * date: 2022/3/10 15:22
 *
 * @author huajie.zuo
 */
public class Q127 {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit",
                "cog",
                        List.of("hot","dot","dog","lot","log","cog")));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Set<String> begin=new HashSet<>();
        begin.add(beginWord);
        Set<String> end=new HashSet<>();
        end.add(endWord);
        Set<String> next=new HashSet<>();
        int index=1;
        while(!begin.isEmpty()){
            index++;
            next=new HashSet<>();
            for (String s : begin) {
                char[] cs=s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        if((char)('a'+j)!=cs[i]){
                            char o=cs[i];
                            cs[i]=(char)('a'+j);
                            String newOne=String.valueOf(cs);
                            cs[i]=o;
                            if(end.contains(newOne)){
                                return index;
                            }
                            if(wordSet.remove(newOne)){
                                next.add(newOne);
                            }
                        }
                    }
                }
            }
            if(next.size()>end.size()){
                begin=end;
                end=next;
            }else{
                begin=next;
            }
        }
        return 0;
    }
}
