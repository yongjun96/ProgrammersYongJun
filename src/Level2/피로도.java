package Level2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class 피로도 {

    public static void main(String[] args) {

        int k = 80;

        int[][] dungeons = {{80,20}, {50,40}, {30,10}};

        /*

        던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"
        던전 탐험을 마쳤을 때 소모되는 "소모 피로도"

        최소피로도 : 80
        소모피로도 : 20

        하루에 한 번씩 탐험할 수 있는 던전이 여러개
        한 유저가 오늘 이 던전들을 최대한 많이 탐험하려함!

        현재 피로도 k와 각 던전별 "최소피로도", "소모피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때
        유저가 탐험할수 있는 최대 던전 수를 return

        제한사항
        k는 1 이상 5,000 이하인 자연수입니다.
        dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
        dungeons의 가로(열) 길이는 2 입니다.
        dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
        "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
        "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
        서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

        */


        solution(k, dungeons);
    }

    public static int solution(int k, int[][] dungeons) {

        int answer = 0;

        //내림차 정렬
        Arrays.sort(dungeons, Comparator.comparingInt((int[] o1) -> o1[0]).reversed());

        for(int i=0; i<dungeons.length; i++){

            if(k >= dungeons[i][0]){
                k = k-dungeons[i][1];
                answer++;
            }

            System.out.println("확인 : "+dungeons[i][0]+" / "+dungeons[i][1]);

        }

        System.out.println("확인 : "+answer);

        return answer;
    }

}
