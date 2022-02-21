package Inf;

public class MainC {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); //시작하는 시점 계산

        SolveProblem solve = new Solve();//2단원
        solve = new Solve3();//3단원
        solve = new Solve4();//4단원
        solve = new Solve5();//5단원
        solve = new Solve6();//6단원
        solve = new Solve7();//7단원
        solve.Problem();

        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //실행 시간 계산 및 출력



    }
}
