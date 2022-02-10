package Inf;

import java.util.ArrayList;
import java.util.Arrays;

public class Solve3 implements SolveProblem{

    public void Problem(){
        /**
         * Scanner sc=new Scanner(System.in);
         *     int N = sc.nextInt();
         *     int arr1[] = new int [N];
         *     for(int i =0; i<N  ; i++){
         *       arr1[i] = sc.nextInt();
         *     }
         *     int M = sc.nextInt();
         *     int arr2[] = new int [M];
         *     for(int i =0; i<M  ; i++){
         *       arr2[i] = sc.nextInt();
         *     }
         *
         *
         */

        //P3_1();
        P3_2();
    }

    public void P3_1(){
        /**
         * 1. 두 배열 합치기
         * 설명
         *
         * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
         *
         *
         * 입력
         * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
         *
         * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
         *
         * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
         *
         * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
         *
         * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
         *
         *
         * 출력
         * 오름차순으로 정렬된 배열을 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 3
         * 1 3 5
         * 5
         * 2 3 6 7 9
         * 예시 출력 1
         *
         * 1 2 3 3 5 6 7 9
         */
        int N = 3;
        int M = 5;
        int []arr1 = {1 ,3, 5};
        int []arr2 ={2 ,3 ,6 ,7 ,9};
        ArrayList<Integer> arrayList  = new ArrayList<>();

        /**
         * 두 배열이 같이 남아있는 동안에는 작은거 우선 저장
         */

        int p1 = 0; int p2 =0;
        while (p1<N && p2<M){
            if(arr1[p1]<arr2[p2])
             arrayList.add(arr1[p1++]);
            else
             arrayList.add(arr2[p2++]);
        }
        /**
         * 두 배열 중 남은 배열 끝까지 저장
         */
        while (p1<N)  arrayList.add(arr1[p1++]);
        while (p2<M) arrayList.add(arr2[p2++]);


        for (int c : arrayList){
            System.out.print(c+ " ");
        }

    }

    public void P3_2(){
        /**
         * 2. 공통원소 구하기
         * 설명
         *
         * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
         *
         *
         * 입력
         * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
         *
         * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
         *
         * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
         *
         * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
         *
         * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
         *
         *
         * 출력
         * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 5
         * 1 3 9 5 2
         * 5
         * 3 2 5 7 8
         * 예시 출력 1
         *
         * 2 3 5
         */

        int N =5;
        int M =5;
        int []arr1 =new int[]{1, 3, 9 ,5, 2};
        int []arr2 = new int[]{3, 2, 5 ,7 ,8};
        int p1=0;
        int p2=0;
        ArrayList<Integer> arrayList =new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
/*
        for(int c : arr1){
            for(int d : arr2){
                if(c==d){
                    arrayList.add(c);
                }
            }
        }
*/
        while (p1<N && p2 < M){
            if(arr1[p1]==arr2[p2]){
                arrayList.add(arr1[p1++]);
                 p2++;

            }else if(arr1[p1]<arr2[p2]) p1++;
            else p2++;
        }

        for(int c : arrayList){
            System.out.print(c+ " ");
        }
    }
}
