package util;

import vo.StockInfo;
import vo.UserInterest;

import java.io.*;
import java.util.ArrayList;

public class FileHandlerImpl implements FileHandler {

    @Override
    public StockInfo[] getStockInfoFromFile(String filePath) {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempLine = "";
            String[] arrays = null;
            int line = 0;

            ArrayList<StockInfo> stockInfos = new ArrayList<>();

            while ((tempLine = bufferedReader.readLine()) != null) {
                line++;
                if (line == 1) continue;

                StockInfo tempInfo = new StockInfo();

                arrays = tempLine.split("\t");

                tempInfo.id = Integer.parseInt(arrays[0]);
                tempInfo.title = arrays[1];
                tempInfo.author = arrays[2];
                tempInfo.date = arrays[3];
                tempInfo.lastupdate = arrays[4];
                tempInfo.content = arrays[5];
                tempInfo.answerauthor = arrays[6];
                tempInfo.answer = arrays[7];

                stockInfos.add(tempInfo);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

//            //test
//            for (int i = 0;i<10;i++){
//                System.out.println(stockInfos.get(i).id+"\t"+stockInfos.get(i).answer);
//            }

            return stockInfos.toArray(new StockInfo[stockInfos.size()]);

        } catch (FileNotFoundException e) {
            System.out.println("The file " + filePath + " doesn't exist.");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This func gets user interesting from the given interfaces path.
     * If interfaces don't exit,or it has a illegal/malformed format, return NULL.
     * The filepath can be a relative path or a absolute path
     *
     * @param filePath
     * @return
     */
    @Override
    public UserInterest[] getUserInterestFromFile(String filePath) {
        return new UserInterest[0];
    }

    /**
     * This function need write matrix to files
     *
     * @param matrix the matrix you calculate
     */
    @Override
    public void setCloseMatrix2File(double[][] matrix) {
        //TODO: write your code here
    }

    /**
     * This function need write recommend to files
     *
     * @param recommend the recommend you calculate
     */
    @Override
    public void setRecommend2File(double[][] recommend) {
        //TODO: write your code here
    }
}
