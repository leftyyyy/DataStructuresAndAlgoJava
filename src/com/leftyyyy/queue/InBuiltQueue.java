package com.leftyyyy.queue;

import java.util.*;

public class InBuiltQueue {

    public static void main(String[] args) {
        Queue<Character> q_l = new LinkedList<>();

        //Queue<Character> q_a = (Queue<Character>) new ArrayList<Character>();
        //above declaration gives error

        Queue<Character> q_a = new ArrayDeque<>();


        q_l.add('r');
        q_l.add('i');
        q_l.add('s');
        q_l.add('h');
        q_l.add('i');

        System.out.println("size of q_l :" + q_l.size());

        q_a.add('p');
        q_a.add('r');
        q_a.add('a');
        q_a.add('j');
        q_a.add('a');
        q_a.add('p');
        q_a.add('a');
        q_a.add('t');
        q_a.add('i');

        System.out.println("size of q_a :" + q_a.size());

        while(!q_a.isEmpty()){
            System.out.println(q_a.peek());
            q_a.remove();
        }

        while(!q_l.isEmpty()){
            System.out.println(q_l.poll());
        }

        System.out.println("size of q_a :" + q_a.size());
        System.out.println("size of q_l :" + q_l.size());

        Queue<Character> p_q = new PriorityQueue<>();

        p_q.add('z');
        p_q.add('x');
        p_q.add('y');

        while(!p_q.isEmpty()){
            System.out.println(p_q.poll());
        }
    }
}
