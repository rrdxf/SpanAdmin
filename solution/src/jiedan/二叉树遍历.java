package jiedan;

import java.util.Scanner;

public class 二叉树遍历 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String [] sss;
        TreeNode [] treeNodes=new TreeNode[n];
        scanner.nextLine();
        for (int i=0;i<n;i++){
            TreeNode treeNode=new TreeNode();

            String s=scanner.nextLine();
            sss=s.split(" ");
            treeNode.val=sss[0].charAt(0);
            if (Integer.valueOf(sss[1])>0)
                treeNode.le=Integer.valueOf(sss[1]);
            if (Integer.valueOf(sss[2])>0)
                treeNode.ri=Integer.valueOf(sss[2]);
            treeNodes[i]=treeNode;
        }
        for (int i=0;i<n;i++){
            if (treeNodes[i].le==0){
                treeNodes[i].left=null;
            }else {
                treeNodes[i].left=treeNodes[treeNodes[i].le-1];
                treeNodes[treeNodes[i].le-1].count++;
            }
            if (treeNodes[i].ri==0){
                treeNodes[i].right=null;
            }else {
                treeNodes[i].right=treeNodes[treeNodes[i].ri-1];
                treeNodes[treeNodes[i].ri-1].count++;
            }
        }
        TreeNode head=new TreeNode();
        for (int i=0;i<n;i++){
            if (treeNodes[i].count==0){
                head=treeNodes[i];
            }
        }
        preOrderRecur(head);
        System.out.println();
        inOrderRecur(head);
        System.out.println();
        postOrderRecur(head);
    }
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val);
        inOrderRecur(head.right);
    }
    public static void postOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val);
    }
    private static class TreeNode {
        int count;
        char val;
        int le;
        int ri;
        TreeNode left;
        TreeNode right;
        TreeNode() {count=0;}
        TreeNode(char val) { this.val = val; }
        TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
