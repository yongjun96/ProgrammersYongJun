package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumAndMinimum {

    public static void main(String[] args) {

        /*
        1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권

        민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
        당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.

        알아볼 수 없는 번호를 0으로 표기
        민우가 구매한 로또 번호 6개가 ( 44, 1,  0,  0, 31 25)
        당첨 번호 6개가             ( 31, 10, 45, 1, 6, 19)


        당첨 번호	    31	 10	    45	1	   6	19	결과
        최고 순위 번호	31	0→10	44	1	  0→6	25	4개 번호 일치, 3등
        최저 순위 번호	31	0→11	44	1	  0→7	25	2개 번호 일치, 5등

        순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.

        알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
        3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.

        알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
        5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.

        */


        int[] lottos = {44, 1, 0, 0, 31, 25}; // 민우의 번호
        int[] winNums = {31, 10, 45, 1, 6, 19}; // 당첨 번호
        int[] answer = new int[2];

        List<Integer> lottosList = new ArrayList<>();
        List<Integer> lottosList2 = new ArrayList<>();
        List<Integer> winNumsList = new ArrayList<>();

        for(int i=0; i<lottos.length; i++){
            lottosList.add(lottos[i]);
            lottosList2.add(lottos[i]);
        }

        for(int i=0; i<winNums.length; i++){
            winNumsList.add(winNums[i]);
        }

        int lottosSize = 0;
        int winNumsSize = winNumsList.size();


        lottosList.removeAll(winNumsList);
        winNumsList.removeAll(lottosList2);
        winNumsSize = winNumsSize - lottosList.size();
        answer[1] = winNumsSize;
        Collections.sort(lottosList, Collections.reverseOrder());
        Collections.sort(winNumsList, Collections.reverseOrder());


        System.out.println("현재 맞지 않는 수 : "+lottosList);
        System.out.println("당첨 수  : "+winNumsList);
        System.out.println("현재 맞지 않는 수 : "+lottosList.size());
        System.out.println("현재 맞춘 개수 : "+winNumsSize);

        for(int i=0; i<lottosList.size(); i++){
            if(lottosList.get(i) == 0){
                winNumsSize++;
            }
        }
        answer[0] = winNumsSize;

        System.out.println(Arrays.toString(answer));

        for(int i=0; i<answer.length; i++){

            if(answer[i] == 6){
                answer[i] = 1;
            }
            else if(answer[i] == 5){
                answer[i] = 2;
            }
            else if(answer[i] == 4){
                answer[i] = 3;
            }
            else if(answer[i] == 3){
                answer[i] = 4;
            }
            else if(answer[i] == 2){
                answer[i] = 5;
            }
            else{
                answer[i] = 6;
            }
        }

        System.out.println("확인 : "+Arrays.toString(answer));








    }

}
