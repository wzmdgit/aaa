package tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import tomcat.Util.FileHandle;

public class Respond {

	private FileHandle fh;

	private OutputStream out;
	
	{
		fh=new FileHandle();
	}
	
	public Respond(OutputStream outputstream) 
	{
		
		out=outputstream;
		
	}
	
	/*
	 * ���ؿͻ����ַ���
	 */
	public void print(String str) throws IOException
	{
		out.write(str.getBytes());
		//out=null;
		out.flush();
		out.close();
	}
	/*
	 * ����File(parh) 
	 * return �ļ��ַ��������ļ����ַ��ı� .html .css .xml ...)
	 */
	public void print(File file) throws FileNotFoundException,IOException
	{
		InputStream in=new FileInputStream(file);
		String str = fh.readFileToString(in);
		print(str+"");
		
	}
	
	public void printNOText(String filePath) throws IOException
	{
		fh.readImgFile(filePath, out);
	
	}
	
	
}
