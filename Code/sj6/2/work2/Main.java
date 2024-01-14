import java.util.Scanner;
import java.util.Random;

class Huffman{
    int id;
    Object data;
    int weight;
    int parent;
    int lt;
    int rt;

    Huffman(int i,Object a,int weight){
        this.id=i;
        this.data=a;
        this.weight=weight;
        this.parent=0;
        this.lt=0;
        this.rt=0;
    }

    Huffman(int i){
        this.id=i;
        this.data=null;
        this.weight=0;
        this.parent=0;
        this.lt=0;
        this.rt=0;
    }
}

public class Main {
    private int length;
    public void LookFor(Huffman []huffman){
        int min=0;
        int nxMin=0;

        for (int i = 1; i <= length; i++) {
            if(huffman[i].parent==0){
                if(min==0){
                    min=huffman[i].weight;
                }
                else if(nxMin==0){
                    if(min>huffman[i].weight){
                        int a=min;
                        min=huffman[i].weight;
                        nxMin=a;
                    }
                    else {
                        nxMin=huffman[i].weight;
                    }
                }
                else{
                    if(huffman[i].weight<min){
                        int a=min;
                        min=huffman[i].weight;
                        nxMin=a;
                    }
                    else if(min<=huffman[i].weight&&huffman[i].weight<nxMin){
                        nxMin=huffman[i].weight;
                    }
                }
            }
        }

        for (int i = 1; i <= length; i++) {
            if(huffman[i].weight==min){
                huffman[length+1].lt=i;
                huffman[i].parent=length+1;
            }
            if(huffman[i].weight==nxMin){
                huffman[length+1].rt=i;
                huffman[i].parent=length+1;

            }
        }
        huffman[length+1].weight=min+nxMin;
        length++;
    }

    public static void main(String[] args) {
        //基本处理与复制
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        Main main=new Main();
        main.length=n;
        Huffman []huffmen=new Huffman[2*n];
        Random random=new Random();
        for (int i = 1; i <= n ; i++) {
            Object a=Math.abs(random.nextInt())%100+1;
            int weight= Math.abs(random.nextInt())%100+1;
            huffmen[i]=new Huffman(i,a,weight);
        }
        for (int i = n+1; i <= (2*n-1); i++) {
            huffmen[i]=new Huffman(i);
        }

        for (int i = 0; i < n-1; i++) {
            main.LookFor(huffmen);
        }

        for (int i = 1; i <= 2*n-1; i++) {
            System.out.println(huffmen[i].id+" "+huffmen[i].data+" "
                    +huffmen[i].weight+" "+huffmen[i].parent+" "
                    +huffmen[i].lt+" "+huffmen[i].rt);
        }
    }
}
/*
输入n的个数
 */
