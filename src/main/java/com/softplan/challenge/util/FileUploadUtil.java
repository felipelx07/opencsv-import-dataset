package com.softplan.challenge.util;

import com.softplan.challenge.model.Caers;
import org.apache.commons.io.FileUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.model.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUploadUtil {

    /*
     * This get the FileUpload from JSF View
     * Make some validations
     * and convert the .csv file to List of Bean (Caers)
     */
    public static List<Caers> upload(UploadedFile file) throws IOException {
        List<Caers> beanListFromCSV = new ArrayList<>();
        if (file.getFileName() != null) {
            if (file.getContentType().contains("application/vnd.ms-excel")) {
                File destFile = new File("target/tmp/", file.getFileName());
                FileUtils.copyInputStreamToFile(file.getInputstream(), destFile);
                beanListFromCSV = OpenCSVUtil.parse(destFile);
            } else {
                FacesUtil.ERROR_MESSAGE("Incorrect Type File");
            }
        } else {
            FacesUtil.ERROR_MESSAGE("File cannot be null");
        }
        PrimeFaces.current().executeScript("PF('loadingDlg').hide();");
        return beanListFromCSV;
    }
}
