package job;

import java.util.Optional;

class Arr<T>{
    private int MAXSIZE=256;
    private Object []arr;
    private  int length;
    private int size;

    public Arr() {
        this.arr = null;
        this.length = 1;
        this.size = 0;
    }

    public int getMAXSIZE() {
        return MAXSIZE;
    }

    public Object[] getArr() {
        return arr;
    }

    public int getLength() {
        return length-1;
    }

    public int getSize() {
        return size;
    }

    public void Create(Object a){
        if(this.size==0){
            arr=new Object[MAXSIZE];
            this.size=this.MAXSIZE;
        }
        else if(this.length-1 == this.size){
            this.MAXSIZE*=2;
            Object []na=new Object[MAXSIZE];
            System.arraycopy(arr, 0, na, 0, this.size);
            arr=na;
            this.size=this.MAXSIZE;
        }
        this.arr[this.length-1]=a;
        this.length++;
    }

    public void DestroyList(){
        this.arr=null;
        this.size=0;
        this.length=0;
    }

    public void ClearList(){
        for(int i=0;i<this.length-1;i++){
            this.arr[i]=null;
        }
        this.length=1;
    }

    public boolean ListEmpty(){
        return this.length == 1;
    }

    public int ListLength(){
        return this.getLength();
    }

    public Object GetElem(int a){
        return this.arr[a-1];
    }

    public Object LocateElem(T a){
        for (int i = 0; i < this.length-1; i++) {
            if(this.arr[i]==a){
                return this.arr[i];
            }
        }
        return 0;
    }

    public Object PriorElem(T a){
        for (int i = 0; i < this.length-1; i++) {
            if(this.arr[i]==a){
                if(i==0){
                    return null;
                }
                return arr[i-1];
            }
            if(i==this.length-2){
                return null;
            }
        }
        return null;
    }

    public Object NextElem(T a){
        for (int i = 0; i < this.length-1; i++) {
            if(i==this.length-2){
                return null;
            }
            if(this.arr[i]==a){
                return arr[i+1];
            }
        }
        return null;
    }

    public void ListTraverse(){
        /*for (Object o:
             this.arr) {
            System.out.print(o);
            System.out.print(" ");
        }
        System.out.println();*/
        for (int i = 0; i < this.length-1; i++) {
            if(this.length-2==i){
                System.out.println(arr[i]);
                return;
            }
            System.out.print(this.arr[i]);
            System.out.print(" ");
        }
        System.out.println("数组为空");
    }

    public Object SetElem(int a,T e){
        Object b=arr[a-1];
        this.arr[a-1]=e;
        return b;
    }

    public void InsertElem(int a,T e){
        for (int i = this.length-2; i >=a-1 ; i--) {
            if(this.length-1==this.size){
                this.Create(this.arr[i]);
            }
            this.arr[i+1]=this.arr[i];
        }
        this.arr[a-1]=e;
        this.length++;
    }

    public Object DeleteElem(int a){
        Object b=arr[a-1];
        for (int i = a; i < this.length-1; i++) {
            this.arr[i-1]=this.arr[i];
        }
        this.length--;
        return b;
    }
}

public class ADTShuzu {
    public static void main(String []args){
        //验证初始化和创建
        Arr<Integer> list=new Arr<Integer>();
        for (int i = 0; i < 15; i++) {
            list.Create(i);
        }

        //遍历查看结果
        list.ListTraverse();
        //清空
        list.ClearList();
        list.ListTraverse();
        //是否为空
        System.out.println(list.ListEmpty());
        //重写放入元素再返回元素个数
        for (int i = 0; i < 15; i++) {
            list.Create(i);
        }
        System.out.println(list.ListLength());
        //返回第i个
        System.out.println(list.GetElem(8));
        //返回前与后
        System.out.println(list.PriorElem(7)+" "+list.NextElem(7));
        //替换
        list.SetElem(6,520);
        list.ListTraverse();
        //插入
        list.InsertElem(6,1314);
        list.ListTraverse();
        //删除
        list.DeleteElem(6);
        list.DeleteElem(6);
        list.ListTraverse();
        System.out.println("----------全部测试完毕----------");
    }
}
