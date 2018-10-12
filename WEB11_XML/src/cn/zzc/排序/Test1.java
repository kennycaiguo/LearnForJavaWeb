package cn.zzc.排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
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
public class Test1 {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 2, 1, 3, 2, 1, 2, 1, 8 };
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		// 向集合中存入数据
		for (Integer in : arr) {
			int i = 1;
			if (map.get(in) != null) {
				i = map.get(in) + 1;
			}
			map.put(in, i);
		}
		Sort(map);
	}

	//编写自定义比较器
	public static void Sort(Map<Integer, Integer> map) {
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if (o2.getValue().compareTo(o1.getValue()) > 0) {// 按value递减顺序排序
					return 1;
				} else if (o2.getValue().compareTo(o1.getValue()) == 0) {
					if (o2.getKey().compareTo(o1.getKey()) < 0)// 如果value相同输出key小的
						return 1;
					else
						return -1;
				} else {
					return -1;
				}
			}
		});
		
		for (Entry<Integer, Integer> en : list) {			
			System.out.print(en.getKey() + "出现了" + en.getValue() + "次;"+"\n");
		}
	}
}
