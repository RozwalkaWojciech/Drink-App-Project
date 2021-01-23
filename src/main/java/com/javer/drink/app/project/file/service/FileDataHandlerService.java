package com.javer.drink.app.project.file.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.Part;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@RequestScope
public class FileDataHandlerService {

    private final FileParserService fileParserService;
    private final FileUploadService fileUploadService;

    public void dataUploadHandler(Part partFile) throws IOException {
        fileParserService.parseDataToDatabase(fileUploadService.uploadFile(partFile));
    }
}
