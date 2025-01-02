package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int iNum[] = new int[2];

            System.out.println("양의 정수를 2개 입력해주세요.");
            for (int i = 0; i < iNum.length; i++) {
                iNum[i] = sc.nextInt();
            }

            System.out.println("기호를 입력 (+, -, *, /)");
            char ch = sc.next().charAt(0);

            switch (ch) {
                case '+':
                    int answer = iNum[0] + iNum[1];
                    System.out.println(answer);
                    break;

                case '-':
                    answer = iNum[0] - iNum[1];
                    System.out.println(answer);
                    break;

                case '*':
                    answer = iNum[0] * iNum[1];
                    System.out.println(answer);
                    break;

                case '/':
                    if (iNum[1] == 0) {
                        System.out.println("나눗셈에서 분모는 0이 될 수 없음.");
                        break;
                    }
                    answer = iNum[0] / iNum[1];
                    System.out.println(answer);
                    break;

                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
            System.out.println("계속 진행시 아무키 입력 (종료를 원할시 exit 입력)");
            String exit = sc.next();
            if (exit.equals("exit"))
                break;
        }
    }
}
