import java.util.Scanner;

public class Main {
    public static void main(String []args){
        int n,k;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        int []arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
        }
        int rec=0;
        int nget=0;
        for (int i = 0; i < n; i++) {
            if(nget==0) {
                rec++;
            }
            nget+=arr[i];
            if(nget>=k){
                nget=0;
            }
        }
        System.out.println(rec);
    }
}
