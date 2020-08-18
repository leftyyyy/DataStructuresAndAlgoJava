package com.leftyyyy.huffman;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoding {
    private static String path;
    private static HashMap<Character, String> storedMap;

    Comparator<BinaryTreeNode> sorter = Comparator.comparing(BinaryTreeNode:: getFreq);
    private static PriorityQueue<BinaryTreeNode> minPQ;
    HuffmanCoding(String path){
        this.path = path;
        this.minPQ = new PriorityQueue<>(sorter);
        this.storedMap = new HashMap<Character, String>();
    }

    public String getPath() {
        return this.path;
    }

    //making freq dict using inputString
    private static HashMap freqMap(String inputString){
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        char[] strArray = inputString.toCharArray();
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
                charCountMap.put(c, 1);
            }
        }
        return charCountMap;
    }

    //constructing heap (priority queue)
    private static void minPriorityQueue(HashMap charCountMap){
        Set<Character> keys = charCountMap.keySet();
        for(Character key: keys){
            Integer frequency = (Integer) charCountMap.get(key);
            BinaryTreeNode binary_tree_node = new BinaryTreeNode(key, frequency);
            minPQ.add(binary_tree_node);
        }
    }

    //construct binary tree from frequency dict
    private static void buildTree(PriorityQueue minPQ){
        while(minPQ.size()>1){
            BinaryTreeNode minimumNode_1 = (BinaryTreeNode) minPQ.poll();
            BinaryTreeNode minimumNode_2 = (BinaryTreeNode) minPQ.poll();
            int freqSum = minimumNode_1.getFreq() + minimumNode_2.getFreq();
            BinaryTreeNode newNode = new BinaryTreeNode(null, freqSum);
            newNode.setLeft(minimumNode_1);
            newNode.setRight(minimumNode_2);
            minPQ.add(newNode);
        }
    }

    //get code helper
    private static void getCodeHelper(BinaryTreeNode root, String currentBits){
        if(root == null){
            return;
        }
        if(root.getData() != null){
            storedMap.put(root.getData(), currentBits);
            return;
        }
        getCodeHelper(root.getLeft(), currentBits+'0');
        getCodeHelper(root.getRight(), currentBits+'1');
    }

    //getting the codes from Btree

    private static void getCodes(){
        BinaryTreeNode root = minPQ.poll();
        getCodeHelper(root, "");

    }

    //encoding
    private static String encoding(String inputText){
        String encodedText = "";
        char[] arr = inputText.toCharArray();
        for (char c : arr) {
            encodedText = storedMap.get(c);
        }
        return encodedText;
    }


    public static void compress(){
        //code for get path
        String text = "aaaaab";

        HuffmanCoding h = new HuffmanCoding(text);

        HashMap cCount = freqMap(h.getPath());

        minPriorityQueue(cCount);

        buildTree(minPQ);

        getCodes();

        String eText = encoding(h.getPath());

        System.out.println(eText);
        //HashMap mappedFreq = freqMap(path);
    }

    public static void main(String[] args) {
        compress();
    }
}
