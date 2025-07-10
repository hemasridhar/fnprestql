package com.support.krishna.fnp8.restql.controller;

import com.support.krishna.fnp8.restql.model.DocumentWrapper;
import com.support.krishna.fnp8.restql.service.FileNetService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FileNetGraphQLController {

    private final FileNetService fileNetService;

    public FileNetGraphQLController(FileNetService fileNetService) {
        this.fileNetService = fileNetService;
    }

    @QueryMapping
    public DocumentWrapper getDocumentById(@Argument String id) {
        return fileNetService.getDocumentById(id);
    }

    @QueryMapping
    public List<DocumentWrapper> searchDocuments(@Argument String folderPath) {
        return fileNetService.searchDocuments(folderPath);
    }
}
