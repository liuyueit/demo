package com.demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOTest {
	private static final Logger log = LoggerFactory.getLogger(IOTest.class);

//	@Test
	public void readFileByByte() throws IOException {
		// 按字节流     
		//FileInputStream + ByteArrayOutputStream
		FileInputStream fIn = new FileInputStream("src/main/resources/test.txt");	// Linux和Unix下都是用“/”。而在windows下也能识别“/”。所以最好用“/”
		ByteArrayOutputStream bOs = new ByteArrayOutputStream();
		byte[] perReadByte = new byte[1];	
		StringBuffer sb = new StringBuffer();

		//不使用BufferedInputStream缓冲
		int len = 0;
		while((len =fIn.read(perReadByte)) > 0) {
			//注意FileInputStream.read方法是每次都只读入指定数量写入perReadByte，而且是覆盖，需要自己把结果存下来
			System.out.println(len);
			System.out.println(new String(perReadByte)); //如果源文件有BOM，那么会输出前面的BOM
			//会把前面的BOM去掉
			bOs.write(perReadByte, 0, len);

			//这种方法不可取，因为perReadByte会覆盖上一次循环的值，但是最后一次循环读入数据量不足时，上一次的值也在里面
			//				sb.append(new String(perReadByte, "utf-8"));
		}
		byte[] re = bOs.toByteArray();			
		System.out.println(new String(re, "utf-8"));
		//			System.out.println(sb);


		// 使用BufferedInputStream
		//BufferedInputStream(FileInputStream) + ByteArrayOutputStream
		BufferedInputStream bIn = new BufferedInputStream(fIn);
		int len2 = 0;
		while((len2 = bIn.read(perReadByte)) > 0) {
			bOs.write(perReadByte, 0, len2);
		}
		byte[] re2 = bOs.toByteArray();			
		System.out.println(new String(re2, "utf-8"));

		fIn.close();
	}

//	@Test
	public void readFileByChar() {
//		按字符流读入
		try {
			File fd = new File("src/main/resources/test.txt");
			FileReader frd = new FileReader(fd);
		
			StringBuffer sb = new StringBuffer();
			char[] chBuffer = new char[1];
			int len = 0;
			while((len = frd.read(chBuffer)) > 0) {
				sb.append(new String(chBuffer));
			}
			System.out.println(sb);
			frd.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//	@Test
	public void networkIO() throws IOException {
//		URL url = new URL("http://localhost:8080/login");
		
		URL url = new URL("http://localhost:8080/login?tel=18382087883&pwd=yang11");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");		
		conn.setConnectTimeout(10000);
//		conn.setRequestProperty("Content-Type", "application/json");
		//conn.getInputStream();
		
		//JSONObject obj = new JSONObject();
		//obj.add("tel","18382087883");
		//obj.add("pwd","yang11");
//		conn.setDoOutput(true);
		
		
//		PrintWriter writer = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
		//writer.print("tel=18382087883&pwd=yang11");
//		writer.print("{'tel':'18382087883', 'pwd':'yang11'}");
//		writer.print("test");
//		writer.flush();
//		writer.close();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		String temp="";
		while ((temp = in.readLine()) != null) {
			System.out.println(temp);
		}
		
		conn.disconnect();
	}
    @Value("${name}")
	private String myName;
	@Test
	public void readProperties() throws IOException {
		log.info("读取properties文件结果: {}", myName);
		
		// 原始读取方法
		String filePath = "src/main/resources/application.properties";
//		String filePath =  
		FileInputStream in = new FileInputStream(filePath);
		Properties pro = new Properties();
		pro.load(in);
		log.info("原始方法读取properties文件结果: {}", pro.getProperty("name"));
		in.close();
		
	}

}