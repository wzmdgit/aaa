package tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class test1 {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server;
		Socket socket = null;
		Respond respond=null;
		Requst request=null;
		int count=0;
		int runC=0;
		
			server = new ServerSocket(10000);
			boolean flag = true;
			while (true) 
			{
				
				socket = server.accept();
				System.out.println("接受到客服的链接");
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				p.println("收到了，客户端你好");
				p.flush();
				p.close();
				socket.close();
				// server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
				/*socket = server.accept();
				if(socket.isConnected())flag=true;
				else flag=false;
				System.out.println(++count);
				
				
				if(flag)
				{
					InputStream reader = socket.getInputStream();
					PrintWriter writer = new PrintWriter(socket.getOutputStream());
					runC++;
					writer.println("aaaaaa");
					writer.println("bbbbbbbbb"+runC);
					if(runC>5)
					{
						writer.println("cccccccccc"+runC);
					}
					writer.flush();
					writer.close();
					System.out.println("run:"+runC);
					socket.close();
				}*/
				// 跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。
				
			}
		
	}

}
