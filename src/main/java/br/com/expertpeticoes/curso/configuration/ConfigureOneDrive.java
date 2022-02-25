package br.com.expertpeticoes.curso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.expertpeticoes.curso.controller.onedrive.OneDrive;
import br.com.expertpeticoes.curso.model.dto.OneDrivePathDto;

@Configuration
public class ConfigureOneDrive {

	@Bean
	public OneDrive getOneDrive() {
		String refresh = "M.R3_BAY.-CV9*SdZfwvPozwrjSWS7WD!dHXvaXBM1AhHOhLaA*F3WcfJKR!xbXBjTGtLlT9BcsnsypPZ*4kur4sDukKVJmxw6g4TaqwukLabPGKZrXU86KHangH*AcTHfBF!HlnBP1uE9GWOZ*WRLevsV!4Nh6TFlxpV5883PnrbkkCqYfZIcjIAuWncrbziogEqsgeHXGlcYffAvFqGKtY1dByuBDql8!u7z*o6a8Hd7siRajrzvluX92nbvXuXvJj4*uBnPRGXXeVXgbSQjVUqRQbenigpiwfkoh*CYXurnW65dYn4KSxz!*uN9rAVvUe*8cin7LA$$";
		OneDrive oneDrive = new OneDrive(refresh, "MjX7Q~JOzNddrpR3K-XZcmRYCtOf61ZBsPnPg", "http://localhost/auth");
		return oneDrive;
	}
	
	@Bean
	public OneDrivePathDto getPath() {
		OneDrivePathDto path = new OneDrivePathDto();
		path.setPathGratis("/Imagens/gabriel/apache.zip");
		path.setPathPago("/Imagens/gabriel/apache.zip");
		return path;
	}
}
