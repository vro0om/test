package autoast;

import java.util.ArrayList;
import java.util.List;

import ds.Child;
import ds.Father;

public class CastAuto {

	List<Father> fa = new ArrayList<>();
	List<Child> ch = new ArrayList<>();

	private void Cast() throws InterruptedException {
		System.out.println("cast");
		for (int i = 0; i < 10000; i++) {
			Child c = new Child();

			fa.add(c);
		}

		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println(freeMemory);
		for (int i = 0; i < 10000; i++) {
			Child c = (Child) fa.get(i);
		}
		Thread.sleep(1000);
		System.out.println(freeMemory-Runtime.getRuntime().freeMemory());
	}

	private void noCast() throws InterruptedException {
		System.out.println("noCast");
		for (int i = 0; i < 10000; i++) {
			Child c = new Child();

			ch.add(c);
		}

		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println(freeMemory);
		for (int i = 0; i < 10000; i++) {
			Child c = ch.get(i);
		}
		Thread.sleep(1000);
		System.out.println(freeMemory - Runtime.getRuntime().freeMemory());
	}
public static void main(String[] args) {
	CastAuto castAuto = new CastAuto();
	try{
	castAuto.Cast();
	castAuto.noCast();}
	catch(Exception e){}
}
}
