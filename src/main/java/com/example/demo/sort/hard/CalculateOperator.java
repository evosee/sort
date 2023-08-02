package com.example.demo.sort.hard;

import java.util.Stack;

public class CalculateOperator {

    private final Stack<Integer> vs = new Stack<>();
    private final Stack<Character> op = new Stack<>();

    public int operator(String expression) {
        if (expression == null || expression.equals("")) {
            return 0;
        }
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                vs.push(Character.getNumericValue(c));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!op.isEmpty() && !precedence(op.peek(), c)) {
                    //要先算
                    cal();
                }
                op.push(c);
            }else if(c=='('){
                op.push(c);
            }else if(c==')'){
                while (op.peek()!='('){
                    cal();
                }
                op.pop();
            }
        }
        while (!op.isEmpty()) {
            cal();
        }
        return vs.pop();
    }

    private void cal() {
        Integer pop1 = vs.pop();
        Integer pop2 = vs.pop();
        Character pop = op.pop();
        vs.push(calculate(pop2, pop1, pop));
    }

    private boolean precedence(Character peek, Character c) {
        if (peek == null) {
            return true;
        }
        if ((c == '*' || c == '/') && (peek == '+' || peek == '-')) {
            return true;
        }
        if(peek=='('||peek==')'){
            return true;
        }
       /* if(c=='+'||c=='-'){
            return false;
        }*/

        return false;
    }

    private int calculate(int a, int b, char c) {
        switch (c) {
            case ('+'):
                return a + b;
            case ('-'):
                return a - b;
            case ('*'):
                return a * b;
            case ('/'):
                if (b == 0) {
                    throw new RuntimeException("can not devide zero");
                }
                return a / b;
            default:
                throw new RuntimeException("no operator");
        }
    }

    public static void main(String[] args) {
        String a = "5*(2+3)-(4+9)";
        System.out.println(new CalculateOperator().operator(a));
    }
}
