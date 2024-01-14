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
    private Scanner scanner1;

    BinaryTree(){
        root=null;
        p=root;
    }

    public void Read(){
        Scanner scanner=new Scanner(System.in);
        String str=null;
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

    public void ProTraverse(Node t){
        if(t!=null) {
            System.out.print(t.data+" ");
            ProTraverse(t.lt);
            ProTraverse(t.rt);
        }
        if(t==root){
            System.out.println();
        }
    }

    public Node getRoot(){
        return root;
    }

    public void LevelTraverse(){
        int length=0;
        int max=length;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            length= queue.size();
            max= Math.max(length, max);
            for (int i = 0; i < length; i++) {
                Node t=queue.poll();
                if(t!=null){
                    if(t.lt!=null){
                        queue.offer(t.lt);
                    }
                    if(t.rt!=null){
                        queue.offer(t.rt);
                    }
                }
            }
        }
        System.out.println("宽度"+max);
    }

}

public class MAin {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.Read();
        binaryTree.ProTraverse(binaryTree.getRoot());
        binaryTree.LevelTraverse();
    }
}
/*
a b c # # # d e # # f # #
 */