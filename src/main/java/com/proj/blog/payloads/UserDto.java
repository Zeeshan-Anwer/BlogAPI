package com.proj.blog.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	
	
	private int id;
	

	private String name;
	private String email_id;
	private String password;
	private String about;

}
