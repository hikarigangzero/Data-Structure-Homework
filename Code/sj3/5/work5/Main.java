import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int []arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextInt();
        }
        int c=Math.abs(arr[0]-arr[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    int abs=Math.abs(arr[i]-arr[j]);
                    if(abs<c){
                        c=abs;
                    }
                }
            }
        }
        System.out.println(c);
    }
}
