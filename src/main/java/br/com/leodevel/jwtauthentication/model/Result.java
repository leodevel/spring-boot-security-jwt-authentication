package br.com.leodevel.jwtauthentication.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {

	private boolean success;
	private String message;
	private T data;
	
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}
	
}
