import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

class BinaryTree{
    class Node{
        Object data;
        Node lt;
        Node rt;
    }

    private Node root;
    private Node p;
    Scanner scanner;
    Scanner scanner1;
    String str;

    public BinaryTree(){
        root=null;
        p=root;
    }

    public void Read(){
        scanner=new Scanner(System.in);
        if(scanner.hasNextLine()){
            str=scanner.nextLine();
            scanner1=new Scanner(str);
        }
        root=Create(root);
    }

    public Node Create(Node t){
        String a=scanner1.next();
        if(Objects.equals(a, "#")){
            t=null;
        }
        else{
            t=new Node();
            t.data=a;
            t.lt=Create(t.lt);
            t.rt=Create(t.rt);
        }
        return t;
    }

    public Node getRoot() {
        return root;
    }

    //先序遍历递归实现
    public void ProTraverse(Node t){
        if(t!=null){
            System.out.print(t.data+" ");
            ProTraverse(t.lt);
            ProTraverse(t.rt);
        }
        if(t==root){
            System.out.println();
        }
    }

    //判断是否为完全二叉树
    public boolean CompleteTree(){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        //记录是否一个节点只有左子树
        boolean a=false;
        //记录一个节点没有子树
        boolean b=false;
        while(!queue.isEmpty()){
            Node node= queue.poll();
            if(node.lt==null&&node.rt!=null){
                return false;
            }
            if(node.lt!=null&&node.rt==null){
                a=true;
            }
            if(node.lt==null&&node.rt==null){
                b=true;
            }
            if((a||b)&&(node.lt!=null||node.rt!=null)){
                return false;
            }
            if(node.lt!=null){
                queue.offer(node.lt);
            }
            if(node.rt!=null){
                queue.offer(node.rt);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.Read();
        binaryTree.ProTraverse(binaryTree.getRoot());
        System.out.println(binaryTree.CompleteTree());
    }
}
/*
是的
a b c # # d # # e # #
不是的
a b c # # # d e # # f # #
 */
