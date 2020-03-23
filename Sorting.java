

public class Sorting {
	private static int partition(int[] a, int l, int r) {
		int i = l, j = r + 1;
		while (true) {
			while (a[++i] < a[l])
				if (i == r)
					break;
			while (a[l] < a[--j])
				if (j == l)
					break;
			if (i >= j)
				break;
			a[i] += a[j];
			a[j] = a[i] - a[j];
			a[i] -= a[j];
		}
		if (l != j) {
			a[l] += a[j];
			a[j] = a[l] - a[j];
			a[l] -= a[j];
		}
		return j;
	}
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}
	private static void quickSort(int [] a, int l, int r) {
		if (r <= l)
			return;
		int j = partition(a, l, r);
		quickSort(a, l, j - 1);
		quickSort(a, j + 1, r);
	}
	public static void radixSort(int[] a, int l) {
		int n = a.length;
		int aux[] = new int[n];
		int powerOfTen = 1;
		for (int j = l; j > 0; j--) {
			int[] count = new int[11];
			for (int i = 0; i < n; i++) 
				count[a[i] / powerOfTen % 10 + 1]++;
			for (int i = 0; i < 10; i++)
				count[i + 1] += count[i];
			for (int i = 0; i < n; i++)
				aux[count[a[i] / powerOfTen % 10]++] = a[i];
			for (int i = 0; i < n; i++)
				a[i] = aux[i];
			powerOfTen *= 10;
		}
	}
}
