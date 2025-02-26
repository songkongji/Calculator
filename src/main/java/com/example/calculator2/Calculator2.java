package com.example.calculator2;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator2 {
    private static ArrayList<Double> list = new ArrayList<>(); // 결과값 저장용 컬렉션필드
    static Scanner sc = new Scanner(System.in);
    static int[] twoNums = new int[2];  //양의 정수 2개 받는 배열

    public static void sum(int a, int b) {
        list.add((double)a + b);
        System.out.println(a + b);
    }

    public static void minus(int a, int b) {
        list.add((double)a - b);
        System.out.println(a - b);
    }

    public static void division(int a, int b) {if (b == 0) {
            System.out.println("나누기에서 분모가 0이 될 수 없음");
            return;
        }
        list.add ((double)a / b);
        System.out.println(a / (double)b);
    }

    public static void times(int a, int b) {
        list.add((double)a * b);
        System.out.println(a * b);
    }

    private static void nums(int a, int b) {    //양의 정수임과 숫자 2개인지 판별하는 메소드
        String str = sc.nextLine();
        if (a < 0 || b < 0 || str != null) {
            System.out.println("양의 정수가 아니거나 숫자를 3개 이상 입력하셨습니다.");
            inputNums();
        }
    }

    public static void inputNums() {
        System.out.println("양의 정수 2개를 입력해주세요");
        for (int i = 0; i < twoNums.length; i++) {
            twoNums[i] = sc.nextInt();
        }
        nums(twoNums[0], twoNums[1]);
        calculate();
    }

    private static void calculate(){
        System.out.println("기호를 입력 (+, -, /, *)");
        char ch = sc.next().charAt(0);

        switch (ch){
            case '+' :
                Calculator2.sum(twoNums[0], twoNums[1]);
                break;

            case '-' :
                Calculator2.minus(twoNums[0], twoNums[1]);
                break;

            case '/' :
                Calculator2.division(twoNums[0], twoNums[1]);
                break;

            case '*' :
                Calculator2.times(twoNums[0], twoNums[1]);
                break;

            default:
                System.out.println("잘못된 기호를 입력했습니다.");
                break;
        }

        System.out.println("정보를 수정하려면 아무키나 입력 (원하지 않을시 n 입력)");
        if(!sc.next().equals("n"))
            setList();

        System.out.println(getList());

        System.out.println("계속 하시려면 아무키나 입력 (종료를 원할 시 exit 입력)");
                if(!sc.next().equals("exit"))
                    inputNums();
    }

    private static ArrayList<Double> getList(){ // 연산 결과 출력 메서드
        System.out.print("연산했던 결과들 : ");
        return list;
    }

    private static void setList(){ //연산 결과 수정 메서드
        System.out.print("수정하실 숫자의 위치를 입력 (첫번째부터 1, 2...) : ");
        int inputNum = sc.nextInt();
        while(true) {
            if (inputNum > list.size()) {
                System.out.println("위치가 잘못됐습니다. 다시 입력하세요");
                inputNum = sc.nextInt();
            } else
                break;
        }
        System.out.print("변경되는 숫자를 입력 : ");
        int inputNum2 = sc.nextInt();
        list.set(inputNum - 1, (double) inputNum2);
    }

    public static ArrayList<Double> delete(){  //연산 결과 첫번째값 삭제 메소드
        System.out.print("첫번째 데이터 삭제 후 결과 : ");
        list.remove(0);
        return list;
    }
}

