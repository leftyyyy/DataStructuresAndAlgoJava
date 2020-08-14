package com.leftyyyy.stacks;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionEvaluation {
    private static Stack createStack(){
        Stack stack = new Stack();
        return stack;
    }

    private static int doSomething(int second, int first, char c){
        if(c=='+'){
            return second+first;
        }else if(c=='-'){
            return second-first;
        }else if(c=='*'){
            return second*first;
        }else{
            return second/first;
        }
    }

    private static int precedance(char c){
        if(c=='+' || c=='-'){
            return 1;
        }else{
            return 2;
        }
    }

    private static ArrayList evaluator(String input){
        Stack s = createStack();
        ArrayList<Integer> int_arr = new ArrayList<Integer>();
        char[] charArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            boolean flag = false;
            for (int j = 0; j < charArr.length; j++) {
                if (charArr[j] == c) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                int_arr.add((int) c - (int) '0');
                //System.out.println("int_arry "+int_arr);
            }else{
                //System.out.println(c);
                if(c=='{' || c=='[' || c=='('){
                    s.push(c);
                }else if(c=='+' || c=='*' || c=='/' || c=='-'){
                    //System.out.println(s.getTop());
                    while(!s.isEmpty() && (s.getTop()!='(' && s.getTop()!='[' && s.getTop()!='{') && precedance(c)<=precedance(s.getTop())){
                        char tmp = s.pop();
                        int first = int_arr.remove(int_arr.size()-1);
                        int second = int_arr.remove(int_arr.size()-1);
                        int res = doSomething(second, first, tmp);
                        int_arr.add(res);
                    }
                    s.push(c);
                }else{
                    while(s.getTop()!='(' && s.getTop()!='[' && s.getTop()!='{'){
                        char tmp = s.pop();
                        int first = int_arr.remove(int_arr.size()-1);
                        int second = int_arr.remove(int_arr.size()-1);
                        int res = doSomething(second, first, tmp);
                        int_arr.add(res);
                    }
                    s.pop();
                }
            }
        }

        while(!s.isEmpty()){
            char tmp = s.pop();
            int first = int_arr.remove(int_arr.size()-1);
            int second = int_arr.remove(int_arr.size()-1);
            int res = doSomething(second, first, tmp);
            int_arr.add(res);
        }
        return int_arr;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        ArrayList<Integer> res_arr;
        res_arr = evaluator(inputString);
        System.out.println(res_arr);
    }
}
