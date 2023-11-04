import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();
        int T=0;
        int D=0;
        int E=0;
        boolean []str=new boolean[n];
        for (int i = 0; i < n; i++) {
            int a=scanner.nextInt();
            int []arr=new int[a];
            int T1=0;
            int c=0;
            for (int j = 0; j < a; j++) {
                arr[j]=scanner.nextInt();
                if((arr[j]>0)&&(j!=0)){
                    if(arr[j]!=T1){
                        c++;
                    }
                }
                if(arr[j]>0){
                    T1=arr[j];
                } else if (arr[j]<=0) {
                    T1+=arr[j];
                }
            }
            T+=T1;
            if(c!=0){
                D++;
                str[i]=true;
            }
        }
        for (int i = 0; i < n; i++) {
            if(str[i%n]&&str[(i+1)%n]&&str[(i+2)%n]){
                E++;
            }
        }
        System.out.println(T+" "+D+" "+E);
    }
}
