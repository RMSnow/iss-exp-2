package segmenter;


import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import vo.StockInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChineseSegmentationImpl implements ChineseSegmentation {

    @Override
    public List<String> getWordsFromInput(StockInfo[] stocks) {
        List<String> words = new ArrayList<>();

        for(StockInfo stockInfo : stocks){
//            String str = stockInfo.answer;
//            Result result = ToAnalysis.parse(str);
//            List<Term> terms = result.getTerms();

            List<Term> terms = getWordsFromStock(stockInfo);

//            //设置词性
//            Set<String> expectedNature = new HashSet<String>() {{
//                //名词，动词，副动词，名动词，趋向动词
//                //形式动词，不及物动词（内动词），动词性惯用语，动词性语素
//                //机构团体名，其它专名，名词性惯用语，名词性语素，新词
//                //用户自定义，单位符号
//                add("n");add("v");add("vd");add("vn");add("vf");
//                add("vx");add("vi");add("vl");add("vg");
//                add("nt");add("nz");add("nw");add("nl");
//                add("ng");add("userDefine");add("wh");
//            }};

//            //查看answer
//            System.out.println("-----"+stockInfo.id+"-----");
//            System.out.println(stockInfo.answer);

            for(Term term : terms){
                //省略标点符号与未知词
                String natureStr = term.getNatureStr();
                if(natureStr.equals("w") != true && natureStr.equals("null") != true){

//                    //查看分词结果
//                    System.out.println(term.getName() + ":" + term.getNatureStr());

                    words.add(term.getName());
                }
            }
        }
        return words;
    }

    public List<Term> getWordsFromStock(StockInfo stockInfo){
        String str = stockInfo.answer;
        Result result = ToAnalysis.parse(str);
        return result.getTerms();
    }
}

/*
实现接口 ChineseSegmenter，
要求对data .txt 中的每条数据的 answer 字段使用ansj库进行分词，
得到每条数据answer字段分词后的词汇数组
 */