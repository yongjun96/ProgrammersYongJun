package Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testJava {

    public static void main(String[] args) {

        /*

        두 정수 x / y 임의 자리에 공통으로 나타나는 수  k = (0 <= k <= 9)를 이용해서 만들 수 있는 가장 큰 정수
        x / y 의 짝꿍이 없다면 -1
        x / y 의 짝꿍이 0이라면 0

        ex).
        x = 3403
        y = 13203
        공통 = 3, 0, 3
        답 = 330

        x = 5525
        y = 1255
        공통 = 2, 5, 5
        답 = 552

        x / y = 문자열로 반환

        */


        String answer = "";
        String x = "5525";
        String y = "1255";
        int count = 0;

        List<String> xList = new ArrayList<>();
        List<String> yList = new ArrayList<>();
        List<Integer> xyList = new ArrayList<>();

        for(int i=0; i<x.length(); i++){
            if(i+1 <= x.length()){
                xList.add(x.substring(i, i+1));
            }
        }

        for(int i=0; i<y.length(); i++){
            if(i+1 <= y.length()){
                yList.add(y.substring(i, i+1));
            }
        }

        int i=0;

        while (i<xList.size()) {
            for (int j=0; j<yList.size(); j++) {
                if(xList.get(i).equals(yList.get(j))){
                    xyList.add(Integer.parseInt(xList.get(i)));
                    xList.remove(xList.get(i));
                    yList.remove(yList.get(j));
                    i = 0;
                    break;
                }
            }
            i++;
        }

        if(xyList.size() == 0){
            answer = "-1";
        }else{

            Collections.sort(xyList, Collections.reverseOrder());

            for(int z=0; z<xyList.size(); z++){
                if(xyList.get(z) == 0){
                    count++;
                }
                answer += xyList.get(z);
            }

            if(count == xyList.size()){
                answer = "0";
            }

        }

        System.out.println("답 : "+answer);

    }
}




