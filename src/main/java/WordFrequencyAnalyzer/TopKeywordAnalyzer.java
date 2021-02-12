package WordFrequencyAnalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TopKeywordAnalyzer implements Runnable {
    private final String filepath;

    public TopKeywordAnalyzer(String filepath){
        this.filepath = filepath;
    }
    public void run() {
        ArrayList<String> data=FileUtility.readAndPrintFile(filepath);
        HashMap<String,Integer> keyWordCounter=new HashMap<String,Integer>();
        for(String row:data){
            String[] keywords=row.split(" ");
            for(String keyword:keywords){
                String str=keyword.toLowerCase();
                if(!keyWordCounter.containsKey(str)){
                    keyWordCounter.put(str,1);
                }else{
                    Integer value=keyWordCounter.get(str);
                    keyWordCounter.put(str,value+1);
                }
            }
        }
        ArrayList<KeywordCount> keywordCountArrayList=new ArrayList<KeywordCount>();
        for(String keyword:keyWordCounter.keySet()){
            keywordCountArrayList.add(new KeywordCount(keyword,keyWordCounter.get(keyword)));
        }
        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>() {
            @Override
            public int compare(KeywordCount o1, KeywordCount o2) {
                if(o2.count==o1.count){
                    return o1.keyword.compareTo(o2.keyword);
                }
                return o2.count- o1.count;
            }
        });
        for(KeywordCount keywordCount:keywordCountArrayList){
            System.out.println(keywordCount.keyword+" "+keywordCount.count);
        }
    }
    public static void main(String[] args) {
        ThreadManager threadManager=new ThreadManager(3);
        threadManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyzer("C:\\Users\\sid17\\Desktop\\Anthem.txt"));
        threadManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyzer("C:\\Users\\sid17\\Desktop\\wikepedia.txt"));
        threadManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyzer("C:\\Users\\sid17\\Desktop\\lsdf.txt"));
    }


}
