package Inf;

import java.util.*;

public class Solve4 implements SolveProblem{
    @Override
    public void Problem() {
        //P4_1();
        //P4_2();
        //P4_3();
        //P4_4();
        P4_5();

    }

    public void P4_1(){
        /**
         * 1. 학급 회장(해쉬)
         * 설명
         *
         * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
         *
         * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
         *
         * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
         *
         * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
         *
         *
         * 입력
         * 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
         *
         * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
         *
         *
         * 출력
         * 학급 회장으로 선택된 기호를 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 15
         * BACBACCACCBDEDE
         * 예시 출력 1
         *
         * C
         */

        int n =15;
        String str = "BACBACCACCBDEDE";
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char a : str.toCharArray()){
            hashMap.put(a,hashMap.getOrDefault(a,0)+1);
        }
        int max = 0;
        char top = 0;
        for(char a : hashMap.keySet()){
            //max = Math.max(max,hashMap.get(a));
            if(max < hashMap.get(a)){
                max = hashMap.get(a);
                top = a;
            }

        }
        System.out.println(top);

    }

    public void P4_2(){

        /**
         * 2. 아나그램(해쉬)
         * 설명
         *
         * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
         *
         * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
         *
         * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
         *
         * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
         *
         *
         * 입력
         * 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
         *
         * 단어의 길이는 100을 넘지 않습니다.
         *
         *
         * 출력
         * 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * AbaAeCe
         * baeeACA
         * 예시 출력 1
         *
         * YES
         * 예시 입력 2
         *
         * abaCC
         * Caaab
         * 예시 출력 2
         *
         * NO
         */

        String str1 = "abaCC";
        String str2 = "Caaab";
        boolean ok = true;

        HashMap<Character,Integer> hashMap = new HashMap<>();
        HashMap<Character,Integer> hashMap2 = new HashMap<>();
        for(char s1 : str1.toCharArray()){
            hashMap.put(s1,hashMap.getOrDefault(s1,0)+1);
        }
        for(char s1 : str2.toCharArray()){
            hashMap2.put(s1,hashMap2.getOrDefault(s1,0)+1);
        }

        for(char key : hashMap.keySet()){
            if(hashMap.get(key) !=hashMap2.get(key)){
                ok=false;
                break;
            }
        }
        System.out.println(ok);


    }

    public void P4_3(){
        /**
         * 3. 매출액의 종류
         * 설명
         *
         * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
         *
         * 각 구간별로 구하라고 했습니다.
         *
         * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
         *
         * 20 12 20 10 23 17 10
         *
         * 각 연속 4일간의 구간의 매출종류는
         *
         * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
         *
         * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
         *
         * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
         *
         * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
         *
         * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
         *
         * 매출액의 종류를 출력하는 프로그램을 작성하세요.
         *
         *
         * 입력
         * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
         *
         * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
         *
         *
         * 출력
         * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 7 4
         * 20 12 20 10 23 17 10
         * 예시 출력 1
         *
         * 3 4 4 3
         */

        int n = 7;
        int k = 4;
        int [] arr = { 20 ,12, 20, 10 ,23 ,17 ,10};
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0 ; i<=n-k ;i++){
            for( int j =i ; j< k+i ;j++){
                hashMap.put(arr[j],hashMap.getOrDefault(arr[j],0)+1);
            }
            System.out.print(hashMap.size()+" ");
            hashMap.clear();
        }
    }

    public void P4_4(){
        /**
         * 4. 모든 아나그램 찾기
         * 설명
         *
         * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
         *
         * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
         *
         *
         * 입력
         * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
         *
         * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
         *
         *
         * 출력
         * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * bacaAacba
         * abc
         * 예시 출력 1
         *
         * 3
         * 힌트
         *
         * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
         *
         */

        String str = "bacaAacba";
        String str2 = "abc";
        int cnt =0;

        HashMap<Character,Integer> str2Map = new HashMap<>();
        HashMap<Character,Integer> str1Map = new HashMap<>();
        for( char a : str2.toCharArray()){
            str2Map.put(a,str2Map.getOrDefault(a,0)+1);
        }
        for(int i =0 ; i<= str.length()-str2.length(); i++){
            for(int j = i ; j < str2.length()+i; j++){
                str1Map.put(str.charAt(j),str1Map.getOrDefault(str.charAt(j),0)+1);
            }
            for(int j = i ; j < str2.length()+i; j++){
                if(str1Map.get(str.charAt(j)) != str2Map.get(str.charAt(j))){
                    cnt++;
                    break;
                }

            }
     //       System.out.println(cnt);
            str1Map.clear();
        }
        System.out.println(str.length()-str2.length()+1-cnt);


    }

    public void P4_5(){
        /**
         * 5. K번째 큰 수
         * 설명
         *
         * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
         *
         * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
         *
         * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
         *
         * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
         *
         *
         * 입력
         * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
         *
         *
         * 출력
         * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 10 3
         * 13 15 34 23 45 65 33 11 26 42
         * 예시 출력 1
         *
         * 143
         *
         */
        
        /**
         * 무작위 3장 뽑아서 가장 높은 경우의 수 중 k값
         */

        int n = 10;
        int k = 3;
        Integer arr[] = {13, 15, 34, 23, 45, 65 ,33, 11, 26 ,42};
        int sum =0;
        Arrays.sort(arr, Collections.reverseOrder());//역순 정렬 (java.util.collections 패키지)



        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i =0 ;i <= n-k ;i++){
            for( int j=i ; j<k+i ; j++){
                sum += arr[j];
            }
            hashMap.put(i,sum);
            sum=0;
        }

        System.out.println(hashMap.get(k-1)); //3장 합한 수들 중 k번째로 큰수
        System.out.println(arr[k-1]); //k번째로 큰 수



    }
}
