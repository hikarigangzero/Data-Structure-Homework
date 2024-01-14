import java.util.Scanner;

public class Main {
    public static int Judge(boolean [][]str,int a){
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 5; j++) {
                if((!str[i][j])&&((Math.abs(j-5)+1)>=a)){
                    for (int k = j; k < j+a; k++) {
                        if(str[i][k])break;
                        if(k==(j+a-1)){
                            return (i-1)*5+j;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int []arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextInt();
        }

        boolean [][]str=new boolean[21][6];
        for (int i = 0; i < n; i++) {
            int a=Judge(str,arr[i]);
            if(a==-1){
                int e=0;
                for (int j = 1; j <= 20; j++) {
                    for (int k = 1; k <= 5; k++) {
                        if(!str[j][k]){
                            System.out.print(((j-1)*5+k)+" ");
                            str[j][k]=true;
                            e++;
                        }
                        if(e==arr[i])break;
                    }
                    if(e==arr[i])break;
                }
                System.out.println();
            }
            else {
                for (int j = 0; j < arr[i]; j++) {
                    System.out.print((a+j)+" ");
                    int b=a%5+j;
                    if(b==0){
                        b=5;
                    }
                    if(a%5==0){
                        a-=1;
                    }
                    str[(a/5)+1][b]=true;
                }
                System.out.println();
            }
        }
    }
}
