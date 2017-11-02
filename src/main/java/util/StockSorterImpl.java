package util;

import javafx.util.Pair;
import vo.StockInfo;

public class StockSorterImpl implements StockSorter {
    public StockInfo[] sort(StockInfo[] info) {
        return quickSort(info, 0, info.length - 1);
    }

    //降序排列
    public Pair<String, Double>[] sort(Pair<String, Double>[] pairs) {
        pairs = quickSort(pairs, 0, pairs.length - 1);

        int n = pairs.length;
        for(int i = 0; i<n/2;i++){
            Pair<String, Double> tempPair = pairs[i];
            pairs[i] = pairs[n - i -1];
            pairs[n - i - 1] = tempPair;
        }

        return pairs;
    }

    public StockInfo[] sort(StockInfo[] info, boolean order) {
        StockInfo[] stockInfos = quickSort(info, 0, info.length - 1);

        //升序
        if (order) {
            return stockInfos;
        }

        //转换为降序
        int n = stockInfos.length;
        for (int i = 0; i < n / 2; i++) {
            StockInfo tempStock = stockInfos[i];
            stockInfos[i] = stockInfos[n - i - 1];
            stockInfos[n - i - 1] = tempStock;

            tempStock = null;
        }
        return stockInfos;

    }

    //快速排序算法：升序排列时，start=0，end=length-1
    public StockInfo[] quickSort(StockInfo[] infos, int start, int end) {
        if (start >= end) {
            return infos;
        }

        int i = start;
        int j = end;
        int value = infos[i].answer.length();
        boolean flag = true;

        while (i != j) {
            if (flag) {
                if (value > infos[j].answer.length()) {
                    StockInfo tempStock = infos[i];
                    infos[i] = infos[j];
                    infos[j] = tempStock;

                    tempStock = null;

                    flag = false;

                } else {
                    j--;
                }
            } else {
                if (value < infos[i].answer.length()) {
                    StockInfo tempStock = infos[i];
                    infos[i] = infos[j];
                    infos[j] = tempStock;

                    tempStock = null;

                    flag = true;
                } else {
                    i++;
                }
            }
        }

        quickSort(infos, start, j - 1);
        quickSort(infos, i + 1, end);

        return infos;
    }

    public Pair<String, Double>[] quickSort(Pair<String, Double>[] pairs, int start, int end) {
        if (start >= end) {
            return pairs;
        }

        int i = start;
        int j = end;
        double value = pairs[i].getValue();
        boolean flag = true;

        while (i != j) {
            if (flag) {
                if (value > pairs[j].getValue()) {
//                    StockInfo tempStock = infos[i];
//                    infos[i] = infos[j];
//                    infos[j] = tempStock;
//
//                    tempStock = null;

                    Pair<String, Double> tempPair = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = tempPair;

                    flag = false;

                } else {
                    j--;
                }
            } else {
                if (value < pairs[i].getValue()) {
//                    StockInfo tempStock = infos[i];
//                    infos[i] = infos[j];
//                    infos[j] = tempStock;
//
//                    tempStock = null;

                    Pair<String, Double> tempPair = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = tempPair;

                    flag = true;
                } else {
                    i++;
                }
            }
        }

        quickSort(pairs, start, j - 1);
        quickSort(pairs, i + 1, end);

        return pairs;
    }
}
