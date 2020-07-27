package br.com.leodevel.jwtauthentication.dto.response;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.leodevel.jwtauthentication.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

	private Long id;
	private String name;
	private String username;
	
	@JsonIgnore
	private String password;
	
	public static UserResponseDTO fromEntity(User user) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		BeanUtils.copyProperties(user, userResponseDTO);
		return userResponseDTO;
	}
	
}