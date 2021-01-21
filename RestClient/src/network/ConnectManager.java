package network;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class ConnectManager {
	URL url;
	HttpURLConnection con;
	BufferedReader br = null;
	BufferedWriter bw = null;

	public void requestByGet() {
		try{
			url = new URL("http://192.168.35.161:8888/rest/member");	
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");

			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String data=null;
			StringBuilder sb = new StringBuilder();
			while(true) {
				data = br.readLine();
				if(data == null) {
					break;
				}
				sb.append(data+"\n");
			}
			int code = con.getResponseCode();
			System.out.println("요청시도 했음 응답코드는 " + code);
			System.out.println("서버가 전송한 데이터는 " + sb.toString());
		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
				br.close();
				} catch(IOException e) {
				}
			}
		}
	}

	public int requestByPost(String param, String requestUrl) {
		int code = 0;
		try{
			url = new URL(requestUrl);	
			con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("Content-Type","application/json;charset=utf-8");
			con.setRequestMethod("POST");
			

			/*
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append(" \"m_id\":\"batman\",");
			sb.append(" \"m_pass\":\"1234\",");
			sb.append(" \"m_name\":\"batman\"");
			sb.append("}");
			*/


			bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(),"UTF-8"));
			bw.write(param);
			bw.flush();

			code = con.getResponseCode();
			System.out.println("서버로부터 받은 응답코드는 " + code);

		}catch (MalformedURLException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
					} catch(IOException e) {
				}
			}
		}
		return code;
	}
	
	public static void main(String[] args) {
		ConnectManager c = new ConnectManager();
		c.requestByPost();
	}
}
