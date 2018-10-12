package cn.zzc.排序;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 
 * @author GG
 *
 *         对数组int[] array = { 1, 8, 2, 1, 3, 2, 1, 2, 1, 8 };
 *         按次数出现从大到小排序 效果：
 *         1出现了4次 ;
 *         2出现了3次 ;
 *         8出现了2次 ;
 *         3出现了1次 ;
 */
public class Test {
	public static void main(String[] args) {
		int[] array = { 1, 8, 2, 1, 3, 2, 1, 2, 1, 8 };
		int[] arr = Sort(array);// 原数组排序,并获得新数组(从大到小排序)
		/*
		 * for (int i : arr) { System.out.print(i + " "); }
		 */
		Num(arr);
	}

	public static int[] Sort(int[] array) {
		int i, j, temp;
		for (i = 0; i < array.length - 1; i++) {
			for (j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		/*
		 * for (int item : array) System.out.print(item + " ");
		 */
		return array;
	}

	public static void Num(int[] arr) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		// 向集合中存入数据
		for (Integer in : arr) {
			int i = 1;
			if (map.get(in) != null) {
				i = map.get(in) + 1;
			}
			map.put(in, i);
		}
		
		  Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator(); 
		  String txt = ""; 
		  while (iter.hasNext()) { 
		 	Entry<Integer, Integer> entry = iter.next(); 
		 	Integer key = entry.getKey(); 
		 	Integer val = entry.getValue();
		 	txt = txt + key + "出现了" + val + "次;"+"\n";
		 	/*System.out.print(val);
		 	ArrayList<Integer> list = new ArrayList<Integer>();
		 	list.add(val)*/
		  }
		  System.out.println(txt);
			
		/*for (Integer key : map.keySet()) {
			int val = map.get(key);
			
			System.out.print(key + "出现了" + val + "次;"+"\n");
		}*/
	}
}
