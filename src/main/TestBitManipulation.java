package main;

public class TestBitManipulation {
	
	// Sets the ith bit to 1
	public static int setBit(int num, int i) {
		// will ensure the ith bit is or'd with a 1 to set it to a 1
		return num | (1 << i);
	}
	
	// Clears the ith bit to 0
	public static int clearBit(int num, int i) {
		// Give us a number like 00010000 then negates it to 11101111, with 0 at bit i
		int mask = ~(1 << i);
		// bitwise & will keep all bits the same except the 0 bit at bit i
		return num & mask;
	}
	
	// Clears all bits from the msb to ith bit to 0
	public static int clearBitsMSBthroughI(int num, int i) {
		// Create a mask with 1 at the ith bit
		// Subtract 1 from it to give a sequence of 0s followed by i ones
		int mask = (1 << i) - 1;
		// & number to just leave the bits after i the same (since all those bits & with 1)
		return num & mask;
	}
	
	// Clears all bits from ith bit to 0th bit to 0
	public static int clearBitsIthrough0(int num, int i) {
		// Take a sequence of all 1's (which is -1) and shift it left by i + 1 bits
		// This gives a sequence of ones in the MSBs followed by i + 1 zeros
		int mask = (-1 << (i + 1));
		return num & mask;
	}
	
	// Sets the ith bit to value v based on bitIs1
	public static int updateBit(int num, int i, boolean bitIs1) {
		// Clear bit at position i using a mask that looks like 11101111
		// Then shift the value v left by i bits
		// This creates a number with bit i equal to v and all other its equal to 0
		// Finally, OR the two numbers, updating the ith bit if v is 1 and leaving it as 0 otherwise
		int value = bitIs1 ? 1 : 0;
		int mask = ~(1 << i);
		return (num & mask) | (value << i);
		
	}
	
	// Array contains numbers where all are duplicates except one number
	// This finds unqiue number by XOR equals starting with 0. This works because x ^ x = 0, so if a number was already added, xoring the same numbers will eventually cancel out
	// Just think -> (x + y) ^ (x + y) = 0, will work for when the sum of all other numbers comes back around
	public static int lonelyInt(int[] arr) {
		int result = 0;
		for (int num : arr) {
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		int ones = 0b11111111;
		int zeros = 0b00000000;
		
		System.out.println("Set bit");
		int testOnes = setBit(ones, 4);
		int testZeros = setBit(zeros, 3);
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testOnes) ).replace(' ', '0'));
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testZeros) ).replace(' ', '0') + "\n");
		
		System.out.println("Clear bit");
		testOnes = clearBit(ones, 4);
		testZeros = clearBit(zeros, 4);
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testOnes) ).replace(' ', '0'));
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testZeros) ).replace(' ', '0') + "\n");
		
		System.out.println("clear bits MSB through 4");
		testOnes = clearBitsMSBthroughI(ones, 4);
		testZeros = clearBitsMSBthroughI(zeros, 4);
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testOnes) ).replace(' ', '0'));
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testZeros) ).replace(' ', '0') + "\n");
		
		System.out.println("clear bits 4 through 0");
		testOnes = clearBitsIthrough0(ones, 4);
		testZeros = clearBitsIthrough0(zeros, 4);
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testOnes) ).replace(' ', '0'));
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testZeros) ).replace(' ', '0') + "\n");
		
		System.out.println("Update bit 4 (invert)");
		testOnes = updateBit(ones, 4, false);
		testZeros = updateBit(zeros, 4, true);
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testOnes) ).replace(' ', '0'));
		System.out.println(String.format("%1$8s", Integer.toBinaryString(testZeros) ).replace(' ', '0') + "\n");
		
		System.out.println("Find lonely int");
		int[] test = {1,4,2,3,3,2,1};
		for (int num : test) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println(lonelyInt(test));
		
		

	}

}
