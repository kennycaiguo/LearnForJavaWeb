package cn.zzc.web.servlet1;

public class MyServlet2 implements IMyServlet {

	@Override
	public void init() {
		System.out.println("hohoho!");
	}

	@Override
	public void service() {
		System.out.println("hahaha!");
	}

	@Override
	public void destory() {
		System.out.println("再见!");
	}

}
