프로그래머스 : [https://programmers.co.kr/learn/courses/30/lessons/72410](https://programmers.co.kr/learn/courses/30/lessons/72410)

핵심 : 정규식 

정규식 참조 : [https://coding-factory.tistory.com/529](https://coding-factory.tistory.com/529)

- 나의 풀이

```java
import java.util.ArrayList;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        System.out.println("1 : "+new_id);
        new_id =new_id.replaceAll("\\*","");

        String []confirm = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                               "1","2","3","4","5","6","7","8","9","0","-","_","."};

        String [] idstr = new_id.split("");

        ArrayList<String> result = new ArrayList();
        //2
        for(int j=0; j<idstr.length; j++){
            for (int i=0;i<confirm.length;i++){
                if(idstr[j].equals(confirm[i])){
                    //문자가 허용 글자에 포함되고 첫글자가 .가 아니면 리스트 저장
                    if(j==0 && idstr[j].equals(".")){
                    //    System.out.println("첫글자 " + idstr[j]);
                        continue;
                    }else if (j>0 && idstr[j-1].equals(".") && idstr[j].equals(".")){
                    //    System.out.println("두번연속 .이면 건너뜀"+idstr[j]);
                        continue;
                    }else {
                    //    System.out.println(j + " 저장 : " + idstr[j]);
                        result.add(idstr[j]);
                        break;
                    }
                }
            }
            
            if(result.size()>14){//15까지 포함
                String lastChar = result.get(result.size()-1);
                //마지막 글자가 .이면 삭제
                if(idstr[j].equals(".")){
                    result.remove(lastChar);
                    break;
                }else {
                    break;
                }
            }
            if (j== idstr.length-1 && result.size()>0){//마지막
                String lastChar = result.get(result.size() - 1);
                    while (true) {
                        if(idstr[j].equals(".") && lastChar.equals(".")) {//.일시 제거
                            result.remove(lastChar);
                         //   System.out.println("제거 : " + lastChar);
                            if (result.size() > 0) {
                                lastChar = result.get(result.size() - 1);
                        //        System.out.println("변경 : " + lastChar);
                            } else {
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                if(result.size()<=2 && result.size()>0){
                    lastChar = result.get(result.size() - 1);
                    if(lastChar.equals(".")) {
                        while (true) {
                            result.remove(lastChar);
                        //    System.out.println("제거 : "+lastChar);
                            if(result.size()>0){
                                lastChar = result.get(result.size() - 1);
                            }else{
                                break;
                            }
                        }
                    }else{//마지막 문자가 . 아닐경우만 대입
                          for (int k=result.size();k<3;k++) {
                           //     System.out.println("추가 :"+lastChar);
                                result.add(lastChar);
                          }
                   }

                }
            }
            if(j== idstr.length-1 && result.size()==0){//마지막인데 size가 0이면
                result.add("aaa");
                break;
            }
        }

     //   System.out.println("\n result list");
        for (String id :result){
            answer += id;
        }
        
        return answer;
    }
}
```

- 정규식으로 풀이한 코드

```java
class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase(); // 소문자로 
        id = id.replaceAll("[^-_.a-z0-9]", ""); //-_. 영문자 숫자만 남김 
        id = id.replaceAll("[.]{2,}", "."); // .2개 이상 .으로 
        id = id.replaceAll("^[.]|[.]$", ""); // 처음과 끝 . 제거 

        if(id.equals("")) // 빈 문자열이라면 a 추가 
            id += "a";
            
        if(id.length() >= 16){ // 16자 이상이면 15자로 
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", ""); // 끝 . 제거 
        }
        if(id.length() <= 2) // 2자 이하라면 3자까지 마지막 문자추가 
            while(id.length() < 3)
                id += id.charAt(id.length() - 1);

        return id;
    }
}
```