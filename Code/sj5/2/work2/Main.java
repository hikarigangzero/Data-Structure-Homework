import java.util.*;

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

    //中序遍历递归实现
    public void InTraverse(Node t){
        if(t!=null){
            InTraverse(t.lt);
            System.out.print(t.data+" ");
            InTraverse(t.rt);
        }
        if(t==root){
            System.out.println();
        }
    }

    //后序遍历递归实现
    public void PostTraverse(Node t){
        if(t!=null){
            PostTraverse(t.lt);
            PostTraverse(t.rt);
            System.out.print(t.data+" ");
        }
        if(t==root){
            System.out.println();
        }
    }

    //层次遍历实现
    public void LevelTraverse(){
        Queue<Node>queue=new LinkedList<>();
        p=root;
        queue.offer(p);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            System.out.print(node.data+" ");
            if(node.lt!=null){
                queue.offer(node.lt);
            }
            if(node.rt!=null){
                queue.offer(node.rt);
            }
        }
        System.out.println();
    }

    //先序遍历非递归实现
    public void UNProTraverse(){
        if(root==null)return;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node t=stack.pop();
            System.out.print(t.data+" ");
            if(t.rt!=null){
                stack.push(t.rt);
            }
            if(t.lt!=null){
                stack.push(t.lt);
            }
        }
        System.out.println();
    }

    //中序遍历非递归实现
    public void UNInTraverse(){
        if(root==null)return;
        Stack<Node> stack=new Stack<>();
        Node t=root;
        while(t!=null||!stack.isEmpty()){
            while(t!=null){
                stack.push(t);
                t=t.lt;
            }
            t=stack.pop();
            System.out.print(t.data+" ");
            t=t.rt;
        }
        System.out.println();
    }

    //后序遍历非递归实现
    public void UNPostTraverse(){
        if(root==null)return;
        Node t=root;
        Stack<Node> stack=new Stack<>();
        Stack<Node> output=new Stack<>();
        stack.push(t);
        while(!stack.isEmpty()){
            t=stack.pop();
            output.push(t);
            if(t.lt!=null){
                stack.push(t.lt);
            }
            if(t.rt!=null){
                stack.push(t.rt);
            }
        }
        while(!output.isEmpty()){
            Node node=output.pop();
            System.out.print(node.data+" ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.Read();
        binaryTree.ProTraverse(binaryTree.getRoot());
        binaryTree.InTraverse(binaryTree.getRoot());
        binaryTree.PostTraverse(binaryTree.getRoot());
        binaryTree.LevelTraverse();
        System.out.println("非递归");
        binaryTree.UNProTraverse();
        binaryTree.UNInTraverse();
        binaryTree.UNPostTraverse();
    }
}

/*
a b c # # # d e # # f # #
 */