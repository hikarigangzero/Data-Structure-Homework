class MyStack{
    class Position{
        int col;
        int row;
        boolean exist;
    }
    Position []pos=new Position[9];
    private int top;
    private int cout=1;
    public MyStack(){
        for (int i = 0; i < 9; i++) {
            pos[i]=new Position();
        }
    }

    public boolean Adjust(int row){
        for (int i = 1; i < row; i++) {
            if(pos[row].exist){
                if(pos[i].col==pos[row].col)return false;
                if(Math.abs(pos[i].col-pos[row].col)==Math.abs(pos[i].row-pos[row].row))return false;
            }
        }
        return true;
    }
    
    public void Push(int row){
        pos[row].exist=true;
        top++;
    }

    public void Pop(int row){
        pos[row].exist=false;
        top--;
    }

    public void Print(int cout){
        System.out.println("第"+cout+"个结果");
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if(pos[i].col==j){
                    System.out.print("o ");
                }
                else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("----------分割线----------");
        System.out.println();
    }

    public void Finals(int row){
        pos[row].row=row;
        for (int i = 1; i < 9; i++) {
            pos[row].col=i;
            Push(row);
            if(Adjust(row)){
                if(row<8){
                    Finals(row+1);
                }
                else{
                    Print(cout);
                    cout++;
                }
            }
            Pop(row);
        }
    }
}

public class Main {
    public static void main(String []args){
        MyStack myStack=new MyStack();
        myStack.Finals(1);
    }
}
