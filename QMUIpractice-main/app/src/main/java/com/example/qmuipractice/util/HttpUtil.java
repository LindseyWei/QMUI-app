package com.example.qmuipractice.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {
	
	
	// Get����
	public static String getRequest(String url) throws Exception{

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);  // ����Get����
		HttpResponse httpResponse = httpClient.execute(get);
		if (httpResponse.getStatusLine().getStatusCode() == 200){  // ����������ɹ�������Ӧ

			String result = EntityUtils.toString(httpResponse.getEntity());  // ��ȡ��Ӧ�ַ���
			return result;
		}
		return null;
	}
	
	public static String postRequest(String url, Map<String, String> rawParams) throws Exception {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		System.out.println(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String key : rawParams.keySet()){

			params.add(new BasicNameValuePair(key, rawParams.get(key)));
		}

		post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
		System.out.println("*****************");
		HttpResponse httpResponse = httpClient.execute(post);  // ����Post����
		System.out.println("*****************");
		if (httpResponse.getStatusLine().getStatusCode() == 200){
			
			String result = EntityUtils.toString(httpResponse.getEntity());
			return result;
		}
		
		return null;
		
	}
	
}
