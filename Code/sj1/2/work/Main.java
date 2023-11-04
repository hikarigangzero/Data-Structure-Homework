import java.util.Objects;
import java.util.Scanner;

class SXList{
    int []arr;
    private int size;
    private int length;

    public SXList() {
        this.arr = null;
        this.size = 256;
        this.length = 1;
    }

    public void create(int a){
        if(length==1){
            arr=new int[size];
            arr[0]=a;
            length++;
        }
        else if(size==length-1){
            size*=2;
            int []na=new int[size];
            System.arraycopy(arr,0,na,0,size);
            arr=na;
        }
        arr[length-2]=a;
        length++;
    }
}

class MyLink{
    class Node{
        int data;
        Node next;
    }

    private int length;
    private Node head;
    private Node p;

    public MyLink() {
        length=0;
        head=new Node();
        p=head;
        head.next=null;
        length=0;
    }

    public void Create(int a){
        p=head;
        Node node=new Node();
        for (int i = 0; i < length; i++) {
            p=p.next;
        }
        p.next=node;
        p.next.data=a;
        length++;
    }

    public void Print(){
        p=head;
        for (int i = 0; i < length; i++) {
            if(i==length-1){
                System.out.println(p.next.data);
                return;
            }
            System.out.print(p.next.data+" ");
            p=p.next;
        }
    }

    public void Reversal(){
        p=head;
        Node q=new Node();
        for (int i = 0; i < length-1; i++) {
            if(i==length-2){
                q=p.next;
                q.next=head.next;
                head.next=q;
                return;
            }
            if(i==0){
                p=p.next;
            }
            q=p.next;
            p.next=q.next;
            q.next=head.next;
            head.next=q;
        }
    }

    public int getLength() {
        return length;
    }

    public Node getHead() {
        return head;
    }

    public Node getP() {
        return p;
    }
}

public class Main {
    public static void main(String []args){
        //用动态数组实现
        SXList sxList=new SXList();
        for (int i = 0; i < 20; i++) {
            sxList.create(i+1);
        }
        for (int i = 0; i < 20; i++) {
            if(i==19){
                System.out.println(sxList.arr[i]);
            }
            else{
                System.out.print(sxList.arr[i]+" ");
            }
        }
        for (int i = 18; i >=0; i--) {
            sxList.arr[20]=sxList.arr[i];
            for (int j = i; j < 20; j++) {
                sxList.arr[j]=sxList.arr[j+1];
            }
        }
        for (int i = 0; i < 20; i++) {
            if(i==19){
                System.out.println(sxList.arr[i]);
            }
            else{
                System.out.print(sxList.arr[i]+" ");
            }
        }
        System.out.println("----------分割线----------");

        //用链表实现
        MyLink myLink=new MyLink();
        for (int i = 0; i < 20; i++) {
            myLink.Create(i+1);
        }
        myLink.Print();
        myLink.Reversal();
        myLink.Print();
    }
}
