import java.util.Scanner;

public class Main {
    public static void main(String []args){
        int n;
        Scanner scanner=new Scanner(System.in);
        n= scanner.nextInt();
        int [][]arr=new int[n][2];
        int [][]brr=new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0]= scanner.nextInt();
            arr[i][1]= scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            brr[i][0]= scanner.nextInt();
            brr[i][1]= scanner.nextInt();
        }
        int t=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if((arr[i][0]<=brr[j][0])&&(arr[i][1]>=brr[j][1])){
                    t+=(brr[j][1]-brr[j][0]);
                }
                else if((arr[i][0]<=brr[j][0])&&(arr[i][1]<brr[j][1])&&(arr[i][1]>=brr[j][0])){
                    t+=(arr[i][1]-brr[j][0]);
                }
                else if((brr[j][0]<arr[i][0])&&(brr[j][1]>=arr[i][1])){
                    t+=(arr[i][1]-arr[i][0]);
                }
                else if((brr[j][0]<arr[i][0])&&(brr[j][1]<arr[i][1])&&(brr[j][1]>=arr[i][0])){
                    t+=(brr[j][1]-arr[i][0]);
                }
            }
        }
        System.out.println(t);
    }
}
