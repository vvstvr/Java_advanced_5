package Collections;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class FileList {

    public static List<String> readSomeFile(String fileName) {
        List<String> list = doLineForFile(fileName);
        List<String> words = new ArrayList<String>();
        for (String a: list) {
            if (searchEmptyLine(a))
                for (String b: singleWord(a)) words.add(b);
        }
        return words;
    }

    private static boolean searchEmptyLine (String line){
        Pattern pattern = Pattern.compile("^[\\s]*$");
        Matcher m = pattern.matcher(line);
        if(m.find()) return false;
        else return true;
    }

    private static List<String> doLineForFile (String fileName) {
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<String>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getStackTrace());
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IOException " + e.getStackTrace());
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list;
        }
    }

    private static String[] singleWord(String someLine) {
        String[] words;
        words = someLine.trim().split("\\s+");
        return words;
    }
}
