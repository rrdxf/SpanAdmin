package jiedan;

import java.util.HashMap;
import java.util.Scanner;

public class 已知中后求前 {
    static HashMap<Character,Integer> memo = new HashMap<>();

    static char[] post;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String in=scanner.nextLine();
        String [] get=in.split(" ");
        String sinorder=get[0];
        String spostorder=get[1];
        TreeNode treeNode=buildTree(sinorder, spostorder);
        preOrderRecur(treeNode);
    }
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);

    }
    public static TreeNode buildTree(String sinorder, String spostorder) {
        char[] inorder=sinorder.toCharArray();
        char[] postorder=spostorder.toCharArray();
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public static TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        char root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
      private static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
          TreeNode(char val) { this.val = val; }
          TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
