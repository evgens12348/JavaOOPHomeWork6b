package com.gmail.s12348.evgen;

public class SumThreadArray {
	private int threadNum = Runtime.getRuntime().availableProcessors();
	private Thread[] threadArray;
	private int[] array;
	private GreateArray[] testArray;

	public SumThreadArray(int[] array) {
		super();
		this.array = array;
		this.threadArray = new Thread[this.threadNum];
		testArray = new GreateArray[this.threadNum];
	}

	public int sumArray() {
		int sum = 0;
		int partArray = array.length / threadArray.length;
		for (int i = 0; i < threadArray.length; i++) {
			int begin = partArray * i;
			int end = partArray * (i + 1);
			if ((array.length - end) < partArray) {
				end = array.length;
			}
			testArray[i] = new GreateArray(array, begin, end);
			threadArray[i] = new Thread(testArray[i]);
			threadArray[i].start();
		}
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < testArray.length; i++) {
			sum += testArray[i].getSum();
		}
		return sum;
	}

}
