package com.javer.drink.app.project.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.Part;
import java.io.IOException;

@RequestScope
@RequiredArgsConstructor
@Component
public class FileDataHandler {

    private final FileParserService fileParserService;
    private final FileUploadService fileUploadService;

    public void dataUploadHandler(Part partFile) throws IOException {
        fileParserService.parseDataToDatabase(fileUploadService.uploadFile(partFile));
    }
}
