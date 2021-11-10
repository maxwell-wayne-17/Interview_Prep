package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrays {
	
	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		final int m = one.length;
		final int n = two.length;
		int [] merged = new int[m + n];
		int p1 = 0;
		int p2 = 0;
		while (p1 < m || p2 < n) {
			// Three cases with pointers: both not done, one not done, two not done
			// Both not done
			if (p1 < m && p2 < n) {
				if (one[p1] <= two[p2]) {
					merged[p1+p2] = one[p1];
					p1++;
				}
				else {
					merged[p1+p2] = two[p2];
					p2++;
				}
			}
			// One done, two not done
			else if (p1 == m && p2 < n) {
				merged[p1+p2] = two[p2];
				p2++;
			}
			// One not done, two done
			else {
				merged[p1+p2] = one[p1];
				p1++;
			}
		}
		return merged;
	}
	
	// Get max and min sums of n-1 elements from arr of size n
	 public static void miniMaxSum(List<Integer> arr) {
		    // Write your code here
		        // Find min and max
		        // Calculate one sum excluding min, calculate another sum excluding max
		        int[] min = {Integer.MAX_VALUE, -1};
		        int[] max = {Integer.MIN_VALUE, -1};
		        for (int i = 0; i < arr.size(); i++){
		            int num = arr.get(i);
		            if (min[0] > num){
		                min[0] = num;
		                min[1] = i;
		            }
		            if (max[0] < num){
		                max[0] = num;
		                max[1] = i;
		            }
		        }
		        
		        // Get both sums
		        long minSum = 0;
		        long maxSum = 0;
		        for (int i = 0; i < arr.size(); i++){
		            int num = arr.get(i);
		            if(num != min[0] || i != min[1]){
		                maxSum += num;
		            }
		            if(num != max[0] || i != max[1]){
		                minSum += num;
		            }
		        }
		        System.out.println(String.format("%d %d", minSum, maxSum));
		    }
	 
	 // Complete binary search on given sorted array
	 // If it can't find element, it will return closest int to it (I think)
	 public static int binarySearch(int[] arr, int target) {
		 // Just in case
		 Arrays.sort(arr);
		 
		 int lo = 0;
		 int hi = arr.length - 1;
		 int mid = lo + (hi - lo)/2;
		 while (lo <= hi) {
			 mid = lo + (hi - lo)/2;
			 if(arr[mid] == target) {
				 return target;
			 }
			 else if (arr[mid] < target) {
				 lo = mid + 1;
			 }
			 else {
				 hi = mid;
			 } 
		 }
		 return arr[mid];
	 }

	public static void main(String[] args) {
		
		System.out.println("Binary Search test");
		int[] search1 = {1,3,4,5,7,8,9};
		for (int num : search1) {
			System.out.print(num + " ");
		}
		int actual = binarySearch(search1, 9);
		System.out.println("\n" + "Target: 9 Actual: " + actual );
		
		int[] search2 = {1,4,7,11,15,20};
		for (int num : search2) {
			System.out.print(num + " ");
		}
		actual = binarySearch(search2, 20);
		System.out.println("\n" + "Target: 20 Actual: " + actual );

	}

}
