package br.com.expertpeticoes.curso.dropbox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

@Service
public class DownloadDrive {
    
	private final String ACCESS_TOKEN = "_2muCYG_uhwAAAAAAAAAASSRjB1cB5eGw1-Dbt6NqgXCQeDb_jVfMNPfUGrUctzy";
	
	public File getFile() throws Exception{
		DbxRequestConfig config = DbxRequestConfig.newBuilder("expertpeti").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        
        String path = "C:\\Users\\Usuario\\Desktop\\apache-maven-3.8.4\\links.zip";
        File file = new File(path);
        OutputStream output = new FileOutputStream(file);
        
        client.files().downloadZipBuilder("/vieira")
        .download(output);
        output.close();
        
        return file;
	}
}




