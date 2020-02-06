package utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.opensymphony.module.sitemesh.filter.Buffer;

public class HttpUtil {
		private String value;
		
		public HttpUtil(String value) {
			this.value =value;
		}
		
		public static HttpUtil of (BufferedReader reader) {
				StringBuilder sb = new StringBuilder();
				try {
					String line;
					while((line =reader.readLine())!=null) {}
				}catch (IOException e){
					System.out.print(e.getMessage());
				}
				return new HttpUtil(sb.toString());
		}
}
