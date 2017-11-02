package tf_idf;

import javafx.util.Pair;
import org.ansj.domain.Term;
import segmenter.ChineseSegmentationImpl;
import util.StockSorterImpl;
import vo.StockInfo;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class TF_IDFImpl implements TF_IDF {

    private ChineseSegmentationImpl segmentation = new ChineseSegmentationImpl();
    private StockSorterImpl sorter = new StockSorterImpl();

    @Override
    public Pair<String, Double>[] getResult(List<String> words, StockInfo[] stockInfos) {
        Hashtable<String, Double> termTable = new Hashtable<>();

        //某个词出现次数
        for (String word : words) {
            if (termTable.get(word) != null) {
                termTable.put(word, termTable.get(word) + 1);
            } else {
                termTable.put(word, 1.0);
            }
        }
        
        int wordsSum = words.size();        //文章总词数
        int docSum = stockInfos.length;     //文档总数

        Pair<String,Double>[] pairs = new Pair[termTable.size()];
        int i = 0;

        Iterator iterator = termTable.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            termTable.put(key, termTable.get(key) / wordsSum);      //TF

            double frequency = getTermSum(key, stockInfos);     //包含该词的文档数
            double idf = Math.log(docSum / (frequency + 1));        //IDF
            termTable.put(key, termTable.get(key) * idf);        //TF*IDF

            pairs[i] = new Pair<>(key, termTable.get(key));
            i++;
        }

        //从大到小排序
        pairs = sorter.sort(pairs);

        return pairs;
    }

    //获取包含某特定词的文档总数
    public int getTermSum(String word, StockInfo[] stockInfos) {
        int sum = 0;

        for (StockInfo stockInfo : stockInfos) {
            List<Term> terms = segmentation.getWordsFromStock(stockInfo);

            for (Term term : terms) {
                if (term.getName().equals(word)) {
                    sum++;
                    break;
                }
            }

        }

        return sum;
    }


}

/*
实现接口 TF_IDF， 要求根据给定词汇数组，算出各个词汇tf-idf值，
接口中所描述的频率排序指的就是tf-idf排序，按照值的大小 从大到小 排序后，生成Pair类型数组

 （ 运行后会有可视化词云效果图，本效果图运用d 3js 可视化库生成，感兴趣的同学可以研究），
 排序可以修改StockSorter接口中定义的方法来实现重用第一次实验所写的排序算法
 */