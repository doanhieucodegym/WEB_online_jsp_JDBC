package utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.module.sitemesh.filter.Buffer;

public class HttpUtil {
		private String value;
		
		public HttpUtil(String value) {
			this.value =value;
		}
//		public HttpUtil() {}
		
		public <T> T toModel(Class<T> tClass) {
			//ham object mapper map với object cần 
			//tao hàm để lấy một  object  bất kỳ 
			//chuyển string  mapping vao  model 
			try {
				return new ObjectMapper().readValue(value,tClass );
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
			return null;
		
		}
		
		public static HttpUtil of (BufferedReader reader) {
			//nhận req kiểu dữ liệu reader ,buffere reader
			//thao tách chuyển json thành chuỗi String json
				StringBuilder sb = new StringBuilder();
				try {
					String line;
					while((line =reader.readLine())!=null) {
						sb.append(line);
					}
					
				}catch (IOException e){
					System.out.print(e.getMessage());
				}
				return new HttpUtil(sb.toString());
		}
}
