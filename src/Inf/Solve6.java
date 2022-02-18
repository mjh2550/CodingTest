package Inf;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

public class Solve6 implements SolveProblem{

    @Override
    public void Problem() {
       //P6_1();//선택정렬
       //P6_2();//버블정렬
       //P6_3();//삽입정렬
       //P6_4();
        P6_5();

    }

    /**
     *   int n = in.nextInt();
     *     int arr[] = new int [n];
     *     for( int i =0 ; i<n ;i++){
     *       arr[i] = in.nextInt();
     *     }
     */

    public void P6_1(){
        /**
         * 1. 선택 정렬
         * 설명
         *
         * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
         *
         * 정렬하는 방법은 선택정렬입니다.
         *
         *
         * 입력
         * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
         *
         * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
         *
         *
         * 출력
         * 오름차순으로 정렬된 수열을 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 6
         * 13 5 11 7 23 15
         * 예시 출력 1
         *
         * 5 7 11 13 15 23
         */

        /**
         * 선택 정렬(選擇整列, selection sort)은 제자리 정렬 알고리즘의 하나로, 다음과 같은 순서로 이루어진다.
         *
         * 주어진 리스트 중에 최소값을 찾는다.
         * 그 값을 맨 앞에 위치한 값과 교체한다(패스(pass)).
         * 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.
         * 비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 리스트를 이와 같은 방법으로 정렬하는 데에는 Θ(n2) 만큼의 시간이 걸린다.
         *
         * 선택 정렬은 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우에 사용시 성능 상의 이점이 있다.
         */

        int n = 6;
        int []arr ={13 ,5 ,11 ,7 ,23, 15};
        int indexMin, tmp;

        for(int i = 0 ; i<n ;i++){ //오름차순이면 작은게 왼쪽, 최솟값을 찾는다
            indexMin=i; //첫 숫자 최솟값 가정
            for(int j=i+1; j<n ; j++){ //반복문 돌려서 첫 숫자보다 작은값 찾아서 인덱스 기록
                if(arr[j]<arr[indexMin]){
                    indexMin=j;
                }
            }
            //최솟값 인덱스랑 교체
            tmp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = tmp;

        }

        for(int a : arr){
            System.out.print(a+" ");
        }
    }

