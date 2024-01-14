import java.util.Scanner;

public class Main {
    static int [][]arr=new int[15][10];
    static int [][]str=new int[4][4];
    static int [][]brr=new int[15][4];
    static int position=Integer.MAX_VALUE;
    static public int judge(int x,int y){
        int a=15;
        for (int i = 0; i < 15; i++) {
            if(brr[i][y]==1){
                a=i;
                break;
            }
        }
        return a-1+Math.abs(3-x);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j]= scanner.nextInt();
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                str[i][j]= scanner.nextInt();
            }
        }
        int a= scanner.nextInt();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                brr[i][j]=arr[i][a-1+j];
            }
        }
        for (int i = 3; i >=0 ; i--) {
            for (int j = 0; j < 4; j++) {
                if(str[i][j]==1){
                    int b=Main.judge(i,j);
                    position= Math.min(position, b);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(str[i][j]==1){
                    brr[position-Math.abs(3-i)][j]=str[i][j];
                }
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][a-1+j]=brr[i][j];
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
