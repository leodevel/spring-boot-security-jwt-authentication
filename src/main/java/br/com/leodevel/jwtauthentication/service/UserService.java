package br.com.leodevel.jwtauthentication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leodevel.jwtauthentication.dto.request.UserRequestDTO;
import br.com.leodevel.jwtauthentication.dto.response.UserResponseDTO;
import br.com.leodevel.jwtauthentication.model.User;
import br.com.leodevel.jwtauthentication.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDTO save(UserRequestDTO userRequestDTO) {		
		User user = User.fromDTO(userRequestDTO);
		userRepository.save(user);
		return UserResponseDTO.fromEntity(user);
	}
	
	public List<UserResponseDTO> findAll(){
		return userRepository.findAll().stream()
				.map(UserResponseDTO::fromEntity).collect(Collectors.toList());
	}
	
}
