package br.com.leodevel.jwtauthentication.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.leodevel.jwtauthentication.dto.response.UserResponseDTO;
import br.com.leodevel.jwtauthentication.model.User;

@Service
public class AuthService {

	public UserResponseDTO getUserLogged() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return UserResponseDTO.fromEntity(user);
	}
	
}