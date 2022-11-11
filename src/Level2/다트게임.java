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
        int score[] = new int[3];
        int numSave = 0;
        String dartResult = "1D#2S*3S";


        String[] splitNum = dartResult.split("\\D+");
        String[] splitString = dartResult.split("[^A-Z]");
        String[] splitCs = dartResult.split("[^*#A-Z]");

        List<String> numList = Arrays.asList(splitNum);
        List<String> stringList = new ArrayList<>();
        List<String> scList = new ArrayList<>();


        for(int i=0; i<splitCs.length; i++){

            if(!splitCs[i].equals("")) {

                if (splitCs[i].contains("*")) {
                    scList.add("*");
                }
                else if(splitCs[i].contains("#")){
                    scList.add("#");
                }
                else {
                    scList.add("");
                }
            }
        }


        for(int i=0; i<splitString.length; i++){
            if(!splitString[i].equals("")){
                stringList.add(splitString[i]);
            }
        }

        //System.out.println(numList);
        //System.out.println(stringList);
        //System.out.println(scList);


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
    }
}
