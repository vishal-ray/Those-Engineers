package com.alpha.ThoseEngineers.FileUpload.service;

import com.google.api.services.drive.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.GeneralSecurityException;


@Service
public class AddAccessService implements IAddAccessService{
    @Autowired
    public IGoogleDriveService iGoogleDriveService;

   public String addAccess(String fileID, String emailID) throws GeneralSecurityException, IOException {
       Permission permission = new Permission();
       permission.setType("user")
               .setRole("reader")
               .setEmailAddress(emailID);
       iGoogleDriveService.getDrive()
               .permissions()
               .create(fileID,permission)
               .execute();
       return fileID;
   }

}
