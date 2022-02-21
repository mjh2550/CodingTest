package Inf;

import java.util.LinkedList;
import java.util.Queue;

public class Solve7 implements SolveProblem{


    @Override
    public void Problem() {
    //    P7_1(); //Memoization , StackFrame
        P7_2();

    }
    public void P7_1(){
        /**
         * StackFrame
         * 함수 호출 시 지역변수,전역변수,복귀주소를 스택 메모리에 저장,
         * 모든 코드 반환 후 순차적으로 복귀주소로 복귀한다.
         */

        /**
         * 메모이제이션(Memoization)
         * 한번 구한 값은 그대로 메모리 (ex)static array)에서 호출함.
         * 같은 풀이가 반복되는 재귀함수는 메모이제이션 기법으로 시간복잡도를 줄일 수 있다.
         */

        /**
         * 재귀 vs 메모이제이션 속도 비교
         */
        //재귀를 통한 DFS구현
        //System.out.println(DFS(45));//4.4초

        //메모이제이션 : 한번 구한값은 저장 해 놓은다음 불러옴 - 동적 계획법에서 중복계산이 들어갈 때 유용
        System.out.println(fiboMemoization(45));//0.0006초
    }

    public int DFS(int n ){
        if(n==0)return 1;
        if(n==1)return 1;
        //return DFS(n-1)+n;
        //return DFS(n-1)*n;
        return DFS(n-2)+DFS(n-1); //피보나치
    }

    static long[] Farr = new long[51];	// 저장해둘 배열 선언

    static long fiboMemoization(int N) {
        if (N == 0) {
            Farr[0]=1;
            return Farr[0];
        } else if (N == 1) {
            Farr[1]=1;
            return Farr[1];
        } else if (Farr[N] != 0) {	// 한 번 이상 구한 것은 바로 저장된 값 리턴!!
            return Farr[N];
        } else {
            return Farr[N] = fiboMemoization(N - 1) + fiboMemoization(N - 2);
        }
    }

    Node root;

    public void P7_2(){
        Solve7 tree = new Solve7();
        tree.root= new Node(1);
        tree.root.lt= new Node(2);
        tree.root.rt= new Node(3);
        tree.root.lt.lt= new Node(4);
        tree.root.lt.rt= new Node(5);
        tree.root.rt.lt= new Node(6);
        tree.root.rt.rt= new Node(7);
        //DFS2(tree.root);
        BFS(tree.root);
        System.out.println();
    }

    class Node{
        int data;
        Node lt,rt; //Node Class 의 주소를 갖는 변수
        public Node(int val){ //생성자
            data=val;
            lt=rt=null;
        }
    }

    public void DFS2(Node root){
        if(root==null) return; //말단 노드
        else {
            //System.out.print(root.data + " ");//전위 순회
            DFS2(root.lt);//lt 방문
            System.out.print(root.data + " ");//중위 순회
            DFS2(root.rt);//rt 방문
            //System.out.print(root.data + " ");//후위 순회
        }
    }

    public void BFS(Node root){
        /**
         * Queue를 이용하여 너비우선 출력
         * 상위 노드 Queue에 담고, 출력
         * (최초는 null) 다음 하위노드 존재하면 Queue에 LT RT 넣음
         * 레벨 증가 SIZE 측정 후 SIZE만큼 반복
         */

        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        while (!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L+" : ");
            for (int i = 0 ; i< len ; i++){
                Node cur = Q.poll();//해당 레벨노드 전부 큐에서 꺼냄
                System.out.print(cur.data+ " "); //출력
                if(cur.lt!=null) Q.offer(cur.lt);//하위 노드에 값이 존재할 때만 전부 넣음
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            L++;//레벨 증가
            System.out.println();
        }
    }



}
