import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class Testing {
	
	@Test
	public void test() {
		Random rgen = new Random();
		int[] a = new int[1000000];
		int[] b = new int[1000000];
		for (int i = 0; i < 1000000; i++)
			a[i] = b[i] = rgen.nextInt(1000000);
		Sorting.quickSort(a);
		Sorting.radixSort(b, 6);
		for (int i = 0; i < 1000000; i++)
			assertEquals(a[i], b[i]);
	}

}
