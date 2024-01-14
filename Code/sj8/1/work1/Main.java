import com.sun.source.tree.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

class BTree{
    class Node{
        int data;
        Node lt;
        Node rt;
    }

    Node root;
    Node p;

    BTree(){
        root=null;
        p=null;
    }

    public void Create(int a){
        if(root==null){
            root=new Node();
            root.data=a;
            root.lt=null;
            root.rt=null;
        }
        else{
            p=root;
            while(true){
                if(a<p.data){
                    if(p.lt==null){
                        p.lt=new Node();
                        p.lt.data=a;
                        break;
                    }
                    p=p.lt;
                }
                else{
                    if(p.rt==null){
                        p.rt=new Node();
                        p.rt.data=a;
                        break;
                    }
                    p=p.rt;
                }
            }
        }
    }

    public void Print(){
        Stack<Node>stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node p=stack.pop();
            System.out.println(p.data);
            if(p.rt!=null)
                stack.push(p.rt);
            if(p.lt!=null)
                stack.push(p.lt);
        }
        System.out.println("----------分割线----------");
    }

    public boolean Search(int a) {
        p = root;
        while (p != null) {
            if (p.data == a)
                return true;
            else if (a < p.data)
                p = p.lt;
            else
                p = p.rt;
        }
        return false;
    }

    public void Delete(int a) {
        p = root;
        Node t=new Node();
        while(p!=null){
            if(p.data==a){
                break;
            }
            else if(a<p.data){
                t=p;
                p=p.lt;
            }
            else{
                t=p;
                p=p.rt;
            }
        }

        if(p==null){
            return;
        }

        if(p.lt==null&&p.rt==null){
            if(t!=null){
                if(t.lt==p)
                    t.lt=null;
                else
                    t.rt=null;
                p=null;
            }
            else{
                if(t.lt==p){
                    t.lt=null;
                }
                else if(t.rt==p){
                    t.rt=null;
                }
            }
        }
        else if(p.lt==null&&p.rt!=null){
            if(t!=null){
                if(t.data<p.data){
                    t.rt=p.rt;
                }
                else{
                    t.lt=p.rt;
                }
                p=null;
                return;
            }
            else{
                root=p.rt;
                p=null;
                return;
            }
        }
        else if(p.lt!=null&&p.rt==null){
            if(t!=null){
                if(t.data<p.data){
                    t.rt=p.lt;
                }
                else{
                    t.lt=p.lt;
                }
                p=null;
                return;
            }
            else{
                root=p.lt;
                p=null;
                return;
            }
        }
        else{
            Node f=p;
            Node q=p.lt;
            while(q.rt!=null){
                f=q;
                q=q.rt;
            }
            p.data=q.data;
            if(q.lt!=null&&q.rt!=null){
                if(f.data<q.data){
                    f.rt=null;
                }
                else{
                    f.lt=null;
                }
                q=null;
                return;
            }
            else{
                if(f.data<q.data){
                    f.rt=q.lt;
                }
                else{
                    f.lt=q.lt;
                }
                q=null;
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        File file = new File("Data.txt");
        PrintWriter pr = null;
        Scanner scanner = null;
        BTree tree = new BTree();

        try {
            pr = new PrintWriter(file);
            for (int i = 0; i < 10; i++) {
                int number = Math.abs(random.nextInt() % 20);
                pr.println(number);
            }
            pr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            scanner = new Scanner(file);
            for (int i = 0; i < 10; i++) {
                int number = scanner.nextInt();
                if (tree.Search(number)) {
                    continue;
                }
                tree.Create(number);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        tree.Print();

        while(true){
            int deta = Math.abs(random.nextInt() % 20);
            if(!tree.Search(deta)){
                tree.Create(deta);
                break;
            }
        }
        tree.Print();
        Scanner sc=new Scanner(System.in);
        tree.Delete(sc.nextInt());
        tree.Print();
    }
}
