import java.util.*;

class Order{
    public void Merge(int a[],int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        Merge(a,low,mid);
        Merge(a,mid+1,high);
        Sort(a,low,mid,high);
    }
    public void Sort(int a[],int low,int mid,int high){
        int i=low;int h=low;int j=mid+1;
        int b[]=new int[high+1];
        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                b[h]=a[i];
                h++;
                i++;
            }
            else{
                b[h]=a[j];
                h++;
                j++;
            }
        }
        if(i>mid){
            for(int k=j;k<=high;k++){
                b[h]=a[k];
                h++;
            }
        }
        if(j>high){
            for(int k=i;k<=mid;k++){
                b[h]=a[k];
                h++;
            }
        }

        for(int k=low;k<=high;k++){
            a[k]=b[k];
        }
    }
}

public class MSort{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Order od=new Order();

        System.out.println("Enter the no.of elements :");
        int n=sc.nextInt();

        System.out.println("Enter the elements :");
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int low=0;
        int high=n-1;

        od.Merge(a,low,high);

        System.out.println("Sorted Array :");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }
}

// divide and conquer

// Enter the no.of elements:
// 5
// Enter the elements:
// 12 90 78 34 56
// Sorted Array :
// 12      34      56      78      90

//O(nlogn)