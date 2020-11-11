import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UploadFiles {
    String path = "D:\\Automation\\File_Upload\\";
    String fileName = "Test1.txt";
    String url_UploadFile = "https://the-internet.herokuapp.com/upload";
    SelenideElement fileUploadButton = $(By.id("file-upload"));
    SelenideElement fileSubmitButton = $(By.id("file-submit"));
    SelenideElement uploadedFiles = $(By.id("uploaded-files"));

    @Test
    public void fileUpload(){
        open(url_UploadFile);
        fileUploadButton.sendKeys(path + fileName);
        fileSubmitButton.click();
        assertThat (uploadedFiles.getText(),is(equalTo(fileName)));
    }
}
