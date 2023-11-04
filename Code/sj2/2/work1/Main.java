import java.util.Scanner;

class Links{
    class Node{
        int data;
        Node next;
    }

    private Node head;
    private Node p;
    private int length;

    public Links(){
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

    public void Print(){
        p=head;
        while(p.next!=null){
            System.out.print(p.next.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public Node getP() {
        return p;
    }

    public int getLength() {
        return length;
    }

    public void Change(Links a){
        p=head;
        a.p=a.head;
        while((p.next!=null)&&(a.p.next != null)){
            if(p.next.data>a.p.next.data){
                p=p.next;
            }
            else if(a.p.next.data==p.next.data){
                a.p.next=a.p.next.next;
            }
            else{
                Node node=new Node();
                node=a.p.next;
                a.p.next=a.p.next.next;
                node.next=p.next;
                p.next=node;
                p=p.next;
                length++;
            }
        }
    }
}

class Arrays{
    int []arr;
    private int size;
    private int length;

    public Arrays(){
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

    public void Print(){
        for (int i = 0; i < length-1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public void Change(int []arr, int length){
        int a=0;
        for (int i = 0; i < this.length-1; i++) {
            for (int j = a; j < length-1; j++) {
                if(this.length-1==this.size){
                    this.size*=2;
                    int []na=new int[this.size];
                    System.arraycopy(this.arr,0,na,0,this.size);
                }
                if(this.arr[i]<arr[j]){
                    for (int k = this.length-2; k >= i; k--) {
                        this.arr[k+1]=this.arr[k];
                    }
                    this.length++;
                    this.arr[i]=arr[j];
                    a=j+1;
                } else if (this.arr[i]==arr[j]) {
                    a=j+1;
                }
            }
        }
    }
}

public class Main {
    public static void main(String []args){
        //使用链式结构
        Links links1=new Links();
        Links links2=new Links();
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int a= scanner.nextInt();
            if(a==-1)break;
            links1.Create(a);
        }
        while(scanner.hasNextInt()){
            int a= scanner.nextInt();
            if(a==-1)break;
            links2.Create(a);
        }
        System.out.println("A数据");
        links1.Print();
        System.out.println("B数据");
        links2.Print();
        links1.Change(links2);
        links1.Print();
        links2.Print();
        System.out.println("----------分割线----------");

        //使用顺序结构
        Arrays arrays1=new Arrays();
        Arrays arrays2=new Arrays();
        while(scanner.hasNextInt()){
            int a= scanner.nextInt();
            if(a==-1)break;
            arrays1.Create(a);
        }
        while(scanner.hasNextInt()){
            int a= scanner.nextInt();
            if(a==-1)break;
            arrays2.Create(a);
        }
        System.out.println("A数据");
        arrays1.Print();
        System.out.println("B数据");
        arrays2.Print();
        arrays1.Change(arrays2.arr,arrays2.getLength());
        arrays1.Print();
        arrays2.Print();
    }
}
/*
* A 90 89 76 45 34 23 21 12 9 3 -1
* B 78 65 53 44 32 23 22 12 8 2 -1
* */