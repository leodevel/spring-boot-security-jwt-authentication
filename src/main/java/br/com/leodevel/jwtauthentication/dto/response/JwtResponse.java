package br.com.leodevel.jwtauthentication.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

	private UserResponseDTO user;
	private String token;
	
	public JwtResponse(UserResponseDTO user, String token) {
		this.user = user;
		this.token = token;
	}
	
}
