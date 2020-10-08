package com.dailyInterviewProblems;
/*
    private static ArrayList<Integer> solve(int A, int B){
        ArrayList<Integer> arr = new ArrayList<>();
        int n=1;
        for(int i=1; i<B; i++){
            arr.add(n++);
        }
        int r = A - B;
        arr.add(A);
        while(r--!=0){
            arr.add(n++);
        }
        return arr;
    }
     */
/*
        ArrayList res = solve(4, 4);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+"-");
        }

         */
class A {
    void m1(){
        System.out.println("m1-A");
    }
    void m2(){
        System.out.println("m2-A");
    }
}
class B extends A {
    void meth1(){
        System.out.println("meth1-B");
    }
    @Override
    void m2(){
        System.out.println("m2-B");
    }
}
public class tmp {
    public static void main(String[] args) {
        /*
        A obj = new A();
        obj.m1(); //m1-A
        obj.m2(); //m2-A

         */
        /*
        B obj = new B();
        obj.m2();//m2-B
        obj.m1();//m1-A
        obj.meth1();//meth1-B

         */
        A obj = new B();
        obj.m1();//m1-A
        obj.m2();//m2-B
        //B obj = new A(); --- error
    }
}
