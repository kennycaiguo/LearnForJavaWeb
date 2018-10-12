package cn.zzc.排序;

import java.util.ArrayList;
import java.util.TreeMap;

public class Test2 {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 2, 1, 3, 2, 1, 2, 1, 8 };

		// 进行排序
		//Arrays.sort(arr);
		/*for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}*/
		
		//将数组存入集合list
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> ha = new TreeMap<Integer, Integer>();
		//将list中数据存入map同时去重
		for (Integer in : list) {
			Integer i = map.get(in);
			if(i == null)
				map.put(in, 1);
			else
				map.put(in, ++i);
			}
		for (Integer key : map.keySet()) {
			int val = map.get(key);
			//System.out.print(key + "出现了" + val + "次;"+"\n");
			ha.put(val, key);
		}
		for (Integer me : ha.keySet()) {
			System.out.print(ha.get(me) + "出现了" + me + "次;"+"\n");
		}
	}
}
