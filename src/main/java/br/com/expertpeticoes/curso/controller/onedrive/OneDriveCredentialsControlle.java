package br.com.expertpeticoes.curso.controller.onedrive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.expertpeticoes.curso.model.dto.OneDrivePathDto;

@RestController
@RequestMapping("/adm/api/oneDrive")
@CrossOrigin
public class OneDriveCredentialsControlle {
	
	@Autowired
	private OneDrive oneDrive;
	
	@Autowired
	private OneDrivePathDto path;
	
	@GetMapping("/access/{token}")
	public String setToken(@PathVariable(name = "token") String token) {
		oneDrive.setToken(token);
		return ("seu novo token é: " + token);
	}
	
	@GetMapping("/refresh/{refreshToken}")
	public String setRefreshToken(@PathVariable(name = "refreshToken") String refreshToken) {
		oneDrive.setRefreshToken(refreshToken);
		return ("seu novo token é: " + refreshToken);
	}
	
	@GetMapping("/path-gratis")
	public String setPathGratis(String path) {
		this.path.setPathGratis(path);
		return ("seu novo diretório do curso gratuito é: " + this.path.getPathGratis());
	}
	
	@GetMapping("/path-pago/{path}")
	public String setPathPago(@PathVariable(name = "path") String path) {
		this.path.setPathPago(path);
		return ("seu novo diretório do curso pago é: " + this.path.getPathPago());
	}
}
