import java.io.*;
import java.util.Random;

class XSArrary{
    final static int width=10;
    static class Arr{
        int row;
        int col;
        Object data;
    }

    Arr []arr;
    private int size;
    private int length;

    XSArrary(){
        size=256;
        arr=new Arr[size];
        length=1;
    }

    public void Create(Arr arr){
        if(length-1==size){
            size*=2;
            Arr []na=new Arr[size];
            System.arraycopy(this.arr,0,na,0,length-1);
            this.arr=na;
        }
        this.arr[length-1]=new Arr();
        this.arr[length-1]=arr;
        length++;
    }

    public void NormalCreate(){
        for (int i = 0; i < size; i++) {
            arr[i]=new Arr();
        }
    }

    public void Print(){
        System.out.println("行 列 数值");
        for (int i = 0; i < length-1; i++) {
            System.out.println(arr[i].row+" "+arr[i].col+" "+arr[i].data);
        }
    }

    public XSArrary LineRotate(){
        XSArrary xs=new XSArrary();
        for (int i = 1; i <= width; i++) {
            for (int j = 0; j < length-1; j++) {
                if(arr[j].col==i){
                    Arr brr=new Arr();
                    brr.row=arr[j].col;
                    brr.col=arr[j].row;
                    brr.data=arr[j].data;
                    xs.Create(brr);
                }
            }
        }
        return xs;
    }

    public XSArrary QuickRotate(){
        int []rowNum=new int[width+1];
        for (int i = 0; i < length-1; i++) {
            rowNum[arr[i].col]++;
        }
        int []rowStart=new int[width+1];
        for (int i = 1; i < width+1; i++) {
            if(i==1)rowStart[i]=0;
            else{
                rowStart[i]=rowNum[i-1]+rowStart[i-1];
            }
        }
        XSArrary xs=new XSArrary();
        xs.NormalCreate();
        for (int i = 0; i < length-1; i++) {
            int a=rowStart[arr[i].col];
            xs.arr[a].row=arr[i].col;
            xs.arr[a].col=arr[i].row;
            xs.arr[a].data=arr[i].data;
            xs.length++;
            rowStart[arr[i].col]++;
        }
        return xs;
    }
}

public class Main {
    final static int width=10;
    //生成矩阵的函数
    public int[][] Create(){
        Random random=new Random();
        int [][]brr=new int[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                brr[i][j]=random.nextInt()%100;
            }
        }
        return brr;
    }

    //写入文件并再从文件读入
    public XSArrary Creating(){
        Main main=new Main();
        File file=new File("Data.txt");
        FileOutputStream out=null;
        DataOutputStream dout=null;
        try {
            out=new FileOutputStream(file,false);
            dout=new DataOutputStream(out);
            int [][]brr=main.Create();
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    dout.writeInt(i+1);
                    dout.writeInt(j+1);
                    dout.writeInt(brr[i][j]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(dout!=null){
                try {
                    dout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (out!=null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        XSArrary xsArrary=new XSArrary();
        FileInputStream in=null;
        DataInputStream din=null;
        try {
            in=new FileInputStream(file);
            din=new DataInputStream(in);
            while(in.available()>0){
                XSArrary.Arr a= new XSArrary.Arr();
                a.row=din.readInt();
                a.col=din.readInt();
                a.data=din.readInt();
                xsArrary.Create(a);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(din!=null){
                try {
                    din.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return xsArrary;
    }

    public static void main(String []args){
        XSArrary xsArrary=new XSArrary();
        //验证创建的与读到的一致
        Main main=new Main();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(main.Create()[i][j]);
            }
        }
        System.out.println();
        xsArrary=main.Creating();
        xsArrary.Print();
        System.out.println("-----分割线-- 列序遍历转置后-----");
        xsArrary.LineRotate().Print();
        System.out.println("-----分割线-- 快速转置后-----");
        xsArrary.QuickRotate().Print();
    }
}
