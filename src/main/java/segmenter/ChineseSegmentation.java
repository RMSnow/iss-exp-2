package segmenter;

import vo.StockInfo;

import java.util.List;

public interface ChineseSegmentation {

    /**
     * this func will get chinese word from a list of stocks. You need analysis stocks' answer and get answer word.
     * And implement this interface in the class : ChineseSegmentationImpl
     * Example: 我今天特别开心 return : 我 今天 特别 开心
     * @param stocks stocks info
     * @return chinese word
     * @see ChineseSegmentationImpl
     */
    List<String> getWordsFromInput(StockInfo[] stocks);

}
