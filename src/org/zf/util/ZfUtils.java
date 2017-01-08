package org.zf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ZfUtils {
	public static void main(String str[]){
		new ZfUtils();
	} 
	
	public ZfUtils() {
		super();
		// TODO Auto-generated constructor stub
//		testClasspath("org/zf/resources/testpath.txt");
		copyFiles("org/zf/resources/testpath.txt");
	}
	
	public void copyFiles(String fileName){
		
		String[] strarr = getStringArrays(fileName);
		if (isEmpty(strarr)){
			return;
		} 
		for(String sourceName:strarr){
			String sorPath = sourceName.replaceAll("\r|\n", "");
			System.out.println("sourcePath: "+sorPath);
			String	origPath = this.getClass().getClassLoader().getResource("").toString();
			String tarPath = origPath.substring(origPath.indexOf("/")+1)+"org/zf/resources/libjar"+sourceName.substring(sourceName.lastIndexOf("/")).replaceAll("\r|\n", "");
			System.out.println("targetPath: "+tarPath);
			customBufferStreamCopy(new File(sorPath),new File(tarPath));
//			break;
		}
		
	}
	
	private void customBufferStreamCopy(File source, File target) {  
	    InputStream fis = null;  
	    OutputStream fos = null;  
	    try {  
	        fis = new FileInputStream(source);  
	        fos = new FileOutputStream(target);  
	        byte[] buf = new byte[40960];  
	        int i;  
	        while ((i = fis.read(buf)) != -1) {  
	            fos.write(buf, 0, i);  
	        } 
	    	fis.close();  
	    	fos.close(); 
	    }  
	    catch (Exception e) {  
	        e.printStackTrace();  
	    }
	}
	public String[] getStringArrays(String fileName){
		InputStream is = this.getClass().getClassLoader().getResourceAsStream (fileName);
		byte b[] = new byte[10240];
		try {
			int len = 0;
			int temp = 0;
			while((temp = is.read()) != -1){
				b[len] = (byte)temp;
				len++;
			}
			is.close();
			return new String(b,0,len).split("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}
	
	public void testClasspath(String fileName){
//		System.out.println(this.getClass().getResource("")); 
		/*得到的是当前类class文件的URI目录。不包括自己！
		如：file：/D：/workspace/jbpmtest3/bin/com/test/*/
		
//		System.out.println(this.getClass().getResource("/")); 
		/*得到的是当前的classpath的绝对URI路径 。
		如：file：/D：/workspace/jbpmtest3/bin/*/

//		System.out.println(this.getClass() .getClassLoader().getResource("")); 
		/*得到的也是当前ClassPath的绝对URI路径 。
		如：file：/D：/workspace/jbpmtest3/bin/*/

//		System.out.println(ClassLoader.getSystemResource("")); 
		/*得到的也是当前ClassPath的绝对URI路径 。
		如：file：/D：/workspace/jbpmtest3/bin/*/

//		System.out.println(Thread.currentThread().getContextClassLoader ().getResource("")); 
		/*得到的也是当前ClassPath的绝对URI路径 。
		如：file：/D：/workspace/jbpmtest3/bin/*/

		/*System.out.println(ServletActionContext.getServletContext().getRealPath("/")); 
		Web应用程序 中，得到Web应用程序的根目录的绝对路径。这样，我们只需要提供相对于Web应用程序根目录的路径，就可以构建出定位资源的绝对路径。
		如：file：/D:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/WebProject*/
		
		System.out.println(this.getClass() .getClassLoader().getResource(fileName)); 
		System.out.println(this.getClass() .getClassLoader().getResourceAsStream (fileName));
	}
}
