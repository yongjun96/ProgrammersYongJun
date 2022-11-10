package Level2;

import com.sun.xml.internal.ws.util.StringUtils;

public class kakaoTest {

    public static void main(String[] args) {

        /*
        새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때
        입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발

        아이디의 길이는 3자 이상 15자 이하여야 합니다.
        아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다
        단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

        입력 ID : new_id

        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        */

        //String new_id = "...!@BaT#*..y.abcdefghijklm";
        String new_id = "=.=";
        String answer = "";

        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        new_id = new_id.replaceAll("[^0-9a-z-._]", "");

        //3단계
        new_id = new_id.replaceAll("\\.+", ".");

        //4단계
        if(new_id.length() >= 1) {
            if (new_id.startsWith(".")) {
                new_id = new_id.substring(1);
            }

            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        //5단계
        if(new_id.equals("")){
            new_id = "a";
        }

        //6단계
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);

            if(new_id.endsWith(".")){
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        //7단계
        if(new_id.length() <= 2){

            int werSize = new_id.length();

            for(int i = werSize; i<3; i++ ){
                new_id += new_id.substring(new_id.length()-1);
            }
        }
        answer = new_id;



        System.out.println(answer);


    }

}
