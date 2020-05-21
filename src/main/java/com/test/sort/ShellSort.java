package com.test.sort;

/**
 * 希尔排序
 * @author 
 * @date 2020年5月11日
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] array = {2,1,4,5};
		int len = array.length;
		int gap = len / 2;
		while(gap > 0) {
			for(int j = gap; j < len ; j ++) {
				int i = j;
				while (i >= gap && array[i -gap] > array[i]) {
					int temp = array[i-gap] + array[i];
					array[i - gap] = temp - array[i -gap];
					array[i] = temp - array[i-gap];
					i -= gap;
				}
			}
			gap /= 2;
		}
		for (int i : array) {
			System.out.print(i);
		}
	}
}
