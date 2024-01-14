import java.util.Scanner;

public class Main {
    static int n,k,t,xl,yd,xr,yu;
    static class Position{
        int x;
        int y;
        boolean stop=false;
        int visit=0;

        public boolean Visit(){
            if((x>=xl)&&(x<=xr)&&(y>=yd)&&(y<=yu)){
                return true;
            }
            return false;
        }

        public int Change1(int c){
            if(Visit()){
                visit++;
                c++;
            }
            else{
                c=0;
            }
            return c;
        }

        public void Change2(int c){
            if(c>=k){
                stop=true;
            }
        }
    }

    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        t=scanner.nextInt();
        xl=scanner.nextInt();
        yd=scanner.nextInt();
        xr=scanner.nextInt();
        yu=scanner.nextInt();
        Position []position=new Position[n];
        int a=0;
        int b=0;
        for (int i = 0; i < n; i++) {
            position[i]=new Position();
            int c=0;
            for (int j = 0; j < t; j++) {
                position[i].x=scanner.nextInt();
                position[i].y=scanner.nextInt();
                c=position[i].Change1(c);
                position[i].Change2(c);
            }
        }
        for (int i = 0; i < n; i++) {
            if(position[i].visit>0){
                a++;
            }
            if(position[i].stop){
                b++;
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}
