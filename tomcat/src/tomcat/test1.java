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
				System.out.println("���ܵ��ͷ�������");
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				p.println("�յ��ˣ��ͻ������");
				p.flush();
				p.close();
				socket.close();
				// server���Խ�������Socket����������server��accept����������ʽ��
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
				// ���ͻ��˽���������֮�����ǾͿ��Ի�ȡsocket��InputStream�������ж�ȡ�ͻ��˷���������Ϣ�ˡ�
				
			}
		
	}

}
