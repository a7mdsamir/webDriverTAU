package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        String imgName = "DSC_0430.jpg";
        String imgPath = System.getProperty("user.dir") + "/Uploads/" + imgName ;

        uploadPage.uploadFile(imgPath);
        assertEquals(uploadPage.getUploadedFiles(), imgName, "Uploaded files incorrect");
    }
}
