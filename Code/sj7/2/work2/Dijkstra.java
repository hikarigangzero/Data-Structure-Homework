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
    private int Type;

    //先输入总节点数和总边数,以及0代表无向图，1代表有向图
    //再输入所有点的值
    //以（边编号 节点1 节点2 权值）输入边
    public void Create(){
        Scanner scanner=new Scanner(System.in);
        NodeNum=scanner.nextInt();
        LineNum=scanner.nextInt();
        Type=scanner.nextInt();
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

        if(Type==0){
            p=arr[x2];
            while(p.next!=null){
                p=p.next;
            }
            p.next=new Next();
            p.next.id=x1;
            p.next.LineID=LINE;
            p.next.weight=weight;
        }
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

    //开始点到a(这里a是id不是值)
    public void Dijkstra(int a){
        int []dist=new int[NodeNum];
        int []path=new int[NodeNum];
        boolean []join=new boolean[NodeNum];
        for (int i = 0; i < NodeNum; i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        for (int i = 0; i < NodeNum; i++) {
            if(i==0){
                p=arr[0];
                while(p.next!=null){
                    dist[p.next.id]=p.next.weight;
                    p=p.next;
                }
                dist[0]=0;
                join[0]=true;
            }
            else{
                //寻找最近的路
                int min=Integer.MAX_VALUE;
                int index=0;
                for (int j = 0; j < NodeNum; j++) {
                    if(!join[j]&&(dist[j]<min)){
                        min=dist[j];
                        index=j;
                    }
                }

                //对最近的进行操作
                join[index]=true;

                //改变其他点的dist值和path值
                for (int j = 0; j < NodeNum; j++) {
                    if(!join[j]){
                        for (int k = 0; k < NodeNum; k++) {
                            if(join[k]){
                                p=arr[k];
                                while(p.next!=null){
                                    if(p.next.id==j&&(p.next.weight+dist[k]<dist[j])){
                                        dist[j]=p.next.weight+dist[k];
                                        path[j]=k;
                                    }
                                    p=p.next;
                                }
                            }
                        }
                    }
                }

            }
        }

        Stack<Integer>stack=new Stack<>();
        int b=a;
        stack.push(a);
        while(b!=0){
            stack.push(path[b]);
            b=path[b];
        }
        while(!stack.isEmpty()){
            int e=stack.pop();
            System.out.print((e+1)+" ");
        }
        System.out.println();
    }
}


public class Dijkstra {
    public static void main(String[] args) {
        NeighborList neighborList=new NeighborList();
        neighborList.Create();
        neighborList.DFS(0);
        neighborList.BFS();
        neighborList.Dijkstra(4);
    }
}
/*
15 30 1
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
1 1 2 5
2 2 3 3
3 3 4 9
4 4 5 2
5 5 6 7
6 6 7 6
7 7 8 1
8 8 9 4
9 9 10 8
10 10 11 3
11 11 12 6
12 12 13 4
13 13 14 2
14 14 15 5
15 15 1 7
16 2 4 6
17 3 5 4
18 4 6 3
19 5 7 2
20 6 8 5
21 7 9 7
22 8 10 9
23 10 2 5
24 8 4 2
25 6 10 4
26 11 5 1
27 9 13 3
28 12 8 6
29 14 11 2
30 15 7 4
 */
