import java.io.*;
import java.util.Random;

class ADTStack{
    Object []arr;
    private int size;
    private int top;

    ADTStack(){
        size=256;
        top=1;
        arr=null;
    }

    //初始化
    public void InitStack(){
        arr=new Object[size];
    }

    //销毁
    public void DestroyStack(){
        arr=null;
    }

    public void ClearStack(){
        for (int i = 0; i < top-1; i++) {
            arr[i]=null;
        }
        top=1;
    }

    public boolean StackEmpty(){
        return top==1;
    }

    public int StackLength(){
        return top-1;
    }

    public Object GetTop(){
        return arr[top-2];
    }

    public void StackTraverse(){
        if(top==1){
            System.out.println("null");
            return;
        }
        for (int i = 0; i < top-1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void push(Object a){
        if(size==(top-1)){
            size*=2;
            Object []na=new Object[size];
            System.arraycopy(arr,0,na,0,top-1);
            arr=na;
        }
        arr[top-1]=a;
        top++;
    }

    public Object Pop(){
        Object a=arr[top-2];
        arr[top-2]=null;
        top--;
        return a;
    }
}

public class Main {
    public static void main(String []args){
        Random random=new Random();
        int []linshi=new int[1000];
        for (int i = 0; i < 1000; i++) {
            linshi[i]= random.nextInt();
        }
        //创建一个文件
        File f=new File("inttni.txt");
        FileOutputStream out=null;
        DataOutputStream dout=null;
        try {
            out=new FileOutputStream(f,false);
            dout=new DataOutputStream(out);
            for (int i = 0; i < 1000; i++) {
                dout.writeInt(linshi[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dout!=null) {
                try {
                    dout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //初始化一个栈
        ADTStack adtStack=new ADTStack();
        adtStack.InitStack();
        //验证是否为空
        System.out.println(adtStack.StackEmpty());
        //验证读入与遍历
        FileInputStream in=null;
        DataInputStream din=null;
        try {
            in=new FileInputStream(f);
            din=new DataInputStream(in);
            for (int i = 0; i < 1000; i++) {
                adtStack.push(din.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (din!=null) {
                try {
                    din.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        adtStack.StackTraverse();
        //返回顶元素
        System.out.println(adtStack.GetTop());
        //弹出100个
        System.out.print("弹出的元素：");
        System.out.println(adtStack.Pop());
        //返回数目
        System.out.println(adtStack.StackLength());
        //清空再返回数目
        adtStack.ClearStack();
        System.out.println(adtStack.StackLength());
        //销毁再遍历
        adtStack.DestroyStack();
        adtStack.StackTraverse();
    }
}
