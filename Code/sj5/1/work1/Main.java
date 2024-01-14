import java.sql.SQLOutput;
import java.util.*;

class BinaryTree{
    class Node{
        Object data;
        Node lt;
        Node rt;
    }
    private Node root;
    private Node p;
    private String str;
    private Scanner scanner1;

    //初始化，用构造函数实现
    BinaryTree(){
        root=null;
        p=root;
    }

    //销毁
    public void DestroyBiTree(){
        root=null;
    }

    //读入算法
    public void read(){
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNextLine()){
            str=scanner.nextLine();
            scanner1=new Scanner(str);
        }
        root=Create(root);
    }

    //创建二叉树()
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

    //是否为空
    public boolean BiTreeEmpty(){
        return root.data == null;
    }

    //返回树的深度
    public int Depth(Node t){
        if(t==null){
            return 0;
        }
        int lDepth=Depth(t.lt);
        int rDepth=Depth(t.rt);
        return Math.max(lDepth,rDepth)+1;
    }

    //返回根
    public Object Root(){
        return root.data;
    }

    //返回对应节点的值
    public Object Value(Node t){
        return t.data;
    }

    //返回双亲
    public Node parent(Node t){
        if(t==root){
            return null;
        }
        if(t.lt!=null&&t.lt.data==t.data){
            p=t;
        }
        if(t.rt!=null&&t.rt.data==t.data){
            p=t;
        }
        parent(t.lt);
        parent(t.rt);
        return p;
    }

    //返回左孩子
    public Node LChild(Node t){
        return t.lt;
    }

    //返回右孩子
    public Node RChild(Node t){
        return t.lt;
    }

    //返回左兄弟
    public Node LBrother(Node t){
        Node par=parent(t);
        if(par.lt!=t&&par.lt!=null){
            return par.lt;
        }
        else{
            return null;
        }
    }

    //返回右兄弟
    public Node RBrother(Node t){
        Node par=parent(t);
        if(par.rt!=t&&par.rt!=null){
            return par.rt;
        }
        else{
            return  null;
        }
    }

    //先序优先遍历
    public void ProOrderTraverse(Node t){
        if(t==root){
            System.out.print("先序遍历：");
        }
        if(root==null){
            System.out.println("树为空");
            return;
        }
        if(t==null)return;
        System.out.print(t.data+" ");
        ProOrderTraverse(t.lt);
        ProOrderTraverse(t.rt);
        if(t==root){
            System.out.println();
        }
    }

    //中序优先遍历
    public void InOrderTraverse(Node t){
        if(t==root){
            System.out.print("中序遍历：");
        }
        if(root==null) {
            System.out.println("树为空");
            return;
        }
        if(t==null)return;
        InOrderTraverse(t.lt);
        System.out.print(t.data+" ");
        InOrderTraverse(t.rt);
        if(t==root){
            System.out.println();
        }
    }

    //后序优先遍历
    public void PostOrderTraverse(Node t){
        if(t==root){
            System.out.print("后序遍历：");
        }
        if(root==null){
            System.out.println("树为空");
            return;
        }
        if(t==null)return;
        PostOrderTraverse(t.lt);
        PostOrderTraverse(t.rt);
        System.out.print(t.data+" ");
        if(t==root){
            System.out.println();
        }
    }

    //层次遍历
    public void LevelOrderTraverse() {
        System.out.print("层次遍历：");
        p = root;
        if(p==null){
            System.out.println("树为空");
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(p);
        while(!queue.isEmpty()){
            Node node= queue.poll();
            System.out.print(node.data+" ");
            if(node.lt!=null){
                queue.offer(node.lt);
            }
            if(node.rt!=null){
                queue.offer(node.rt);
            }
        }
    }

    //对节点赋值
    public void Assign(Object value,Node t){
        t.data=value;
    }

    //插入子树
    public void InsertChild(int a,Node t,Node c){
        p=t;
        if(a==0){
            Node node=new Node();
            node=p.lt;
            p.lt=c;
            c.rt=node;
        }
        if(a==1){
            Node node=new Node();
            node=p.rt;
            p.rt=c;
            c.rt=node;
        }
    }

    //删除孩子
    public void Delete(Node t,int a){
        if(a==0){
            t.lt=null;
        }
        if(a==1){
            t.rt=null;
        }
    }
    public Node getRoot() {
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.read();
        System.out.println(binaryTree.BiTreeEmpty());
        System.out.println(binaryTree.Depth(binaryTree.getRoot()));
        binaryTree.ProOrderTraverse(binaryTree.getRoot());
        binaryTree.InOrderTraverse(binaryTree.getRoot());
        binaryTree.PostOrderTraverse(binaryTree.getRoot());
        binaryTree.LevelOrderTraverse();
    }
}
/*
a b c # # # d e # # f # #
 */