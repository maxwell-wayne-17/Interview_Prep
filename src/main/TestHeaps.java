package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestHeaps {
	
	public static PriorityQueue<Integer> makeMinHeap(){
		// Does not necessarily sort in order, but will pop in order
		return new PriorityQueue<Integer>();
	}
	
	public static PriorityQueue<Integer> makeMaxHeap(){
		// Does not necessarily sort in order, but will pop in order
		return new PriorityQueue<Integer>(Collections.reverseOrder());
	}
	
	// Comparator made for a tuple integer[] with a lambda function
	public static PriorityQueue<Integer[]> makeCustomHeap(){
		return new PriorityQueue<Integer[]>((tup1, tup2) -> 
		// This will sort in ASCENDING (minHeap for these tuples)
		Integer.compare(tup1[1], tup2[1]));
		// To make max heap, flip tup1 and tup2
	}
	
	// Comparator made for a tuple integer[] with a anonymous function for descending order and tie breakers
		public static PriorityQueue<Integer[]> makeCustomHeap2(){
			return new PriorityQueue<Integer[]>( new Comparator<Integer[]>() {
				
				// Compare second value in tuple, then first value if second value equal
				// -1 = o1 < o2, 0 = o1 == o2, 1 = o1 > o2
				// To sort in DESCENDING, return REVERSE numbers
				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					if (o1[1] > o2[1]) {
						return -1;
					}
					else if (o1[1] < o2[1]) {
						return 1;
					}
					else if (o1[0] > o2[0]) {
						return -1;
					}
					else if (o1[0] < o2[0]) {
						return 1;
					}
					else {
						return 0;
					}
				}
				
			});
		}

	public static void main(String[] args) {

		System.out.println("Min Heap");
		PriorityQueue<Integer> minHeap = makeMinHeap();
		minHeap.add(9999);
		minHeap.add(4);
		minHeap.add(8);
		minHeap.add(1);
		minHeap.add(3);
		minHeap.add(-5);
		// Will not print in order here
		System.out.println(minHeap);
		// But it will pop in order
		while (!minHeap.isEmpty()) {
			System.out.print(minHeap.poll() + " ");
		}
		System.out.println();
		
		System.out.println("Max Heap");
		PriorityQueue<Integer> maxHeap = makeMaxHeap();
		maxHeap.add(9999);
		maxHeap.add(4);
		maxHeap.add(8);
		maxHeap.add(1);
		maxHeap.add(3);
		maxHeap.add(-5);
		// Will not print in order here
		System.out.println(maxHeap);
		// But it will pop in order
		while (!maxHeap.isEmpty()) {
			System.out.print(maxHeap.poll() + " ");
		}
		System.out.println();
		
		System.out.println("Custom Min Heap");
		PriorityQueue<Integer[]> customHeap = makeCustomHeap();
		customHeap.add( new Integer[] {1, 9999} );
		customHeap.add( new Integer[] {2, 4} );
		customHeap.add( new Integer[] {3, 8} );
		customHeap.add( new Integer[] {4, 1} );
		customHeap.add( new Integer[] {5, 3} );
		customHeap.add( new Integer[] {6, -5} );
		// But it will pop in order
		while (!customHeap.isEmpty()) {
			System.out.print(customHeap.poll()[1] + " ");
		}
		System.out.println();
		
		System.out.println("Custom Min Heap");
		PriorityQueue<Integer[]> customHeap2 = makeCustomHeap2();
		customHeap2.add( new Integer[] {1, 9999} );
		customHeap2.add( new Integer[] {2, 4} );
		customHeap2.add( new Integer[] {3, 8} );
		customHeap2.add( new Integer[] {4, 1} );
		customHeap2.add( new Integer[] {5, 3} );
		customHeap2.add( new Integer[] {6, -5} );
		// The bottom one should come before the top one
		customHeap2.add( new Integer[] {7, -5} );
		// But it will pop in order
		while (!customHeap2.isEmpty()) {
			System.out.print(customHeap2.poll()[1] + " ");
		}
		System.out.println();
		
	}

}
