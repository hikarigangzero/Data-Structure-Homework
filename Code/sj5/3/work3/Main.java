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

    //递归删除对应值的子树
    public Node Del(Node t,Object x){
        if(t==null)return null;
        if(equals(t.data,x)){
            t=null;
        }
        if (t != null && t.lt != null) {
            t.lt = Del(t.lt, x);
        }
        if (t != null && t.lt != null) {
            t.rt = Del(t.rt, x);
        }
        return t;
    }

    public boolean equals(Object obj1,Object obj2) {
        String x=(String) obj1;
        String y=(String) obj2;
        return x.equals(y);
    }

    public void UNDel(Object x){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            if(equals(node.data,x)){
                /*node.lt=null;
                node.rt=null;
                Delete(node);*/
                node=null;
            }
            if(node!=null){
                if(node.rt!=null){
                    stack.push(node.rt);
                }
                if(node.lt!=null){
                    stack.push(node.lt);
                }
            }
        }
    }

    public void Delete(Node t){
        Stack<Node>stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            if(node.lt==t){
                node.lt=null;
                return;
            }
            if(node.rt==t){
                node.rt=null;
                return;
            }
            if(node.rt!=null){
                stack.push(node.rt);
            }
            if(node.lt!=null){
                stack.push(node.lt);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.Read();
        binaryTree.ProTraverse(binaryTree.getRoot());
        //binaryTree.Del(binaryTree.getRoot(), "d");
        //binaryTree.ProTraverse(binaryTree.getRoot());
        binaryTree.UNDel("d");
        binaryTree.ProTraverse(binaryTree.getRoot());
    }
}

/*这里是按先序遍历的方式输入的树的数据
a b c # # # d e # # f # #
 */