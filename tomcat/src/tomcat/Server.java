package tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

import tomcat.Util.FileHandle;

public class Server {

	static String webRoot="WebRoot";
	public static void main(String[] args) {

		int port = 8899;
		// ����һ��ServerSocket�����ڶ˿�8899��
		ServerSocket server;
		Socket socket = null;
		Respond respond=null;
		Requst request=null;
		int count=0;
		try {
			server = new ServerSocket(port);
			while (true) 
			{
				System.out.println(++count);
				// server���Խ�������Socket����������server��accept����������ʽ��
				socket = server.accept();
				// ���ͻ��˽���������֮�����ǾͿ��Ի�ȡsocket��InputStream�������ж�ȡ�ͻ��˷���������Ϣ�ˡ�
				/*InputStream reader = socket.getInputStream();
				OutputStream writer = socket.getOutputStream();*/
				
				/*request=new Requst(reader);
				 respond=new Respond(writer);*/
			
				 Processer p = new Processer(socket);
				 Thread t = new Thread(p);
		         t.start();
		         //socket.close();
				/*//writer.write("aaaaaaa".getBytes());
			//	respond.printNOText("WebRoot/img/a.jpg");
				//String uri=request.getUri();
				//writer.write("aaa".getBytes());
				
				//respond.print("aaaaa");
				
				//socket.shutdownOutput();
				
				//respond.printNOText("WebRoot/img/a.jpg");
				
				//
				
				
				
				
				 * ҵ���߼�
				 * �ж��Ǿ�̬��Դ�ļ����Ƕ�̬
				 * true  ֱ�ӷ�����Դ�ļ�
				 * false ����
				 
				if(true)
				{
					respond.print(new File("WebRoot/index.html"));
				}
				else
				{
					respond.print("���Ƕ�̬�ļ�");
				}
				
				
				

				reader.close();
				writer.flush();
				writer.close();*/
				//socket=null;
	/*			String html="<html>aaaaaaaaaa</html>";
				
				
				File file=new File("WebRoot/index.html");
				InputStream in=new FileInputStream(file);
				
				FileHandle fh=new FileHandle();
				String db=fh.readFileToString(in);
				//System.out.print(db);
				String aa = db+"";
				
				String ini = fh.readFileToString(socket.getInputStream());
				System.out.print(ini);
				
				Requst re=new Requst(socket.getInputStream());
				System.out.println(re.getUri());
				
				writer.write(aa.getBytes());
				
				
				
				reader.close();
				//writer.flush();
				writer.close();*/
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}
	public static Boolean isStaticFile(String suffix)
	{
		String suffixs[]=new String[]{".html",".css",".js"};
		
		for(String i:suffixs)
		{
			if(suffix==i)return true;
		}
		return false;
		
	}

}
