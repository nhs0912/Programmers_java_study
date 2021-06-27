package step2.p73439;


import java.util.HashMap;
import java.util.Map;


class Solution {

    public int addExistsPlayerNumber(String paticipatePlayer, Map<String, Integer> map) {
        return map.get(paticipatePlayer) == null ? 1 : map.get(paticipatePlayer) + 1;
    }

    public int removeExistsPlayerNumber(String completePlayer, Map<String, Integer> map) {
        return map.get(completePlayer) - 1;
    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for (String paticipatePlayer : participant) {
            map.put(paticipatePlayer, addExistsPlayerNumber(paticipatePlayer, map));
        }

        for (String completePlayer : completion) {
            map.put(completePlayer, removeExistsPlayerNumber(completePlayer, map));
        }
        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

    }


}


public class P73439 {
    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden", "kiki"};
        String[] completion = new String[]{"kiki", "eden"};

        String result = new Solution().solution(participant, completion);
        System.out.println(result);
    }

}
