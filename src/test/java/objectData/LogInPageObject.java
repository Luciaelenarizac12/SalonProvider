package objectData;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;


@Getter
@Setter
public class LogInPageObject extends GeneralObject{
    private String emailValue;
    private String passwordValue;

    public LogInPageObject(String filePath) {
        fromJsonToObject(filePath);
    }


}
