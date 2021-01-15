package com.javer.drink.app.project.file;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Service
@RequestScope
public class FileUploadService {

    public File uploadFile(Part filePart) throws IOException {
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        File file = new File(getUploadFilesPath() + fileName);
        Files.deleteIfExists(file.toPath());

        InputStream inputStream = filePart.getInputStream();
        Files.copy(inputStream, file.toPath());
        return file;
    }

    public String getUploadFilesPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Thread.currentThread().getContextClassLoader().getResource("settings.properties").openStream());
        return settings.getProperty("Upload.Path");
    }
}
