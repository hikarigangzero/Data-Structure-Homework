import java.util.Scanner;

class Links{
    class Node{
        int data;
        Node next;
    }

    private Node head;
    private Node p;
    private int length;

    public Links() {
        head=new Node();
        p=head;
        length=0;
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

    public void Create(int n){
        p=head;
        for (int i = 1; i <= n; i++) {
            p.next=new Node();
            p.next.data=i;
            length++;
            if(i==n){
                p.next.next=head.next;
                return;
            }
            p=p.next;
        }
    }

    public void Print(){
        p=head;
        for (int i = 0; i < length; i++) {
            System.out.print(p.next.data+" ");
            p=p.next;
        }
        System.out.println();
    }

    public void CircularReporting(int m){
        p=head;
        //a用来记录报的数
        int a=0;
        int b=a%m;
        while(p.next!=p){
            if(b==m-1){
                System.out.print(p.next.data+" ");
                p.next=p.next.next;
            }
            else{
                p=p.next;
            }
            a++;
            b=a%m;
        }
        System.out.println(p.data);
        head.next=null;
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

    public void Create(int n){
        for (int i = 0; i < n; i++) {
            if(size==length-1){
                size*=2;
                int []na=new int[size];
                System.arraycopy(arr,0,na,0,size);
                arr=na;
            }
            arr[i]=i+1;
            length++;
        }
    }

    public void Print(){
        for (int i = 0; i < length-1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void CircularReporting(int m){
        //t控制报的数
        int t=0;
        //e控制已输出的个数
        int e=0;
        for (int a = 0, i = a%(length-1); i < length-1; a++,i=a%(length-1)) {
            if(arr[i]!=0){
                t++;
            }
            if(t==m){
                System.out.print(arr[i]+" ");
                arr[i]=0;
                t=0;
                e++;
            }
            if(e==length-1)break;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String []args){
        int n,m;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();

        //使用链式结构
        Links links=new Links();
        links.Create(n);
        System.out.print("初始链表内容：");
        links.Print();
        System.out.print("报数结果：");
        links.CircularReporting(m);

        //使用顺序结构
        Arrays arrays=new Arrays();
        arrays.Create(n);
        System.out.print("初始化动态数组内容：");
        arrays.Print();
        System.out.print("报数结果：");
        arrays.CircularReporting(m);
    }
}
/*
* 8 6
* */