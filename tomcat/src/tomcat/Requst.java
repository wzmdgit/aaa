/**
 * 
 */
package tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import tomcat.Util.FileHandle;
import tomcat.Util.StringHandle;

/**
 * @author wzm
 *
 */
public class Requst {

	private String reqInfo;
	
	private InputStream in;

	private String uri;
	
	private String suffix;



	private FileHandle fh;
	
	private StringHandle strHand;
	
	{
		fh=new FileHandle();
		strHand=new StringHandle();
	}
	
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}


	public String getReqInfo() {
		return reqInfo;
	}

	public void setReqInfo(String reqInfo) {
		this.reqInfo = reqInfo;
	}
	
	public Requst(InputStream argin) 
	{
		
		/*
		 * 请求信息初始化 
		 */
		this.in=argin;
		setReqInfo(fh.readFileToString(in));
		
		setUri(strHand.getReqUri(getReqInfo()));
		
		setSuffix(strHand.getReqSuffix(getUri()));
		
		
		
	}

}
