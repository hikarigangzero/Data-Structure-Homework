import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Next{
    int LineID;
    int id;
    int weight;
    Next next;
}

class Node extends Next{
    int id;
    Object data;
    boolean visit;
}

class NeighborList{
    private int size=256;
    private int Addsize=128;
    private int length=1;
    private Next p;
    private Node []arr=new Node[size];
    private int NodeNum;
    private int LineNum;

    //先输入总节点数和总边数
    //再输入所有点的值
    //以（边编号 节点1 节点2 权值）输入边
    public void Create(){
        Scanner scanner=new Scanner(System.in);
        NodeNum=scanner.nextInt();
        LineNum=scanner.nextInt();
        for (int i = 0; i < NodeNum; i++) {
            int a=scanner.nextInt();
            AddNode(a);
        }
        for (int i = 0; i < LineNum; i++) {
            int a1= scanner.nextInt();
            Object a2= scanner.nextInt();
            Object a3= scanner.nextInt();
            int a4= scanner.nextInt();
            AddLine(a1,a2,a3,a4);
        }
    }

    public void Adjust(){
        if(length-1==size){
            size+=Addsize;
            Node []na=new Node[size];
            System.arraycopy(arr,0,na,0,length-1);
            arr=na;
        }
    }

    public void AddNode(Object a){
        Adjust();
        arr[length-1]=new Node();
        arr[length-1].data=a;
        length++;
    }

    public void AddLine(int LINE,Object v1,Object v2,int weight){
        int x1=0;
        int x2=0;
        for (int i = 0; i < NodeNum; i++) {
            if(arr[i].data==v1){
                x1=i;
                break;
            }
        }
        for (int i = 0; i < NodeNum; i++) {
            if(arr[i].data==v2){
                x2=i;
                break;
            }
        }

        p=arr[x1];
        while(p.next!=null){
            p=p.next;
        }
        p.next=new Next();
        p.next.id=x2;
        p.next.LineID=LINE;
        p.next.weight=weight;

        p=arr[x2];
        while(p.next!=null){
            p=p.next;
        }
        p.next=new Next();
        p.next.id=x1;
        p.next.LineID=LINE;
        p.next.weight=weight;
    }

    public void DFS(int a){
        arr[a].visit=true;
        System.out.print(arr[a].data+" ");
        Next q=arr[a];
        while(q.next!=null){
            if(!arr[q.next.id].visit){
                DFS(q.next.id);
            }
            q=q.next;
        }
        if (a==0){
            System.out.println();
        }
    }

    public void BFS(){
        for (int i = 0; i < NodeNum; i++) {
            arr[i].visit=false;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(arr[0]);
        arr[0].visit=true;
        while(!queue.isEmpty()){
            Node node= queue.poll();
            Next line= node;
            System.out.print(node.data+" ");
            while(line.next!=null){
                if(!arr[line.next.id].visit){
                    queue.offer(arr[line.next.id]);
                    arr[line.next.id].visit=true;
                }
                line=line.next;
            }
        }
        System.out.println();
    }


}

public class Main {
    public static void main(String[] args) {
        NeighborList neighborList=new NeighborList();
        neighborList.Create();
        neighborList.DFS(0);
        neighborList.BFS();
    }
}
/*
10 20
1 2 3 4 5 6 7 8 9 10
1 1 2 5
2 2 3 3
3 3 4 9
4 4 5 2
5 5 6 7
6 6 7 6
7 7 8 1
8 8 9 4
9 9 10 8
10 10 1 3
11 2 4 6
12 3 5 4
13 4 6 3
14 5 7 2
15 6 8 5
16 7 9 7
17 8 10 9
18 10 2 5
19 8 4 2
20 6 10 4
 */
