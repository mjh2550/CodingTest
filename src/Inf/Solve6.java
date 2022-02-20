package Inf;

import java.util.*;

public class Solve6 implements SolveProblem{

    @Override
    public void Problem() {
       //P6_1();//선택정렬
       //P6_2();//버블정렬
       //P6_3();//삽입정렬
       //P6_4();
       // P6_5();
         //P6_6();
         //P6_7();
         //P6_8();
         P6_9();
        // P6_10();

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
                //    System.out.println("히트" + cache[j]);
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
           //     System.out.println("미스" + cache[0]);
            }
        }

        System.out.println(Arrays.toString(cache));



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
        /**
         * 6. 장난꾸러기
         * 설명
         *
         * 새 학기가 시작되었습니다. 철수는 새 짝꿍을 만나 너무 신이 났습니다.
         *
         * 철수네 반에는 N명의 학생들이 있습니다.
         *
         * 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
         *
         * 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
         *
         * 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
         *
         * 선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
         *
         * 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
         *
         * 차례로 출력하는 프로그램을 작성하세요.
         *
         *
         * 입력
         * 첫 번째 줄에 자연수 N(5<=N<=100)이 주어진다.
         *
         * 두 번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다.
         *
         * 키(높이) 값 H는 (120<=H<=180)의 자연수 입니다.
         *
         *
         * 출력
         * 첫 번째 줄에 철수의 반 번호와 짝꿍의 반 번호를 차례로 출력합니다.
         *
         *
         * 예시 입력 1
         *
         * 9
         * 120 125 152 130 135 135 143 127 160
         * 예시 출력 1
         *
         * 3 8
         * 힌트
         *
         * 출력해설 : 키 정보 152가 철수이고, 127이 철수 짝꿍입니다.
         */
        Scanner in = new Scanner(System.in);
        String answer ="";
        int cnt = 0 ;
        int N = in.nextInt();
        int arr[] = new int [N];
        for( int i =0 ; i<N ;i++){
            arr[i] = in.nextInt();
        }
      /*  for(int i = 0 ; i<N ; i++){
            for(int j= 1+i ; j<N ; j++){
                if(arr[i]<arr[j]){//뒷자리가 큼 : 정상

                }else if(arr[i]==arr[j]){//같음 : 보류
                    continue;
                }else if(arr[i]>arr[j]){//뒷자리가 작음 : 비정상
                    System.out.print(i+1);
                    System.out.print(" ");
                    cnt++;
                }
                break;
            }
            if(cnt==1)break;
        }
        cnt =0;
        for(int i = N-1 ; i>=0 ; i--){
            for(int j= i-1 ; j>=0 ; j--){
                if(arr[i]>arr[j]){//앞자리가 같거나 큼 : 정상

                }else if(arr[i]==arr[j]){//같음 : 보류
                    continue;
                }else if(arr[i]<arr[j]){//뒷자리가 작음 : 비정상
                    System.out.println(i+1);
                    cnt++;
                }
                break;
            }
            if(cnt==1)break;
        }*/

        int tmp[] = arr.clone();
        Arrays.sort(tmp);

        for(int i = 0 ; i<N;i++){
            if(arr[i]!=tmp[i])answer+=i+1+" ";
        }
        System.out.println(answer);

    }

    public void P6_7(){
        /**
         * 7. 좌표 정렬
         * 설명
         *
         * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
         *
         * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
         *
         *
         * 입력
         * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
         *
         * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
         *
         *
         * 출력
         * N개의 좌표를 정렬하여 출력하세요.
         *
         *
         * 예시 입력 1
         *
         * 5
         * 2 7
         * 1 3
         * 1 2
         * 2 5
         * 3 6
         * 예시 출력 1
         *
         * 1 2
         * 1 3
         * 2 5
         * 2 7
         * 3 6
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Pt> ptArrayList = new ArrayList<>();
        for(int i = 0 ; i<n ;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            ptArrayList.add(new Pt(x,y));
        }
        Collections.sort(ptArrayList);

        for(Pt p : ptArrayList){
            System.out.println(p.x + " "+ p.y);
        }

    }
    class Pt implements Comparable<Pt>{
        int x, y;
        public Pt(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pt o) {
            if(this.x==o.x) return this.y - o.y;
            else return this.x - o.x;
            //this - object 오름차순 (음수 리턴) 반대는 내림차순 정렬
        }
    }

    public void P6_8(){
        /**
         * 8. 이분검색
         * 설명
         *
         * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
         *
         * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
         *
         *
         * 입력
         * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
         *
         * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
         *
         *
         * 출력
         * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
         *
         *
         * 예시 입력 1
         *
         * 8 32
         * 23 87 65 12 57 32 99 81
         * 예시 출력 1
         *
         * 3
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int [n];
        for(int i = 0 ; i<n ;i++){
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);
        int lt=0;
        int rt=n-1;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==m){
                System.out.println(mid+1);
                break;
            }else if(arr[mid]<m){
                lt = mid+1;
            }else if(arr[mid]>m){
                rt = mid-1;
            }
        }

    }

    public void P6_9(){

        /**
         * 9. 뮤직비디오(결정알고리즘)
         * 설명
         *
         * 지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
         *
         * DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
         *
         * 순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
         *
         * 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
         *
         * 지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
         *
         * 고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
         *
         * 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
         *
         *
         * 입력
         * 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
         *
         * 다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
         *
         * 부른 곡의 길이는 10,000분을 넘지 않는다고 가정하자.
         *
         *
         * 출력
         * 첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.
         *
         *
         * 예시 입력 1
         *
         * 9 3
         * 1 2 3 4 5 6 7 8 9
         * 예시 출력 1
         *
         * 17
         * 힌트
         *
         * 설명 : 3개의 DVD용량이 17분짜리이면 (1, 2, 3, 4, 5) (6, 7), (8, 9) 이렇게 3개의 DVD로 녹음을 할 수 있다.
         *
         * 17분 용량보다 작은 용량으로는 3개의 DVD에 모든 영상을 녹화할 수 없다.
         */
        /**
         * 결정 알고리즘 : 정답의 값 범위를 예측이 가능하고, 정렬이 되어있어야 하며, 이분검색을 사용하여 최적의 숫자를 찾는 알고리즘
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        int arr[] = new int [n];

        for( int i =0 ; i<n ;i++){
            arr[i] = sc.nextInt();
        }
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt<=rt){
            int cnt =1;
            int sum =0;
            int mid = (lt+rt)/2;
            for(int i= 0 ; i<n ;i++){//가능한지
                if(sum+arr[i] > mid){//불가능, 하나 증가
                    cnt++;
                    sum=arr[i]; //카운트 바뀔 때 이거 안더해줬음
                }else if (sum+arr[i] <= mid){//가능
                    sum += arr[i];
                }
                System.out.println("cnt :"+cnt);
                System.out.println("sum : "+sum);
                System.out.println("mid : "+mid);
            }
            if(cnt<=m){
                answer =mid;
                rt = mid-1;
            }
            else if(cnt>m){
                lt = mid+1;
            }

        }
        System.out.println(answer);




    }

    public void P6_10(){

    }

}
