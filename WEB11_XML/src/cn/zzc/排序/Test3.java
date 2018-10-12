package cn.zzc.排序;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 2, 1, 3, 2, 1, 2, 1, 8 };
		
		//存数字
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		//存数字出现的次数
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		// 向集合中存入数据
		for (int i = 0; i < arr.length; i++) {
			boolean f = false;
			//第一个数直接存入arr1,剩下的数字相同时arr2在相同索引下加1
			if (arr1.size() == 0) {
				arr1.add(arr[i]);
				arr2.add(1);//同时集合arr2进行记录
				continue;
			}
			// 遍历接下来数组arr里的数字与arr1集合里的数字进行对比 
			// 有相同的 arr2集合相对下标位置+1 不相同则加入arr1集合
			for (int j = 0; j < arr1.size(); j++) {
				if (arr[i] == arr1.get(j)) {
					arr2.set(j, arr2.get(j)+1);
					f = true;
					break;
					}
				}
			if (!f) {
				arr1.add(arr[i]);
				arr2.add(1);
			}
		}
		
		paixu(arr1, arr2);
		for (int t = 0; t < arr1.size(); t++) {
			System.out.println(arr1.get(t) + "出现了" + arr2.get(t) + "次");
		}
	}
	public static void paixu(List<Integer> arr1, List<Integer> arr2) {
		// 排序 你应该看的懂吧
		int temp = 0;
		for (int i = 0; i < arr2.size() - 1; i++) {
			for (int j = 0; j < arr2.size() - 1; j++) {
				if (arr2.get(j) < arr2.get(j + 1)) {
					// 对arr2进行排序
					temp = arr2.get(j);
					arr2.set(j, arr2.get(j + 1));
					arr2.set(j + 1, temp);
					// 对arr1进行排序
					temp = arr1.get(j);
					arr1.set(j, arr1.get(j + 1));
					arr1.set(j + 1, temp);
				}
			}
		}
	}
}
