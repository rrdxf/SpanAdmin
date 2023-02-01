package jianzhioffer;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class Offer_7重建二叉树 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder == null){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < preorder.length ; i++){
            map.put(inorder[i],i);
        }
        return process(0,0,preorder.length - 1,preorder,map);
    }
    static TreeNode process(int root,int left,int right,int [] preorder,Map<Integer,Integer> map){
        if (left > right){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]);
        treeNode.left = process(root + 1,left,i - 1,preorder,map);
        treeNode.right = process(root + i + 1 - left,i + 1, right,preorder,map);
        return treeNode;
    }
    static int findindex(int [] inorder,int val){
        for (int i = 0; i < inorder.length; i++){
            if (val == inorder[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode trees=buildTree(new int [] {3,9,20,15,7},new int [] {9,3,15,20,7});
    }
}
