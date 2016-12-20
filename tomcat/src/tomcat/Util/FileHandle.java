package tomcat.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class FileHandle {

	InputStream in = null;
	OutputStream out = null;

	public void read(String path, OutputStream arg1out) throws IOException {
		int len = 0;
		in = new FileInputStream(path);
		out = arg1out;
		// 得到文件大小
		int i = in.available();
		byte data[] = new byte[i];
		// 读数据
		in.read(data);
		out.write(data);
		out.flush();
		out.close();
	}

	public String readFileToString(InputStream in) {

		System.out.println(in.toString());
		//Reader reader = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		byte chars[] = new byte[1024];
		int len;

		try {
			while ((len = in.read(chars)) != -1)
			{
				sb.append(new String(chars, 0, len));
				System.out.println(len);
			}
			
			return sb + "";
			//System.out.println("------------");
			
			//in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb + "";
		/*int i;
		String str = null;
		try {
			i = in.available();
			byte data[] = new byte[i];
			// 读数据
			in.read(data);
			 str=new String(data);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;*/
		
	}

	public void readImgFile(String path, OutputStream arg1out) {

		try {
			read(path, arg1out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
