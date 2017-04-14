package com.gmail.s12348.evgen;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[200000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		SumThreadArray sumThread = new SumThreadArray(array);
		long begin = System.currentTimeMillis();
		System.out.printf("%,d",sumThread.sumArray());
		long end = System.currentTimeMillis();
		System.out.println("\n"+(end - begin) + " ms in multithreaded mode");
		begin = System.currentTimeMillis();
		System.out.printf("%,d",GreateArray.sumArray(array));
		end = System.currentTimeMillis();
		System.out.println("\n"+(end - begin) + " ms in single-threaded mode");
	}

}
