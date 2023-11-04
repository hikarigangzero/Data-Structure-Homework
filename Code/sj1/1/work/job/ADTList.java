package job;

public class ADTList<T> {

    //节点内部类
    public class Node{
        T data;
        Node next;
    }

    //链表的相关信息
    private Node head;
    private Node tail;
    private Node pnow;
    private int length;

    //用构造方法，初始化链表
    ADTList(){
        this.head=new Node();
        this.head.next=null;
        this.tail=this.head;
        this.pnow=this.head;
        this.length=0;
    }

    //创建链表
    public void Create(T a){
        Node newNode=new Node();
        this.pnow=this.head;
        for (int i = 0; i < this.length; i++) {
            this.pnow=this.pnow.next;
        }
        this.pnow.next=newNode;
        this.pnow=this.pnow.next;
        this.pnow.data=a;
        this.tail=this.pnow;
        this.length++;
    }

    //销毁链表
    public void DestroyList(){
        this.head=null;
        this.tail=null;
        this.pnow=null;
        this.length=0;
    }

    //清空线性表
    public void ClearList(){
        this.head.next=null;
        this.tail=this.head;
        this.pnow=this.head;
        this.length=0;
    }

    //判断链表是否为空
    public boolean ListEmpty(){
        return this.head.next == null;
    }

    //得到线性表的元素个数
    public int ListLength(){
        return this.length;
    }

    //返回第i个元素
    public T GetElem(int i){
        if((i<1)||(i>this.length)){
            System.out.println("error");
            return null;
        }
        this.pnow=this.head;
        for (int j = 0; j < i; j++) {
            this.pnow=this.pnow.next;
        }
        return pnow.data;
    }

    //查找与提供的元素相同的元素的位置
    public int LocateElem(T e){
        this.pnow=this.head;
        for (int i = 0; i < this.length; i++) {
            this.pnow=this.pnow.next;
            if(this.pnow.data==e){
                return i+1;
            }
        }
        return 0;
    }

    //返回给定元素前面的元素
    public T PriorElem(T cur_e){
        this.pnow=this.head;
        Node node;
        for (int i = 0; i < this.length; i++) {
            node=this.pnow;
            this.pnow=this.pnow.next;
            if(this.pnow.data==cur_e){
                if(i==0){
                    return null;
                }
                return node.data;
            }
        }
        return null;
    }

    //返回给定元素后面的元素
    public T NextElem(T cur_e){
        this.pnow=this.head;
        for (int i = 0; i < this.length; i++) {
            this.pnow=this.pnow.next;
            if(this.pnow.data==cur_e){
                if(this.pnow.next.data==null){
                    return null;
                }
                return this.pnow.next.data;
            }
        }
        return null;
    }

    //遍历输出
    public void ListTraverse(){
        this.pnow=this.head;
        for (int i = 0; i < this.length; i++) {
            this.pnow=this.pnow.next;
            System.out.println(this.pnow.data);
        }
    }

    //替换并返回旧值
    public T SetElem(int i, T e){
        if((i<1)||(i>this.length)){
            System.out.println("error");
            return null;
        }
        this.pnow=this.head;
        for (int j = 0; j < i; j++) {
            this.pnow=this.pnow.next;
        }
        T a=e;
        this.pnow.data=e;
        return a;
    }

    //插入其余后移，长度增
    public void InsertElem(int i, T e){
        this.pnow=this.head;
        for (int j = 0; j < i-1; j++) {
            this.pnow=this.pnow.next;
        }
        Node newNode=new Node();
        newNode.data=e;
        if(i==this.length+1){
            this.pnow.next=newNode;
            this.tail=newNode;
            length++;
            return;
        }
        newNode.next=pnow.next;
        pnow.next=newNode;
        this.length++;
    }

    public T DeleteElem(int i){
        this.pnow=this.head;
        for (int j = 0; j < i-1; j++) {
            this.pnow=this.pnow.next;
        }
        T e=this.pnow.next.data;
        this.pnow.next=this.pnow.next.next;
        this.length--;
        return e;
    }


    public static void main(String []args){
        //使用构造方法初始化链表
        ADTList<Integer> adtList=new ADTList<>();
        //验证创造链表
        for (int i = 1; i <= 3; i++) {
            adtList.Create(i);
        }
        //验证遍历链表
        adtList.ListTraverse();
        //验证清空链表和是否为空
        adtList.ClearList();
        System.out.println(adtList.ListEmpty());
        //再次创建
        for (int i = 1; i <= 3; i++) {
            adtList.Create(i);
        }
        //返回元素个数
        System.out.println(adtList.ListLength());
        //验证替换元素
        adtList.SetElem(2,4);
        adtList.ListTraverse();
        System.out.println("----------分割线----------");
        //验证插入
        adtList.InsertElem(2,9);
        adtList.ListTraverse();
        System.out.println("----------分割线----------");
        //验证删除并返回删除的元素
        System.out.println(adtList.DeleteElem(3));
        System.out.println("----------分割线----------");
        adtList.ListTraverse();
        System.out.println("----------分割线----------");
        //返回第i个元素
        System.out.println(adtList.GetElem(2));
        System.out.println("----------分割线----------");
        //返回第i个元素前一个和后一个
        System.out.println(adtList.PriorElem(9));
        System.out.println(adtList.NextElem(9));
        System.out.println("----------分割线----------");
        //判断是否有此元素的位置，否则返回0
        System.out.println(adtList.LocateElem(100));
        System.out.println(adtList.LocateElem(3));
        System.out.println("----------全部验证完毕----------");
    }
}
