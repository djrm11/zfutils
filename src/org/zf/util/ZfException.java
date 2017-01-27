package org.zf.util;



public class ZfException {
	public static void main(String str[]){
		new ZfException();
	} 
	
	public ZfException() {
		super();
		testException();
	}
	
	public void testException(){
		try{
			System.out.println(50/0);
		}catch(Exception e){
			System.out.println(e);
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
}