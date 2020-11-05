package com.codeforcesPractice.points800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JoshQ2 {
    class Node{
        int value;
        Node next;

        public Node(int value, Node next){
            this.next = next;
            this.value = value;
        }
    }

    private Node getInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int arrayLength = Integer.parseInt(br.readLine());
            List<Node> valueList = new ArrayList<Node>();
            for(int index=0;index<arrayLength;index++){
                int value = Integer.parseInt(br.readLine());
                Node node = new Node(value, null);
                valueList.add(node);
                if(index>0){
                    valueList.get(index-1).next = node;
                }
            }
            if(arrayLength == 0){
                return null;
            }
            return valueList.get(0);
        } catch (IOException e) {
            return null;
        }
    }

    private void printAnswer(Node head){
        if(head != null){
            System.out.println(head.value);
            printAnswer(head.next);
        }
    }
    private Node multiply(Node head){
        Node curr = head;
        while(curr.next!=null){
            //updating value till second last
            curr.value = curr.value*3;
            curr = curr.next;
        }
        //updating value for last element
        curr.value = curr.value*3;
        return head;
    }

    public static void main(String[] args) {
        JoshQ2 sol = new JoshQ2();
        Node head = sol.getInput();
        Node answer = sol.multiply(head);
        if(head==null){
            System.out.println("Empty");
        }
        sol.printAnswer(answer);
    }
}
