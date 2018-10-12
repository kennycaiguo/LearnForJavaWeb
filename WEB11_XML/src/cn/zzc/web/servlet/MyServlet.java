package cn.zzc.web.servlet;

import cn.zzc.web.servlet1.IMyServlet;

public class MyServlet implements IMyServlet {

	@Override
	public void init() {
		System.out.println("hahaha!");
	}

	@Override
	public void service() {
		System.out.println("hohoho!");
	}

	@Override
	public void destory() {
		System.out.println("再见!");
	}

}
