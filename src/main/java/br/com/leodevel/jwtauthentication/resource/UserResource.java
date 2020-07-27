package br.com.leodevel.jwtauthentication.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leodevel.jwtauthentication.dto.response.UserResponseDTO;
import br.com.leodevel.jwtauthentication.model.Result;
import br.com.leodevel.jwtauthentication.service.AuthService;
import br.com.leodevel.jwtauthentication.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;
	
	@GetMapping
	public ResponseEntity<Result<List<UserResponseDTO>>> findAll() {

		List<UserResponseDTO> list = userService.findAll();
		return new ResponseEntity<>(new Result<>(true, list),
				HttpStatus.OK);

	}
	
	@GetMapping("/about")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Result<UserResponseDTO>> aboutUser() {

		return new ResponseEntity<>(
				new Result<>(true, authService.getUserLogged()), HttpStatus.OK);

	}
	
}
