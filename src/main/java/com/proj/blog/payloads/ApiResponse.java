package com.proj.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	private boolean status;
	
//	public Api_Response(String message,boolean status) {
//		System.out.println(message+" ");
//		System.out.print(status);
//	}
	
	public boolean getStatus() {
		return status;
	}

}
