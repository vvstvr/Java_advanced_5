package Collections;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticWords {

    public static Map <String, Integer> doStatisticsFromSortedList (List<String> words){

        Map <String,Integer> afterStat = new TreeMap <String, Integer> ();
        int times = 1;
        afterStat.put(words.get(0),times);

        for (int i = 1 ; i<words.size(); i++){
            if(afterStat.containsKey(words.get(i))) afterStat.put(words.get(i),++times);
            else {
                afterStat.put(words.get(i),1);
                times = 1;
            }
        }
        return afterStat;
    }
}
