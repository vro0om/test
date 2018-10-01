package collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCollection implements Runnable {

	private List<Test> list = new ArrayList<TestCollection.Test>();

	private Comparator<Test> comparator = new TestComparator();

	
	public static class TestComparator implements Comparator<Test> {

		@Override
		public int compare(Test o1, Test o2) {
			if (o1.getId() > o2.getId()) {
				return -1;
			} else if (o1.getId() < o2.getId()) {
				return 1;
			}
			return 0;
		}

	}

	public static class Test {
		private long id;

		public Test(long pid) {
			id = pid;
		}

		public long getId() {
			return id;
		}

		public String toString() {
			return "[" + getId() + " ]";
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final TestCollection tc = new TestCollection();

		for (Integer i = 130; i < 231; i++) {
			Thread.sleep(100);
			tc.list.add(new Test(System.currentTimeMillis()));
		}
		Thread t = new Thread(tc);
		t.start();
		t.join();
	}

	@Override
	public void run() {
		while (true) {
			try {			    
				Thread.sleep(1000);
				//System.out.println("Before: " + Runtime.getRuntime().freeMemory());
				//Collections.reverse(list);
				Collections.sort(list, comparator);
				 //System.out.println("sorted: " + list);
				//Thread.sleep(1000);
				System.out.println("After: " + Runtime.getRuntime().freeMemory());
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
}