    public void P6_2(){

        /**
         * 2. 버블 정렬
         * 설명
         *
         * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
         *
         * 정렬하는 방법은 버블정렬입니다.
         *
         *
         * 입력
         * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
         *
         * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
         *
         *
         * 출력
         * 오름차순으로 정렬된 수열을 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 6
         * 13 5 11 7 23 15
         * 예시 출력 1
         *
         * 5 7 11 13 15 23
         */

        /**거품 정렬 또는 버블 정렬( - 整列, 영어: bubble sort, sinking sort)은 두 인접한 원소를 검사하여 정렬하는 방법이다.
         * 시간 복잡도가 O(n^2)로 상당히 느리지만,
         *  코드가 단순하기 때 문에 자주 사용된다. 원소의 이동이 거품이 수면으로 올라오는 듯한 모습을 보이기 때문에 지어진 이름이다.
         *  양방향으로 번갈아 수행하면 칵테일 정렬이 된다.
         */
        int n = 6;
        int arr[] = {13, 5, 11 ,7, 23, 15};

        for(int i = 0 ; i<n ;i++){
            for(int j =1;j<n;j++){
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        for(int a : arr){
            System.out.print(a+" ");
        }
    }

    public void P6_3(){

        /**
         * 입력
         * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
         *
         * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
         *
         *
         * 출력
         * 오름차순으로 정렬된 수열을 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 6
         * 11 7 5 6 10 9
         * 예시 출력 1
         *
         * 5 6 7 9 10 11
         */


        /**
         * 삽입 정렬(揷入整列, insertion sort)은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여
         * , 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다
         */

        int n = 6;
        int arr[] = {13, 5, 11 ,7, 23, 15};

        for(int i = 1 ; i< n ;i++){
            int tmp = arr[i];
            int j = i-1;
            while( j >= 0 && arr[j] > tmp ){ //정렬된 앞 부분의 끝부터 차례로 검사, 오른쪽게 크면 바로 false
                arr[j+1] =arr[j];//현재보다 왼쪽값이 더 크면 자리 바꿈
                j--;
            }
            //arr[j] < tmp 이므로 j+1 에 삽입
            arr[j+1] = tmp;
        }

        for( int a : arr){
            System.out.print(a + " ");
        }

    }

    public void P6_4(){

        /**
         * 4. Least Recently Used
         * 설명
         *
         * 캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
         *
         * 필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
         *
         * 철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
         *
         * LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
         *
         * 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
         *
         * Image1.jpg
         *
         * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
         *
         * 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
         *
         *
         * 입력
         * 첫 번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다.
         *
         * 두 번째 줄에 N개의 작업번호가 처리순으로 주어진다. 작업번호는 1 ~100 이다.
         *
         *
         * 출력
         * 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 5 9
         * 1 2 3 2 6 2 3 5 7
         * 예시 출력 1
         *
         * 7 5 3 2 6
         */

        /**
         *  캐시 미스 : 캐시에 주어진 작업이 없을 때
         *  캐시 히트 : 캐시에 주어진 작업이 있을 때
         *
         *  1. 캐시 메모리 순회
         *  2. 숫자 찾으면 캐시 히트
         *  3. 캐시 히트 시 찾은 인덱스 부터 c[i]=c[i-1] 형식으로 복사
         *  4. 캐시 미스 시 맨 끝부터 c[i]=c[i-1] 형식으로 복사
         *  5. 현재 작업은 c[0]
         */

        int S = 5;
        int N = 9;
        int works[] = {1, 2 ,3, 2, 6, 2, 3, 5 ,7};
        int cache[] = new int [S];

        for (int i=0; i<N ;i++){
            int pos = -1;
            for( int j=0 ;j<S ; j++){
                //캐시 히트, 미스 여부 탐색
                if(cache[j]==works[i]){//히트
                    pos=1;
                    System.out.println("히트" + cache[j]);
                    for(int k =j ; k>=1 ;k--){
                        cache[k] = cache[k-1];
                    }
                    cache[0] = works[i];
                 break;
                }
            }
            if(pos==-1) {
                //캐시 미스
                for (int k = S - 1; k > 0; k--) {
                    cache[k] = cache[k - 1];
                }
                cache[0] = works[i];
                System.out.println("미스" + cache[0]);
            }
        }

        System.out.println(cache);



    }

    public void P6_5(){
        /**
         * 5. 중복 확인
         * 설명
         *
         * 현수네 반에는 N명의 학생들이 있습니다.
         *
         * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
         *
         * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
         *
         * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
         *
         *
         * 입력
         * 첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
         *
         * 두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
         *
         *
         * 출력
         * 첫 번째 줄에 D 또는 U를 출력한다.
         *
         *
         * 예시 입력 1
         *
         * 8
         * 20 25 52 30 39 33 43 33
         * 예시 출력 1
         *
         * D
         */

        int N = 8;
        int arr[] ={20 ,25 ,52 ,30 ,39 ,33 ,43 ,33};

        String answer = "U";

       /* for(int i =0 ;i<N ;i++){
            for(int j=i+1;j<N ;j++){
                if(arr[i]==arr[j]){
                    answer="D";
                    break;
                }
            }
        }*/
        Stack<Integer> stk = new Stack<>();
        for(int a :arr){
            if(!stk.isEmpty() && stk.contains(a)){
                answer="D";
                break;
            }else{
                stk.push(a);
            }
        }

        System.out.println(answer);


    }

    public void P6_6(){

    }

    public void P6_7(){

    }

    public void P6_8(){

    }

    public void P6_9(){

    }

    public void P6_10(){

    }

}
