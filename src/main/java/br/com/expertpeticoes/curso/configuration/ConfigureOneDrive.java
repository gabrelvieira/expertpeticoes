package br.com.expertpeticoes.curso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.expertpeticoes.curso.controller.onedrive.OneDrive;

@Configuration
public class ConfigureOneDrive {

	@Bean
	public OneDrive getOneDrive() {
		String refresh = "M.R3_BAY.-Cfm!tWBa256vQE2Bo!eZlbB2s5KFyJbmYRHLOepGUrs2l0!TKhhL57vwVIImPseyW41Et7zsdzz8Xc3aIAk3*aDxSqOfq1R9u7n4rRpMsDXiNlZML3l0gUrevVcWQepm!XRGau3fcxex3EIlAPOICaO8vg4xuiCVfnSJPqxSLTx*llbSgPI2TzvbnBNu4DAfj7Rq3DI27TJoeC*BM3p3wqY7ReY6Y1jiWM2!pCz8makuRw9Kwmw3RmMdDuOx091nxMUJscS3IQTM3Ed13!S*YNiFL5mYz5WD7oTEc*Y22Uf44j4UdNy5KdMwPScI!cdI!w$$";
		OneDrive oneDrive = new OneDrive(refresh, "MjX7Q~JOzNddrpR3K-XZcmRYCtOf61ZBsPnPg", "http://localhost/auth");
		return oneDrive;
	}
}
