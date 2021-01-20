package test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTest {
	HttpURLConnection con;
	URL url;
	OutputStream os = null;
	
	public HttpTest() {
		try {
			url = new URL("http://localhost:8888/rest/member");
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "applictaion/json;utf-8");
			con.setDoOutput(true);
			os = con.getOutputStream();
			os.write(0);
			os.flush();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(os!=null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		new HttpTest();
	}
}
