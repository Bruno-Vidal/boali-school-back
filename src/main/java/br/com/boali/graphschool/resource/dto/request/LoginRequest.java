package br.com.boali.graphschool.resource.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Data
@NoArgsConstructor
public class LoginRequest {

	private String email;
	private String senha;


	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
