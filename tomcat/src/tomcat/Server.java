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
		// 定义一个ServerSocket监听在端口8899上
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
				// server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
				socket = server.accept();
				// 跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。
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
				
				
				
				
				 * 业务逻辑
				 * 判断是静态资源文件还是动态
				 * true  直接返回资源文件
				 * false 处理
				 
				if(true)
				{
					respond.print(new File("WebRoot/index.html"));
				}
				else
				{
					respond.print("这是动态文件");
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
