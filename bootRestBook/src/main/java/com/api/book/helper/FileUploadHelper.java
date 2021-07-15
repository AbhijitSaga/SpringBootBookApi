package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	/* static path of file */
	// public final String UPLOAD_DIR =
	// "E:\\springBootPractice\\springbootRest\\src\\main\\resources\\static\\image";
	/* Dynamic path of file */
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {
	}

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {
			// read
			// InputStream ins = multipartFile.getInputStream();
			// byte data[] = new byte[ins.available()];
			// ins.read(data);

			// write
			// FileOutputStream fos=new
			// FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			// fos.write(data);
			// fos.flush();
			// fos.close();
			// ins.close();

			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
}
