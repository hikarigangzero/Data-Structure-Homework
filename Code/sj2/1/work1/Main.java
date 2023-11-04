import java.util.Scanner;

class Links{
    class Node{
        int data;
        Node next;
    }

    private int length;
    private Node head;
    private Node p;

    Links(){
        length=0;
        head=new Node();
        p=head;
    }

    public int getLength() {
        return length;
    }

    public void Create(int a){
        p=head;
        while(p.next!=null){
            p=p.next;
        }
        Node node=new Node();
        p.next=node;
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

    public void Sort(){
        p=head;
        while(p.next!=null){
            Node q=new Node();
            q=p.next;
            while(q.next!=null){
                if(q.next.data<p.next.data){
                    Node r=new Node();
                    r=q.next;
                    q.next=r.next;
                    r.next=p.next;
                    p.next=r;
                }
                else{
                    q=q.next;
                }
            }
            p=p.next;
        }
    }
}

class Arrays{
    int []arr;
    private int length;
    private int size;

    public Arrays() {
        size = 256;
        arr = new int[size];
        length = 1;
    }

    public void Create(int a){
        if(size==length){
            size*=2;
            int []na=new int[size];
            System.arraycopy(arr,0,na,0,size);
            arr=na;
        }
        arr[length-1]=a;
        length++;
    }



    public void Print(){
        for (int i = 0; i < length-1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void sort(){
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length-1; j++) {
                if(arr[i]>arr[j]){
                    int a=arr[i];
                    arr[i]=arr[j];
                    arr[j]=a;
                }
            }
        }
    }
}

public class Main {
    public static void main(String []args){
        //使用链式结构
        Links links=new Links();
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int a=scanner.nextInt();
            if(a==-1)break;
            links.Create(a);
        }
        links.print();
        System.out.println(links.getLength());
        links.Sort();
        links.print();

        //使用顺序结构
        Arrays arrays=new Arrays();
        while(scanner.hasNextInt()){
            int a= scanner.nextInt();
            if(a==-1)break;
            arrays.Create(a);
        }
        arrays.Print();
        arrays.sort();
        arrays.Print();
    }
}

/*
* 23 45 12 2 5 6 78 54 34 23 45 12 78 90 55 -1
* */