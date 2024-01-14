import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GraphMatrix{
    class NodeValue{
        Object data;
        int id;
        boolean visit;
    }
    int [][]arr;
    NodeValue []nodeValue;
    private int size=256;
    private int NodeNum;
    private int LineNum;

    GraphMatrix(){
        arr=new int[size][size];
        nodeValue=new NodeValue[size];
    }

    public void Judge(){
        if(size==NodeNum){
            size*=2;
            int [][]na=new int[size][size];
            for (int i = 0; i < NodeNum; i++) {
                System.arraycopy(arr[i],0,na[i],0,NodeNum);
            }
            arr=na;
            NodeValue []ma=new NodeValue[size];
            System.arraycopy(nodeValue,0,ma,0,NodeNum);
            nodeValue=ma;
        }
    }

    //创建图
    //第一行总点和边数
    //第二行开始以（顶点编号 顶点信息）输入顶点(函数默认从0开始编号)
    //第三行开始以（顶点 顶点）输入边
    public void Create(){
        Judge();
        Scanner scanner=new Scanner(System.in);
        NodeNum=scanner.nextInt();
        LineNum=scanner.nextInt();
        for (int i = 0; i < NodeNum; i++) {
            nodeValue[i]=new NodeValue();
            nodeValue[i].id=scanner.nextInt();
            nodeValue[i].data=scanner.nextInt();
        }
        for (int i = 0; i < LineNum; i++) {
            int v1=scanner.nextInt();
            int v2=scanner.nextInt();
            arr[v1][v2]=1;
            arr[v2][v1]=1;
        }
    }

    //销毁
    public void Destroy(){
        for (int i = 0; i < NodeNum; i++) {
            nodeValue[i]=null;
        }
        for (int i = 0; i < NodeNum; i++) {
            for (int j = 0; j < NodeNum; j++) {
                arr[i][j]=0;
            }
        }
    }

    //根据编号得到元素值
    public Object GetVex(int a){
        return nodeValue[a].data;
    }

    //返回第一个邻接点
    public int FirstAdjVex(int a){
        for (int i = 0; i < NodeNum; i++) {
            if(arr[a][i]!=0){
                return i;
            }
        }
        return a;
    }

    //返回相对下一个邻接点
    public int NextAdjVex(int v,int w){
        for (int i = w+1; i < NodeNum; i++) {
            if(arr[v][i]!=0){
                return i;
            }
        }
        return 0;
    }

    //DFS
    public void DFS(int a){
        nodeValue[a].visit=true;
        System.out.print(nodeValue[a].data+" ");
        for (int i = 0; i < NodeNum; i++) {
            if(!nodeValue[i].visit&&arr[a][i]!=0){
                DFS(i);
            }
        }
        if(a==0){
            System.out.println();
        }
    }

    //BFS
    public void BFS(int a){
        for (int i = 0; i < NodeNum; i++) {
            nodeValue[i].visit=false;
        }
        Queue<NodeValue>queue=new LinkedList<>();
        queue.offer(nodeValue[a]);
        nodeValue[a].visit=true;
        int b=a;
        while(!queue.isEmpty()){
            NodeValue e=queue.poll();
            b=e.id;
            System.out.print(e.data+" ");
            for (int i = 0; i < NodeNum; i++) {
                if(arr[b][i]!=0&&!nodeValue[i].visit){
                    queue.offer(nodeValue[i]);
                    nodeValue[i].visit=true;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < NodeNum; i++) {
            nodeValue[i].visit=false;
        }
    }

    //添加新节点(括号中输入邻接的边的数量)
    //第一行输入（点编号 点的值）
    //第二行输入 加的边的数目
    //以（顶点 顶点）的格式输入边
    public void InsertVex(){
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        Object data=scanner.nextInt();
        Judge();
        NodeNum++;
        nodeValue[NodeNum-1]=new NodeValue();
        nodeValue[NodeNum-1].data=data;
        nodeValue[NodeNum-1].id=id;
        int a=scanner.nextInt();
        for (int i = 0; i < a; i++) {
            int v1=scanner.nextInt();
            int v2=scanner.nextInt();
            arr[v1][v2]=1;
            arr[v2][v1]=1;
        }
    }

    //添加边
    public void InsertArc(){
        Scanner scanner=new Scanner(System.in);
        int a1=scanner.nextInt();
        int a2=scanner.nextInt();
        arr[a1][a2]=1;
        arr[a2][a1]=1;
    }

    //删除顶点
    public void DeleteVex(int id){
        nodeValue[id]=null;
        for (int i = 0; i < NodeNum; i++) {
            if(arr[id][i]!=0||arr[i][id]!=0){
                arr[id][i]=0;
                arr[i][id]=0;
            }
        }
    }

    //删除边
    public void DeleteArc(int v1,int v2){
        arr[v1][v2]=0;
        arr[v2][v1]=0;
    }

}

public class Main {
    public static void main(String[] args) {
        GraphMatrix graphMatrix=new GraphMatrix();
        graphMatrix.Create();
        graphMatrix.DFS(0);
        graphMatrix.BFS(0);

        graphMatrix.InsertVex();
        graphMatrix.DFS(0);
        graphMatrix.BFS(0);
    }
}
/*
5 8
0 0
1 1
2 2
3 3
4 4
0 1
0 2
0 3
1 2
1 4
2 3
2 4
3 4

5 5
2
0 5
3 5
 */