import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sort {
    public void ChangeSort(int[]arr,int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(arr[j]>arr[j+1]){
                    int a=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=a;
                }
            }
        }
    }

    public void ChoiceSort(int[]arr,int n){
        for (int i = 0; i < n; i++) {
            int min=i;
            for (int j = i; j < n; j++) {
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int a=arr[i];
            arr[i]=arr[min];
            arr[min]=a;
        }
    }

    public void MergeSort(int[]arr,int high,int low,int mid){
        int[]temp=new int[high+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=high){
            temp[k++]=arr[j++];
        }
        for (k=0,i=low; i <= high; i++,k++) {
            arr[i]=temp[k];
        }
    }

    public void MSort(int []arr,int n){
        for (int lin = 1; lin <= n; lin*=2) {
            int i=0;
            while(i+2*lin-1<n){
                MergeSort(arr,i+2*lin-1,i,i+lin-1);
                i+=2*lin;
            }
            if(i+lin<n){
                MergeSort(arr,n-1,i,i+lin-1);
            }
        }
    }

    static int n=0;

    public static void main(String[] args) {
        Sort sort=new Sort();
        File file=new File("SortMeasure.txt");
        Scanner scanner=null;
        int []arr=null;
        arr=new int[10000];
        try {
            scanner=new Scanner(file);
            while(scanner.hasNextInt()){
                arr[n]=scanner.nextInt();
                n++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        //sort.ChangeSort(arr,n);
        //sort.ChoiceSort(arr,n);
        sort.MSort(arr,n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
