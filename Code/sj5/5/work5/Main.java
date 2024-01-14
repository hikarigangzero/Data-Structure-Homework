import java.util.Scanner;

public class Main {
    public boolean judge(int j){
        int ge=j%10;
        int shi=(j/10)%10;
        int bai=((j/10)/10)%10;
        int ta=j%7;
        if((ge!=7)&&(shi!=7)&&(bai!=7)&&ta!=0)return true;
        else return false;
    }
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        n= scanner.nextInt();
        int []arr=new int[4];
        Main main=new Main();
        for (int i = 0, j = 1; i < n;) {
            if(j%4==1){
                if(main.judge(j)){
                    i++;
                    j++;
                    continue;
                }
                else{
                    j++;
                    arr[0]++;
                    continue;
                }
            }
            if(j%4==2){
                if(main.judge(j)){
                    i++;
                    j++;
                    continue;
                }
                else{
                    j++;
                    arr[1]++;
                    continue;
                }
            }
            if(j%4==3){
                if(main.judge(j)){
                    i++;
                    j++;
                    continue;
                }
                else{
                    j++;
                    arr[2]++;
                    continue;
                }
            }
            if(j%4==0){
                if(main.judge(j)){
                    i++;
                    j++;
                }
                else{
                    j++;
                    arr[3]++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(arr[i]);
        }
    }
}
