package br.com.leodevel.jwtauthentication.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

	private Long id;
	private String name;
	private String username;
	private String password;
	
}