import java.util.Scanner;

public class Main {
    static public int SumZero(int [][]arr){
        int rec=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j]==0){
                    rec++;
                }
            }
        }
        return rec;
    }

    static public int judge(int [][]arr){
        for (int i = 0; i < 3; i++) {
            if((arr[i][0]==arr[i][1])&&(arr[i][0]==arr[i][2])){
                if(arr[i][0]==1){
                    return SumZero(arr)+1;
                }
                if(arr[i][0]==2){
                    return -(SumZero(arr)+1);
                }
            }
            if((arr[0][i]==arr[1][i])&&(arr[0][i]==arr[2][i])){
                if(arr[0][i]==1){
                    return SumZero(arr)+1;
                }
                if(arr[0][i]==2){
                    return -(SumZero(arr)+1);
                }
            }
        }
        if(((arr[0][0]==arr[1][1])&&(arr[0][0]==arr[2][2]))
                ||((arr[0][2]==arr[1][1])&&(arr[0][2]==arr[2][0]))){
            if(arr[1][1]==1){
                return SumZero(arr)+1;
            }
            if(arr[1][1]==2){
                return -(SumZero(arr)+1);
            }
        }
        return 0;
    }

    static public int SecondJudge(int [][]arr){
        int a=judge(arr);
        if(a!=0){
            return a;
        }
        int wuyiyi=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j]==0){
                    wuyiyi++;
                }
            }
        }
        if(wuyiyi==9)return 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j]==0){
                    int [][]brr=new int[3][3];
                    for (int k = 0; k < 3; k++) {
                        System.arraycopy(arr[k],0,brr[k],0,3);
                    }
                    brr[i][j]=1;
                    int b=judge(brr);
                    if(b!=0){
                        return b;
                    }
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(brr[k][l]==0){
                                int [][]crr=new int[3][3];
                                for (int p = 0; p < 3; p++) {
                                    System.arraycopy(brr[p],0,crr[p],0,3);
                                }
                                crr[k][l]=2;
                                int c=SecondJudge(crr);
                                if(SecondJudge(crr)!=0){
                                    return c;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int t;
        Scanner scanner=new Scanner(System.in);
        t=scanner.nextInt();
        int [][]arr=new int[3][3];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k]= scanner.nextInt();
                }
            }
            System.out.println(Main.SecondJudge(arr));
        }
    }
}
