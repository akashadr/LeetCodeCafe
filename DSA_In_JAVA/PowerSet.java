package Arrays;

import java.util.*;

public class PowerSet {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		List<List<Integer>>aList=powerset(arr);
		for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.get(i).size(); j++) {
                System.out.print(aList.get(i).get(j) + " ");
            }
            System.out.println();
		}

	}

	private static List<List<Integer>> powerset(int[] arr) {
		List<List<Integer>>ans=new ArrayList<>();
		// Number of subset of n elements is given by 2^n
		for(int num=0;num<(1<<arr.length);num++) {
			List<Integer>subset=new ArrayList<>();
			for(int j=0;j<arr.length;j++) {
				if((num & (1 << j))!=0) {
					subset.add(arr[j]);
				}
			}
			ans.add(subset);
		}
		return ans;
	}

}
