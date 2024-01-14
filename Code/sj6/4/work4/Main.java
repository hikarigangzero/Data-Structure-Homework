import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

class Tree{
    class Node{
        Object data;
        Node lt;
        Node rt;
    }

    private Node root;
    private Scanner scanner1;

    public void Read(){
        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNextLine()){
            String str=scanner.nextLine();
            scanner1=new Scanner(str);
            root=Create(root);
        }
    }

    public Node Create(Node t){
        String a=scanner1.next();
        if (Objects.equals(a, "#")) {
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

    public void ProPrint(Node t){
        if(t!=null){
            System.out.print(t.data+" ");
            ProPrint(t.lt);
            ProPrint(t.rt);
        }
        if(t==root){
            System.out.println();
        }
    }

    public Node getRoot(){
        return root;
    }

    public void LevelTraverse(int a){
        Queue<Node>queue=new LinkedList<>();
        queue.offer(root);
        int floor=1;
        while(!queue.isEmpty()){
            int length= queue.size();
            if(floor==a){
                for (int i = 0; i < length; i++) {
                    Object pp=queue.poll().data;
                    System.out.print(pp+" ");
                }
                System.out.println();
                return;
            }
            for (int i = 0; i < length; i++) {
                Node t= queue.poll();
                if(t!=null){
                    if(t.lt!=null){
                        queue.offer(t.lt);
                    }
                    if(t.rt!=null){
                        queue.offer(t.rt);
                    }
                }
            }
            floor++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.Read();
        tree.ProPrint(tree.getRoot());
        tree.LevelTraverse(3);
    }
}
/*
a b c # # # d e # # f # #
 */