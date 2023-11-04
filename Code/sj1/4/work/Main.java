import java.util.Scanner;

class Times{
    int zt=0;
    int lt=0;
}

public class Main {
    public static void main(String []args){
        int r,y,g;
        int n;
        Scanner scanner=new Scanner(System.in);
        r=scanner.nextInt();
        y=scanner.nextInt();
        g=scanner.nextInt();
        n=scanner.nextInt();
        Times []times=new Times[n];
        for (int i = 0; i < n; i++) {
            times[i]=new Times();
            times[i].zt=scanner.nextInt();
            times[i].lt=scanner.nextInt();
        }
        long t=0;
        for (int i = 0; i < n; i++) {
            if(times[i].zt==0){
                t+=times[i].lt;
            }
            else{
                if(times[i].zt==2){
                    int a=(int)t%(r+y+g);
                    if(a<=r+times[i].lt){
                        t+=(r+times[i].lt-a);
                    } else if (a>=r+times[i].lt+g) {
                        t+=(r+y+g-a+times[i].lt+r);
                    }
                } else if (times[i].zt==1) {
                    int a=(int)t%(r+y+g);
                    if(a<=times[i].lt){
                        t+=(times[i].lt-a);
                    } else if (a>=(g+times[i].lt)) {
                        t+=(r+y+g-a+times[i].lt);
                    }
                } else if (times[i].zt==3) {
                    int a=(int)t%(r+y+g);
                    if((a>=times[i].lt)&&(a<=r+y+times[i].lt)){
                        t+=r+y-a+times[i].lt;
                    }
                }
            }
        }
        System.out.println(t);
    }
}
