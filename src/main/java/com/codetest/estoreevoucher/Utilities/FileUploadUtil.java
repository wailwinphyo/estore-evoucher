package com.codetest.estoreevoucher.Utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import net.glxn.qrgen.javase.QRCode;

public class FileUploadUtil {
	
	public static void saveFile(String uploadDir, String fileName, MultipartFile file) throws Exception {
		
		Path uploadPath = Paths.get(uploadDir);

		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try(InputStream inputStream = file.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			throw new Exception("Could not save image " + fileName, ex);
		}
	}
	
	public static String generateNStoreQRCodeImage(String dir, String barcodeText) throws Exception {
	    ByteArrayOutputStream stream = QRCode
	      .from(barcodeText)
	      .withSize(250, 250)
	      .stream();
	    ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
	    
	    Path uploadPath = Paths.get(dir);

		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
	    String fileName = UUID.randomUUID().toString()+".png";
	    Path filePath = Paths.get(dir).resolve(fileName);
	    Files.copy(bis, filePath, StandardCopyOption.REPLACE_EXISTING);
	    
	    return 	dir + "/" + fileName;
	}

}
