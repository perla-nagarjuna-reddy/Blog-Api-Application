package com.springbootproject.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	
	@NotEmpty(message = "Name is Required")
	@Size(min = 4, message = "Username must be min of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3 , max = 10,message = "Password must be minimum of 3 characters and maximum of 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
}
