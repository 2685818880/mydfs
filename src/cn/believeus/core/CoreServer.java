package cn.believeus.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.believeus.util.PropertiesUtil;

public class CoreServer {
	//���˻���--->���(������jian���)--->���̻���--->linux(��н����ͨ��)
	public static void main(String[] args) {
		String propertiesFile="project.properties";
		String port=PropertiesUtil.getValue(propertiesFile,"mydfs.server.port");
		int worker=Integer.parseInt(PropertiesUtil.getValue(propertiesFile,"mydfs.server.worker"));
		//�����̳߳�
		ExecutorService executorService = Executors.newFixedThreadPool((worker));
		try {
			//ռ�õ�ip��ַ��localhost(127.0.0.1) 192.168.43.19 8080
			// int 4 65536  0-65535
			final ServerSocket serverSocket=new ServerSocket(Integer.parseInt(port));
			//SocketAddress endpoint=new InetSocketAddress("127.0.0.1", Integer.parseInt(port));
			//serverSocket.bind(endpoint);
			//500 ����������ǿ
			final Socket socket = serverSocket.accept();
			System.out.println("�Ѿ���������:"+socket.getPort());
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("ִ��ҵ���߼�");
						InputStream is = socket.getInputStream();
						DataInputStream dis=new DataInputStream(is);
						String result = dis.readUTF();
						System.out.println(result);
						//�Բ�����Э��
						if(result.equals("nima")){
							OutputStream os = socket.getOutputStream();
							DataOutputStream dos=new DataOutputStream(os);
							dos.writeUTF("wocao");
						}
						result = dis.readUTF();
						if(result.equals("fuck")){
							System.out.println("laozibuheniwan");
						}
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			if(executorService.isShutdown()){
				serverSocket.close();
			}
		
		//����ʱ�쳣/������ʱ�쳣
		} catch (Exception e) {
			
		}
	}
}
