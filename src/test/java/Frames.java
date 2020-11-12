import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import static com.codeborne.selenide.Selenide.*;

public class Frames {
    String urlIFrame = "https://the-internet.herokuapp.com/iframe";
    String titleIFrame = "An iFrame containing the TinyMCE WYSIWYG Editor";
    SelenideElement iFrameTitle = $(By.xpath("//h3[contains(text(),'An iFrame containing')]"));
    SelenideElement buttonEdit =$("#mceu_16-open");
    SelenideElement undoDD = $(By.xpath("//span[(contains(text(),'Undo'))]"));
    String newText = "Testing iFrame";

    @Test
    public void workWithIFrame(){
        open(urlIFrame);
        assert (iFrameTitle.getText()).equals(titleIFrame);
        WebDriver editor = switchTo().frame("mce_0_ifr");
        String text = editor.findElement(By.id("tinymce")).getText();
        editor.findElement(By.id("tinymce")).clear();
        editor.findElement(By.id("tinymce")).sendKeys(newText);
        assert (!text.equals(newText));
        assert (editor.findElement(By.id("tinymce")).getText().equals(newText));
    }

    @Test
    public void workWithIFrameEditor(){
        open(urlIFrame);
        assert (iFrameTitle.getText()).equals(titleIFrame);
        WebDriver editor = switchTo().frame("mce_0_ifr");
        String text = editor.findElement(By.id("tinymce")).getText();
        editor.findElement(By.id("tinymce")).clear();
        assert (!editor.findElement(By.id("tinymce")).getText().equals(text));
        editor.findElement(By.id("tinymce")).sendKeys(newText);
        assert (editor.findElement(By.id("tinymce")).getText().equals(newText));
        switchTo().parentFrame();
        buttonEdit.click();
        undoDD.click();
        String content = switchTo().frame("mce_0_ifr").findElement(By.id("tinymce")).getText();
        assert (content.isEmpty());
    }
}