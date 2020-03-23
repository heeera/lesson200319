import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class Testing {
	
	private static final int N = 1000000;
	private static final int R = 6;
	@Test
	public void test() {
		
		int powerOfTen = 1;
		for (int i = 0; i < R; i++)
			powerOfTen *= 10;
		
		Random rgen = new Random();
		int[] a = new int[N];
		int[] b = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = b[i] = rgen.nextInt(powerOfTen);
		
		long start = System.currentTimeMillis();
		Sorting.quickSort(a);
		long end = System.currentTimeMillis();
		System.out.println("Quick: " + (end - start));
		
		start = System.currentTimeMillis();
		Sorting.radixSort(b, R);
		end = System.currentTimeMillis();
		System.out.println("Radix: " + (end - start));
		
		for (int i = 0; i < N; i++)
			assertEquals(a[i], b[i]);
	}

}


