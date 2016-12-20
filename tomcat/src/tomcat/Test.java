package tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		int count=0;
		
		 ServerSocket server = new ServerSocket(888);
	        while(true) {
	        	
	            Socket s = server.accept();
	            System.out.println(++count);
	            Processer1 p = new Processer1(s);
	            Thread t = new Thread(p);
	            t.start();
	            //Thread.sleep(5000);
	        }
	    }
	
	

}

	class Processer1 implements Runnable {
	    private Socket socket;
	    
	    public Processer1(Socket s) {
	        // TODO Auto-generated constructor stub
	        this.socket = s;
	    }
	    @Override
	    public void run() {
	        try {
	            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
	            out.println("HTTP/1.0 200 OK");
	            out.println("Content-Type:text/html;charset=utf-8");
	            out.println();
	            out.println("<h1> Web服务器测试成功！</h1>");
	            out.close();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                socket.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        
	    }
	}

