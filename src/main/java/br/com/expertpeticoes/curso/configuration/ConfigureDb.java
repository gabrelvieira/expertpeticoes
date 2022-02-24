package br.com.expertpeticoes.curso.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class ConfigureDb {

	@Bean
	public DataSource getDataSource() throws Exception{
		System.out.println("opa");
		 Properties info = new Properties();     
		    info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, "ADMIN");
		    info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, "Expertpeticoes26");          
		    info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");    
		  

		    OracleDataSource ods = new OracleDataSource();
		    ods.setURL("jdbc:oracle:thin:@db202202231845_medium?TNS_ADMIN=C:/Users/Usuario/Desktop/Portifolio/aplicacaojava/oracle");    
		    ods.setConnectionProperties(info);
		    System.out.println("acabou");
		    return ods;
	}
}
