package ch1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuchao
 * @create 2022-07-14-10:16 PM
 */
public class Result {

    public static List<String> processLogs(List<String> logs, int threshold) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> idCount = new HashMap<>();

        for (String s : logs) {
            String[] array = s.split(" ");
            Integer fromId = Integer.parseInt(array[0]);
            Integer toId = Integer.parseInt(array[1]);

            if (idCount.containsKey(fromId)) {
                idCount.put(fromId, idCount.get(fromId) + 1);
            } else {
                idCount.put(fromId, 1);
            }

            if (!toId.equals(fromId)) {
                if (idCount.containsKey(toId)) {
                    idCount.put(toId, idCount.get(toId) + 1);
                } else {
                    idCount.put(toId, 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : idCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        result.sort(Comparator.naturalOrder());

        return result.stream().map(String::valueOf).collect(Collectors.toList());
    }

    public static int countGroups(List<String> related) {
        // Write your code here
        Set<String> set = new HashSet<>();
        return 1;
    }
}
