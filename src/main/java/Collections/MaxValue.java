package Collections;

import java.util.Map;

public class MaxValue {

    public static String getKeyOfMaxValue(Map<String, Integer> map) {
        int max = 0;
        String maxKey = null;
        int temp;
        String tempMaxKey;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            temp = entry.getValue();
            tempMaxKey = entry.getKey();
            if (max < temp) {
                max = temp;
                maxKey = tempMaxKey;
            }
        }
        return maxKey;
    }
}
