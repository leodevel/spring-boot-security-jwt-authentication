package br.com.leodevel.jwtauthentication.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leodevel.jwtauthentication.dto.request.UserRequestDTO;
import br.com.leodevel.jwtauthentication.dto.response.JwtResponse;
import br.com.leodevel.jwtauthentication.dto.response.UserResponseDTO;
import br.com.leodevel.jwtauthentication.model.Result;
import br.com.leodevel.jwtauthentication.model.User;
import br.com.leodevel.jwtauthentication.util.JwtUtils;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<Result<JwtResponse>> login(@RequestBody UserRequestDTO userRequestDTO){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequestDTO.getUsername(), userRequestDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		User user = (User) authentication.getPrincipal();
		UserResponseDTO userResponseDTO = UserResponseDTO.fromEntity(user);
		
		return new ResponseEntity<Result<JwtResponse>>(
				new Result<JwtResponse>(true, new JwtResponse(userResponseDTO, jwt)), HttpStatus.OK);
		
	}
	

}