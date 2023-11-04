import java.io.*;
import java.util.Random;

class ADTQueue{
    class Node{
        Object Data;
        Node next;
    }

    private Node head;
    private Node tail;
    private Node p;
    private int length;

    public ADTQueue() {
        head = null;
        tail=null;
        p=null;
        length=0;
    }

    //初始化队列
    public void InitQueue(){
        head = new Node();
        tail = head;
        p = head;
    }

    //销毁队列
    public void DestroyQueue(){
        head=null;
        tail=null;
        p=null;
        length=0;
    }

    //清空队列
    public void ClearQueue(){
        head.next=null;
        tail=head;
        p=head;
        length=0;
    }

    //判断是否为空
    public boolean QueueEmpty(){
        return length==0;
    }

    //求长度
    public int QueueLength(){
        return length;
    }

    //返回队头
    public Object Gethead(){
        return head.next.Data;
    }

    //遍历
    public void QueueTraverse(){
        p=head;
        if(head.next==null){
            System.out.println("null");
            return;
        }
        while(p.next!=null){
            System.out.print(p.next.Data+" ");
            p=p.next;
        }
        System.out.println();
    }

    //进队
    public void EnQueue(Object a){
        tail.next=new Node();
        tail.next.Data=a;
        tail=tail.next;
        length++;
    }

    //出队
    public Object DeQueue(){
        Object a=head.next.Data;
        if(head.next.next!=null){
            head.next=head.next.next;
            length--;
        }
        else{
            head.next=null;
            tail=head;
            length--;
        }
        return a;
    }
}

public class Main {
    public static void main(String []args){
        ADTQueue adtQueue=new ADTQueue();
        //初始化队列
        adtQueue.InitQueue();
        //构建数据
        Random random=new Random();
        File file=new File("data.txt");
        FileOutputStream out=null;
        DataOutputStream dout=null;
        try {
            out=new FileOutputStream(file,false);
            dout=new DataOutputStream(out);
            for (int i = 0; i < 1000; i++) {
                dout.writeInt(random.nextInt());
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

        //进入队列
        FileInputStream in=null;
        DataInputStream din=null;
        try {
            in=new FileInputStream(file);
            din=new DataInputStream(in);
            for (int i = 0; i < 1000; i++) {
                adtQueue.EnQueue(din.readInt());
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

        //遍历
        adtQueue.QueueTraverse();
        //出队
        System.out.println(adtQueue.DeQueue());
        //返回长度
        System.out.println(adtQueue.QueueLength());
        //再次遍历
        adtQueue.QueueTraverse();
        //清空
        adtQueue.ClearQueue();
        //是否为空
        System.out.println(adtQueue.QueueEmpty());
        //销毁
        adtQueue.DestroyQueue();
    }
}
