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
         *        Scanner sc = new Scanner(System.in);
         *     int n = sc.nextInt();
         *     int k = sc.nextInt();
         *     int arr[] = new int [n];
         *     for(int i=0; i<n ; i++){
         *       arr[i] = sc.nextInt();
         *     }
         *
         *
         *
         */

        //P3_1();
        //P3_2();
        //P3_3();
        //P3_4();
        //P3_5();
        P3_6();
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

    public void P3_3(){
        /**
         * 3. 최대 매출
         * 설명
         *
         * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
         *
         * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
         *
         * 12 1511 20 2510 20 19 13 15
         *
         * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
         *
         * 여러분이 현수를 도와주세요.
         *
         *
         * 입력
         * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
         *
         * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
         *
         *
         * 출력
         * 첫 줄에 최대 매출액을 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 10 3
         * 12 15 11 20 25 10 20 19 13 15
         * 예시 출력 1
         *
         * 56
         */

        int arr [] = {12 ,15 ,11 ,20 ,25, 10 ,20 ,19, 13, 15};

        int n = 10;//arr크기
        int k = 3;//연속 k일간 수익 비교

        int sum =0;
        int max =0;
        /**
         * 시간초과
         */
        /*for(int i =0 ; i+k<n ;i++){
            for(int j = i ; j<i+k;j++){
                sum +=arr[j];
            }
            max = Math.max(max,sum);
            sum=0;
        }
        System.out.println(max);*/

        /**
         * Sliding window
         * 앞 연속 k부분을 더하고 그 후 1항을 빼고 다음항을 더해서 전진함
         *
         * 앞부분 창문 만들기
         */
        for(int i=0 ;i<k ;i++){
            sum+=arr[i];
        }

        max = sum;

        /**
         * 뒷부분 부터  +뒷항 - 앞항 반복하여 최대값 비교
         */

        for (int i=k ; i<n ;i++){
            sum += arr[i]-arr[i-k];
            max = Math.max(max,sum);
        }
        System.out.println(max);

    }

    public void P3_4(){
        /**
         * 4. 연속 부분수열
         * 설명
         *
         * N개의 수로 이루어진 수열이 주어집니다.
         *
         * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
         *
         * 만약 N=8, M=6이고 수열이 다음과 같다면
         *
         * 1 2 1 3 1 1 1 2
         *
         * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
         *
         *
         * 입력
         * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
         *
         * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
         *
         *
         * 출력
         * 첫째 줄에 경우의 수를 출력한다.
         *
         *
         * 예시 입력 1
         *
         * 8 6
         * 1 2 1 3 1 1 1 2
         * 예시 출력 1
         *
         * 3
         */

        int n=8;
        int m=6;
        int []arr = {1 ,2 ,1 ,3, 1, 1, 1 ,2};
        int sum=0;
        int cnt=0;
        for(int i =0 ; i<n ;i++){
            for(int j=i ; j<n ; j++){
                sum+=arr[j];
                if(sum==m){
                    cnt++;
                    break;
                }
                if(sum>m)break;
            }
            sum=0;
        }
        System.out.println(cnt);

    }

    public void P3_5(){
        /**
         *5. 연속된 자연수의 합
         * 설명
         *
         * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
         *
         * 만약 N=15이면
         *
         * 7+8=15
         *
         * 4+5+6=15
         *
         * 1+2+3+4+5=15
         *
         * 와 같이 총 3가지의 경우가 존재한다.
         *
         *
         * 입력
         * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
         *
         *
         * 출력
         * 첫 줄에 총 경우수를 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 15
         * 예시 출력 1
         *
         * 3
         */
        int m = 450;
        int cnt=0;
        int sum=0;
        for (int i=1; i<=m ;i++){
            for(int j=i ; j<m ; j++){
                //마지막 숫자는 포함 안함
                sum += j;
                if(sum==m){
                    //i=j;
                    cnt++;
                    break;
                }
                if(sum>m)break;
            }
            sum=0;
        }
        System.out.println(cnt);

    }

    public void P3_6(){
        /**
         * 6. 최대 길이 연속부분수열
         * 설명
         *
         * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
         *
         * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
         *
         * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
         *
         * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
         *
         * Image1.jpg
         *
         * 이며 그 길이는 8입니다.
         *
         *
         * 입력
         * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
         *
         * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
         *
         *
         * 출력
         * 첫 줄에 최대 길이를 출력하세요.
         *
         *
         * 예시 입력 1
         *
         * 14 2
         * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
         * 예시 출력 1
         *
         * 8
         */
        int n = 14;
        int k = 2;
        int arr[] = { 1 ,1 ,0, 0, 1, 1, 0 ,1, 1, 0, 1, 1 ,0 ,1};
        int cnt = k;
        int sum = 0;
        int max = 0;
        for(int i =0 ; i<n ;i++){
            for(int j =i; j<n ;j++){
                if(arr[j]==0){
                    if(cnt==0){
                        //System.out.println(j+"cut");
                        break;
                    }else {
                        cnt--;
                        //      System.out.println(sum + "+1");
                        sum += 1;
                        continue;
                    }
                }
                //System.out.println(sum + "+"+arr[j]);
                sum += arr[j];
            }
            max = Math.max(max,sum);
            cnt=k;
            sum =0;
        }
        System.out.println(max);
    }
}
