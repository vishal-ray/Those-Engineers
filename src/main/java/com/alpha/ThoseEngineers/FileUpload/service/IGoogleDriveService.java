package com.alpha.ThoseEngineers.FileUpload.service;

import com.google.api.services.drive.Drive;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface IGoogleDriveService {
    public boolean upload(MultipartFile file) throws GeneralSecurityException, IOException;

    public Drive getDrive() throws GeneralSecurityException, IOException;
}
