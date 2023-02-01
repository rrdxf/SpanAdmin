package daliystudy;

import java.util.Scanner;

public class meituanshu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Tree [] trees=new Tree[n+1];
        int a[]=new int[n+1];
        int b[]=new int[n+1];
        for (int i=1;i<=n;i++){
            a[i]=scanner.nextInt();
        }
        for (int i=1;i<=n;i++){
            b[i]=scanner.nextInt();
        }
        for (int i=0;i<n+1;i++){
            trees[i]=new Tree();
        }
        for (int i=1;i<=n;i++){
            trees[i].isblack=a[i];
            if (b[i]==0){
                trees[i].father=null;
            }else {
                trees[i].father=trees[b[i]];
                if (trees[b[i]].left==null){
                    trees[b[i]].left=trees[i];
                }else {
                    trees[b[i]].right=trees[i];
                }
            }
        }
        int black=0;
        int white=0;
        for (int i=1;i<=n;i++){
            if (trees[i].isblack==1){//hei
                if (trees[i].left==null&&trees[i].right==null){
                    black++;
                }else if (trees[i].left!=null&&trees[i].right!=null
                        &&trees[i].left.isblack==0
                        &&trees[i].right.isblack==0){
                    black++;
                }
            }else {//bai
                if (trees[i].left==null&&trees[i].right==null){
                    white++;
                }else {
                    if ((trees[i].left!=null&&trees[i].left.isblack==1)
                        ||(trees[i].right!=null&&trees[i].right.isblack==1)){
                        white++;
                    }
                }
            }
        }
        System.out.println(white+" "+black);
    }
    static class Tree{
        int isblack;
        Tree father;
        Tree left=null;
        Tree right=null;
    }
}
