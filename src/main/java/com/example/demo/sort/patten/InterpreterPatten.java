package com.example.demo.sort.patten;

import java.util.Stack;

public class InterpreterPatten {
    // 抽象表达式
    interface Expression {
        int interpret();
    }

    // 具体表达式
    static class NumberExpression implements Expression {
        private int number;

        public NumberExpression(int number) {
            this.number = number;
        }

        public int interpret() {
            return number;
        }
    }

    static class AddExpression implements Expression {
        private Expression left;
        private Expression right;

        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public int interpret() {
            return left.interpret() + right.interpret();
        }
    }

    static class SubtractExpression implements Expression {
        private Expression left;
        private Expression right;

        public SubtractExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        public int interpret() {
            return left.interpret() - right.interpret();
        }
    }

    // 解释器
    static class Interpreter {
        public int interpret(String context) {
            Stack<Expression> stack = new Stack<>();

            for (String token : context.split("\\s")) {
                if (isOperator(token)) {
                    Expression right = stack.pop();
                    Expression left = stack.pop();

                    if (token.equals("+")) {
                        stack.push(new AddExpression(left, right));
                    } else if (token.equals("-")) {
                        stack.push(new SubtractExpression(left, right));
                    }
                } else {
                    Expression expression = new NumberExpression(Integer.parseInt(token));
                    stack.push(expression);
                }
            }

            return stack.pop().interpret();
        }

        private boolean isOperator(String token) {
            return token.equals("+") || token.equals("-");
        }
    }


    public static void main(String[] args) {
        String context = "3 4 - 5 +";
        Interpreter interpreter = new Interpreter();
        int result = interpreter.interpret(context);
        System.out.println("解释器计算结果：" + result);
    }

}
