package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class 다트게임 {

    public static void main(String[] args) {

        /*

        다트게임은 3번의 기회
        기회마다 얻을 수 있는 점수는 0~10점

        점수와 함께
        Single(S) = 1제곱
        Double(D) = 2제곱
        Triple(T) = 3제곱
        점수마다 한번씩만 존재

        옵션
        스타상(*) = 해당점수 * 2 && 바로전 점수 * 2
        아차상(#) = 해당점수 -
        점수마다 둘 중 하나만 존재 or 미존재

        스타상은 첫번째 기회에도 가능 (첫번째 점수만 2배)
        스타상은 중첩가능 = 중첩 스타상 (4배)
        스타상은 아차상과도 중첩가능 (-2배)

        정수 : 0~10
        문자 : S, D, T, *, #

        */


        int answer = 0;
        int scCount = 1;
        int score[] = new int[3];
        int numSave = 0;
        String dartResult = "1D2S3T*";


        String[] splitNum = dartResult.split("\\D+");
        String[] splitString = dartResult.split("[^A-Z]");

        List<String> numList = Arrays.asList(splitNum);
        List<String> stringList = new ArrayList<>();
        List<String> scList = new ArrayList<>();

        for(int i=0; i<splitString.length; i++){
            if(!splitString[i].equals("")){
                stringList.add(splitString[i]);
            }
        }

        for(int i=0; i<dartResult.length(); i++){
            ++scCount;
            if(scCount%3 == 0){
                if(dartResult.substring(i, i + 1).equals("*") || dartResult.substring(i, i + 1).equals("#")){
                    scList.add(dartResult.substring(i, i + 1));
                }else{
                    scList.add("");
                }
                scCount = 0;
            }
        }

        for(int i=scList.size(); i<numList.size(); i++){
            scList.add("");
        }

        System.out.println(numList);
        System.out.println(stringList);
        System.out.println(scList);


        for(int num =0; num<numList.size(); num++){

            int snum = Integer.parseInt(numList.get(num));

            switch (stringList.get(num)) {
                case "S":
                    numSave = snum;
                    break;
                case "D":
                    numSave = snum * snum;
                    break;
                case "T":
                    numSave = snum * snum * snum;
                    break;
            }
            if(!scList.get(num).equals("")){

                    switch (scList.get(num)){

                        case "*":
                            if(num == 0){
                                score[num] = numSave * 2;
                            }else{
                                int beforeScore = num - 1;
                                score[num] = numSave * 2;
                                score[beforeScore] = score[beforeScore] * 2;
                            }
                            break;

                        case "#":
                            score[num] = numSave * (-1);
                            break;
                    }
            }else{
                score[num] = numSave;
            }
        }

        for(int i=0; i<score.length; i++){
            answer += score[i];
        }

        System.out.println("답 : " + answer);




/*        for (int i = 0; i < dartResult.length(); i++) {

            scoreCount++;

            String ifNum = dartResult.substring(i, i + 1).replaceAll("[^0-9]", "");
            String ifString = dartResult.substring(i, i + 1).replaceAll("[^A-Z]", "");
            String ifSc = dartResult.substring(i, i + 1).replaceAll("[^*#]", "");


            if (scoreCount % 2 == 0) {
                if(ifSc.equals("")) {
                    scoreCount = 0;
                    score[count] = numSave;
                }
            }


                if(ifNum.length() != 0){
                    scoreCount = 0;
                    ++count;
                    numSave = Integer.parseInt(ifNum);
                    continue;
                }


                else if (ifString.length() != 0) {

                    switch (ifString) {
                        case "S":
                            break;
                        case "D":
                            numSave = numSave * numSave;
                            break;
                        case "T":
                            numSave = numSave * numSave * numSave;
                            break;
                    }
                }

                        else if (ifSc.equals("*")) {

                            score[count] = numSave * 2;

                            if (i == 2) {
                                continue;
                            } else {
                                int beforeScore = count - 1;
                                score[beforeScore] = score[beforeScore] * 2;

                            }
                            continue;
                        }

                        else if(ifSc.equals("#")){
                            score[count] = numSave * (-1);
                            continue;
                        }


                if(dartResult.length() == i+1){
                    score[count] = numSave;
                }
        }

        for(int i=0; i<score.length; i++){
            answer += score[i];
        }*/

            //System.out.println("답 : " + answer);
    }
}
