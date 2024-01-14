import java.util.Scanner;

public class Main {
    public int Judge(int []arrx,int []arry,int n,int x,int y){
        for (int i = 0; i < n; i++) {
            int a=0;
            for (int j = 0; j < n; j++) {
                if(arrx[j]==x+1&&arry[j]==y){
                    a++;
                }
                if(arrx[j]==x&&arry[j]==y+1){
                    a++;
                }
                if(arrx[j]==x-1&&arry[j]==y){
                    a++;
                }
                if(arrx[j]==x&&arry[j]==y-1){
                    a++;
                }
            }
            if(a==4){
                a=0;
                for (int j = 0; j < n; j++) {
                    if(arrx[j]==x+1&&arry[j]==y+1){
                        a++;
                    }
                    if(arrx[j]==x-1&&arry[j]==y+1){
                        a++;
                    }
                    if(arrx[j]==x-1&&arry[j]==y-1){
                        a++;
                    }
                    if(arrx[j]==x+1&&arry[j]==y-1){
                        a++;
                    }
                }
                return a;
            }
        }
        return 5;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int []arrx=new int[n];
        int []arry=new int[n];
        for (int i = 0; i < n; i++) {
            arrx[i]= scanner.nextInt();
            arry[i]= scanner.nextInt();
        }
        int []str=new int[5];
        for (int i = 0; i < n; i++) {
            int b=new Main().Judge(arrx,arry,n,arrx[i],arry[i]);
            if (b!=5) {
                str[b]++;
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(str[i]);
        }
    }
}
