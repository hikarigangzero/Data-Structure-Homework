import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    static int pre[];

    static boolean isLinked(int a, int b) {
        int xx = find(a);
        int yy = find(b);
        if (xx == yy) {
            return true;
        } else {
            return false;
        }
    }

    static void Link(int a, int b) {
        int xx = find(a);
        int yy = find(b);
        if (xx > yy) {
            pre[xx] = yy;
        } else {
            pre[yy] = xx;
        }
    }

    static int find(int x) {
        if (x == pre[x]) {
            return x;
        } else {
            return find(pre[x]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        pre = new int[n + 1];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }
        PriorityQueue<Canal> queue = new PriorityQueue<Canal>();
        for (int i = 0; i < m; i++) {
            queue.add(new Canal(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int result = 0;
        while (!queue.isEmpty()) {
            Canal c = queue.poll();
            if (!isLinked(c.start, c.end)) {
                Link(c.start, c.end);
                result += c.price;
            }
        }
        System.out.println(result);
    }
}

class Canal implements Comparable<Canal> {// 水渠
    int start;
    int end;
    int price;

    public Canal(int start, int end, int price) {
        super();
        this.start = start;
        this.end = end;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Canal [start=" + start + ", end=" + end + ", price=" + price + "]";
    }

    @Override
    public int compareTo(Canal o) {
        // TODO Auto-generated method stub
        return price - o.price;
    }
}
