package segmenter;

import util.FileHandler;
import util.FileHandlerImpl;
import vo.StockInfo;

/**
 * Created by snow on 02/11/2017.
 */
public class Test {
    public static void main(String[] args){
        FileHandler fileHandler = new FileHandlerImpl();
        StockInfo[] stockInfos = fileHandler.getStockInfoFromFile("src/main/resources/data.txt");

        ChineseSegmentation chineseSegmentation = new ChineseSegmentationImpl();
        chineseSegmentation.getWordsFromInput(stockInfos);
    }
}
