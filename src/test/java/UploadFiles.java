import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UploadFiles {
    String path = "D:\\Automation\\MyProject\\src\\main\\resources\\";
    String fileName = "Test1.txt";
    String urlUploadFile = "https://the-internet.herokuapp.com/upload";
    SelenideElement fileUploadButton = $("#file-upload");
    SelenideElement fileSubmitButton = $("#file-submit");
    SelenideElement uploadedFiles = $("#uploaded-files");

    @Test
    public void fileUpload(){
        open(urlUploadFile);
        fileUploadButton.sendKeys(path + fileName);
        fileSubmitButton.click();
        assertThat (uploadedFiles.getText(),is(equalTo(fileName)));
    }
}
