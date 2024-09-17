package objectData;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidareProfil extends GeneralObject{
    private String nameElementValidate;
    private String lastNameElementValidate;
    private String emailElementValidate;
    private String phoneElementValidate;

    public ValidareProfil(String filePath) {
        fromJsonToObject(filePath);
    }

}
