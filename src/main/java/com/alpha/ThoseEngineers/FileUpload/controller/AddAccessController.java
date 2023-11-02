package com.alpha.ThoseEngineers.FileUpload.controller;

import com.alpha.ThoseEngineers.FileUpload.service.IAddAccessService;
import com.alpha.ThoseEngineers.ThoseEngineersApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;


@RestController
public class AddAccessController {
    @Autowired
    public IAddAccessService iAddAccessService;
    private static final Logger log = LoggerFactory.getLogger(ThoseEngineersApplication.class);
    @PostMapping(value = "/addAccess")
    public ResponseEntity<String> addAccess(@RequestParam(required = true) String fileId, String emailID) throws GeneralSecurityException, IOException {
        iAddAccessService.addAccess(fileId,emailID);
        return ResponseEntity.ok("FileID : " + fileId + "Shareable Link : drive.google.com/file/d/" + fileId + "/view?usp=sharing");
    }
}
