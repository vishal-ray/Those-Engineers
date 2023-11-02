package com.alpha.ThoseEngineers.controllers.jobs;

import com.alpha.ThoseEngineers.FileUpload.service.IUploadFileService;
import com.alpha.ThoseEngineers.ThoseEngineersApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class UploadFileController {
    @Autowired
    public IUploadFileService iUploadFileService;
    private static final Logger log = LoggerFactory.getLogger(ThoseEngineersApplication.class);
    @PostMapping(value = "/upload",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadSingleFile(@RequestBody MultipartFile file) {
        log.info("Request contains, File: " + file.getOriginalFilename());
        String fileId = iUploadFileService.uploadFile(file, "ThoseEngineers");
        if(fileId == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        String fileLink = "drive.google.com/file/d/" + fileId + "/view?usp=sharing";
        return ResponseEntity.ok(fileLink);
    }
}
