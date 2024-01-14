import java.util.Scanner;

public class Main {
    public static boolean I(int n,int a,int b,int [][]arr){
        for (int i = 0; i < n; i++) {
            if(arr[a][b]>arr[a][i]){
                return false;
            }
        }
        return true;
    }

    public static boolean J(int m,int a,int b,int [][]arr){
        for (int i = 0; i < m; i++) {
            if(arr[a][b]<arr[i][b]){
                return false;
            }
        }
        return true;
    }

    public static void main(String []args){
        int m,n;
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        int [][]arr=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(I(n,i,j,arr)&&J(m,i,j,arr)){
                    System.out.println("马鞍点为"+(i+1)+"行"+(j+1)+"列的点");
                }
            }
        }
    }
}
