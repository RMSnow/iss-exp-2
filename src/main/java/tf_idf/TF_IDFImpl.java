package tf_idf;

import javafx.util.Pair;
import vo.StockInfo;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class TF_IDFImpl implements TF_IDF {

    @Override
    public Pair<String, Double>[] getResult(List<String> words, StockInfo[] stockInfos) {
        /*
         * 计算TF. TF = 某个词出现次数 ／ 文章中的总词数
         */

        Hashtable<String, Double> termTable = new Hashtable<>();

        //出现次数
        for (String word : words) {
            if (termTable.get(word) != null) {
                termTable.put(word, termTable.get(word) + 1);
            } else {
                termTable.put(word, 1.0);
            }
        }

//        //print test
//        Iterator iterator1 = termTable.keySet().iterator();
//        while (iterator1.hasNext()){
//            String key = (String) iterator1.next();
//            System.out.println(key+": "+termTable.get(key));
//        }

        //TF值
        int wordsSum = words.size();
        Iterator iterator = termTable.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            termTable.put(key, termTable.get(key) / wordsSum);
        }

//        //print test
//        Iterator iterator2 = termTable.keySet().iterator();
//        while (iterator2.hasNext()){
//            String key = (String) iterator2.next();
//            System.out.println(key+": "+termTable.get(key));
//        }

        /*
         * 计算IDF
         */


        return null;
    }


}

/*
实现接口 TF_IDF， 要求根据给定词汇数组，算出各个词汇tf-idf值，
接口中所描述的频率排序指的就是tf-idf排序，按照值的大小 从大到小 排序后，生成Pair类型数组

 （ 运行后会有可视化词云效果图，本效果图运用d 3js 可视化库生成，感兴趣的同学可以研究），
 排序可以修改StockSorter接口中定义的方法来实现重用第一次实验所写的排序算法
 */