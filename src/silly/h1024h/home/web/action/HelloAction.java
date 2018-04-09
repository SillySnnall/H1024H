package silly.h1024h.home.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

	public String hello(){
		
		System.out.println("hello world!");
		
		return NONE;
	}

	public String add(){

		System.out.println("add");

		return SUCCESS;
	}

}
