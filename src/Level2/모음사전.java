package Level2;

public class 모음사전 {

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        solution(price, money, count);
    }

    public static long solution(int price, int money, int count) {

        long answer;
        long sum=0;

        for(int i=1; i<=count; i++){
            System.out.println("현재 탄 횟수 : "+i);
            sum += price * i;
            System.out.println("sum : "+sum);
        }

        if(sum < money){
            answer = 0;
        }else{
            answer = sum - money;
        }

        System.out.println("정답 출력 : "+answer);
        return answer;
    }
}
