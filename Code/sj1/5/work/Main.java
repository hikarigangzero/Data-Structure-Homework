import java.util.Scanner;

public class Main {
    public static void main(String []args){
        int []arr=new int[50];
        Scanner scanner=new Scanner(System.in);
        int n=0;
        while (scanner.hasNextInt()){
            arr[n]=scanner.nextInt();
            if(arr[n]==0){
                break;
            }
            n++;
        }
        int a=0;
        int f=1;
        for (int i = 0; i < n; i++) {
            if(i==0){
                if(arr[i]==1){
                    a+=1;
                    f=1;
                } else if (arr[i]==2) {
                    a+=2;
                    f++;
                } else if (arr[i]==0) {
                    break;
                }
            }
            else{
                if(arr[i]==1){
                    a+=1;
                    f=1;
                } else if (arr[i]==2) {
                    if(arr[i-1]==1){
                        a+=2*f;
                        f++;
                    }
                    else{
                        a+=f*2;
                        f++;
                    }
                }else {
                    break;
                }
            }
        }
        System.out.println(a);
    }
}
