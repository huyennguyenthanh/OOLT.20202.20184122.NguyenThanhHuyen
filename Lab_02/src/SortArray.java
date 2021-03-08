import java.util.Scanner;
public class SortArray {
	static void printArray(int a[], int n)
	{
		System.out.print("Array : ");
		for (int i = 0; i < n; i++)
			System.out.print(" " + a[i]);
		System.out.println("");
	}
	static void SelectionSort(int a[], int n)
	{
		for(int i = 0; i < n; i++)
		{
			int min = 999999999;
			int min_id = i;
			for(int j = i ; j < n; j++)
			{
				if (a[j] < min) {
					min = a[j];
					min_id = j;
				}	
			}
			int tmp = a[i];
			a[i] = a[min_id];
			a[min_id] = tmp;
			//printArray(a,n);
		}		
	}
	static void swap(int a[], int i)
	{
		int tmp = a[i];
		a[i] = a[i+1];
		a[i+1] = tmp;
	}
	static void BubbleSort(int a[], int n)
	{
		int num_swap;
		do {
			num_swap = 0;
			for (int i = 0; i < n-1; i++)
			{
				if (a[i] > a[i+1])
				{
					swap(a,i);
					num_swap += 1;
				}
			}
		}while(num_swap != 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input length of array : ");
		int n = Integer.parseInt(sc.nextLine());
		
		System.out.println("Input array : ");
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.nextLine());
			sum += a[i];
		}
		printArray(a, n);
		
		
		SelectionSort(a, n);
		//BubbleSort(a, n);
		System.out.println("Sorted array : ");
		printArray(a, n);
		
		
		System.out.println("\nSum of array : " + sum);
		System.out.println("Average of array : " + (double) sum/n);
		
		
		
	}

}
