package tf_idf;

import segmenter.ChineseSegmentation;
import segmenter.ChineseSegmentationImpl;
import util.FileHandler;
import util.FileHandlerImpl;
import vo.StockInfo;

import java.util.List;

/**
 * Created by snow on 02/11/2017.
 */
public class Test {
    public static void main(String[] args){
        FileHandler fileHandler = new FileHandlerImpl();
        StockInfo[] stockInfos = fileHandler.getStockInfoFromFile("src/main/resources/data.txt");

        ChineseSegmentation chineseSegmentation = new ChineseSegmentationImpl();
        List<String> words = chineseSegmentation.getWordsFromInput(stockInfos);

        TF_IDF tf_idf = new TF_IDFImpl();
        tf_idf.getResult(words, stockInfos);
    }
}
