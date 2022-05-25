package Collections;

import java.util.List;
import java.util.Map;

public class TaskReader {
    public static void main(String[] args) {
        String fileName = "src\\game.txt";

        List<String> massOfWords = FileList.readSomeFile(fileName);
        massOfWords = SortingWords.toSort(massOfWords);

        Map<String, Integer> map = StatisticWords.doStatisticsFromSortedList(massOfWords);
        for(Map.Entry<String, Integer> temp : map.entrySet()){
            System.out.println("Слово: "+temp.getKey() + "; Встречается в файле: " +temp.getValue()+ " раз.");
        }

        String keyForMaxValue = MaxValue.getKeyOfMaxValue(map);
        System.out.println("\n Слово: \""+ keyForMaxValue + "\" больше всех повторяется в файле: "
                            + map.get(keyForMaxValue) + " раз");
    }
}
