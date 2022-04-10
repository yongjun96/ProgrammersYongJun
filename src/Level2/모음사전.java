package Level2;

public class 모음사전 {


    //사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록
    //첫 번째 단어는 "A"이고, 그다음은 "AA" 마지막 단어는 "UUUUU"

    //word의 길이는 1 이상 5 이하입니다.
    //word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.

    //첫 번째 단어는 "A"이고, 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다. "AAAAE"는 사전에서 6번째 단어
    //"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어


    //   word   result
    // "AAAAE"	  6
    // "AAAE"	  10
    //   "I"	 1563
    //  "EIO"    1189


    public static void main(String[] args) {

        String word = "AAAA";

        solution(word);
    }

    public static long solution(String word) {

        int answer = 0;
        int loop = 0;

        String[] words = {"A", "E", "I", "O", "U"};

        for(int i=word.length(); i<words.length; i++){
            word += " ";
        }

            word = word.replace(" ", "0");
            word = word.replace("A", "1");
            word = word.replace("E", "2");
            word = word.replace("I", "3");
            word = word.replace("O", "4");
            word = word.replace("U", "5");

            /*
            loop는 뒤에서 부터 1 -> 6 -> 31 -> 156 -> 781...
            반복되는 A~U 이후에 자릿수가 한칸 내려가는 만큼 +1을 해줘야 함
            자릿수를 5칸을 채우기 위해 "0"을 주었으므로 0은 계산에서 제외
            그 만큼 순번이 한칸 밀려서 순번을 가져올 때는 -1을 먼저 해준 후, loop 곱셈
            후에 자릿수 +1
            */

           //마지막 순번부터 반복시작
           for(int i=word.length(); i>=1; i--) {

               //현재 순번의 값을 저장
               int wordNumber = Integer.parseInt(word.substring(i - 1, i));
               //한 자리에 A~U까지 반복을 하고 다음번 알파벳으로 변할 때, +1
               loop = loop * word.length() + 1;

                   //자릿수를 5개로 맞추기 위헤 넣은 0은 계산에서 제외
                   if(wordNumber != 0) {
                       //순번이 한칸 밀렸으므로 -1을 해줌

                       /*
                       원래는 이렇게 계산
                       A = 0
                       E = 1
                       I = 2
                       O = 3
                       U = 4
                       */

                       answer = answer + loop * (wordNumber - 1) +1;
                       System.out.println("현재 값 : " + answer);
                   }

           }

            System.out.println("word 변환 후 길이 : "+word.length());
            System.out.println("word : "+word);
            System.out.println("answer : "+answer);

        return answer;
    }
}
