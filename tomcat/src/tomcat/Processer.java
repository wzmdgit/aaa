package tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Processer implements Runnable {

	Socket socket = null;
	Respond respond=null;
	Requst request=null;
	public Processer(Socket arg0socket) 
	{
		socket =arg0socket;
		
	
		try {
			request = new Requst(socket.getInputStream());
			//socket.shutdownInput();
			respond = new Respond(socket.getOutputStream());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		//InputStream reader;
		try {
			
			System.out.println("ÐÂÁ¬½Ó:"+socket.getInetAddress()+":"+socket.getPort());
			/*reader = socket.getInputStream();
			OutputStream writer = socket.getOutputStream();
			
			//request=new Requst(reader);
			respond=new Respond(writer);*/
			
			
				respond.print(new File("WebRoot/index.html"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
