import java.util.Iterator;
import java.util.Scanner;

class ArrayMy{
    int []arr;
    private int size;
    private int length;

    ArrayMy(){
        size=256;
        length=1;
        arr=new int[size];
    }

    public void Create(int a){
        if(length-1==size){
            size*=2;
            int []na=new int[size];
            System.arraycopy(arr,0,na,0,size);
            arr=na;
        }
        arr[length-1]=a;
        length++;
    }

    public void print(){
        for (int i = 0; i < length-1; i++) {
            if(i==length-2){
                System.out.println(arr[i]);
                return;
            }
            System.out.print(arr[i]+" ");
        }
    }
    public void DelRepeat(){
        for (int i = 0; i < length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                if(arr[i]==arr[j]){
                    for (int k = j; k < length-2; k++) {
                        arr[k]=arr[k+1];
                    }
                    length--;
                }
            }
        }
    }
}

class MyLink{
    class Node{
        int data;
        Node next;
    }

    private Node head;
    private Node p;
    private int length;

    MyLink(){
        head=new Node();
        p=head;
        length=0;
    }

    public void Create(int a){
        p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.next=new Node();
        p.next.data=a;
        length++;
    }

    public void print(){
        p=head;
        while(p.next!=null){
            System.out.print(p.next.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    public void DelRepeat(){
        p=head;
        Node q=new Node();
        while(p.next!=null){
            q=p.next;
            while(q.next!=null){
                if(p.next.data==q.next.data){
                    if(q.next.next!=null){
                        q.next=q.next.next;
                    }
                    else{
                        q.next=null;
                        break;
                    }
                    length--;
                }
                q=q.next;
            }
            p=p.next;
        }
    }
}

public class Main {
    public static void main(String []args){
        //用数组实现
        ArrayMy arrayMy=new ArrayMy();
        for (int i = 0; i < 20; i++) {
            arrayMy.Create(i%10);
        }
        arrayMy.print();
        arrayMy.DelRepeat();
        arrayMy.print();

        //用链表实现
        MyLink myLink=new MyLink();
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            myLink.Create(scanner.nextInt());
        }
        for (int i = 0; i < 20; i++) {
            myLink.Create(i%10);
        }
        myLink.print();
        myLink.DelRepeat();
        myLink.print();
    }
}
