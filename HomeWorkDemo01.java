package cn.itheima.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HomeWorkDemo01 {
/*	2.�����������󣬲��ô���ʵ�֣�
	(1)���ü���¼�룬����һ���ַ���
	(2)ͳ�Ƹ��ַ����и����ַ�������
	(3)�磺
		�û������ַ���"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
		������������-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)

u(4)v(1)w(1)y(3)~(6)*/  // --->Ҫʹ��map   --> Char + Integer
	 public static void main(String[] args) {
		// ���ȵ���Ҫһ��map ��key���ַ���value �ǳ��ֵĴ����� ����ֻ��Ҫ�����ݷŵ�map�У��������ɽ������
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ������Ұ���ͳ������");
		String needStr = sc.next();
		//  ��Ҫ���û�������ַ����ŵ�map��
		readCountForConsole(needStr);
	}

	private static void readCountForConsole(String str) {
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			  // �������ַ���һ�γ��֣��ҽ�����ִ�������1,����map��
			  // �������ַ����ǵ�һ�γ��֣��ҽ���ȡ�����õ������ֵĴ�������+1 �Ż�map��
			   if(!map.containsKey(c)){
				   //�����map�в����������������ַ���˵����������������ַ��ǵ�һ�γ���
				    map.put(c, 1);
			   }else{
				  // ����ַ����ǵ�һ�γ���
				   Integer count = map.get(c);
				   map.put(c, count+1);
			   }
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			    Character key = entry.getKey();
			    Integer value = entry.getValue();
			    System.out.print(key + "("+value+")");
		}
		
		
	}
}
