package cn.believeus.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("127.0.0.1", 9999);
		OutputStream outputStream = socket.getOutputStream();
		DataOutputStream dos=new DataOutputStream(outputStream);
		dos.writeUTF("nima");
		InputStream inputStream = socket.getInputStream();
		DataInputStream dis=new DataInputStream(inputStream);
		String result = dis.readUTF();
		if(result.equals("wocao")){
			dos.writeUTF("fuck");
		}
		System.out.println(result);
	}
}
