package com.akademiakodu.blog.models.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString(exclude = "password")
public class RegisterForm {

    @Size(min = 6, message = "Nazwa uzytkownika musi posiadac minimum {min} znakow. Podana fraza ${validatedValue} nie pasuje do tych wytycznych")
    private String userName;
    @Pattern(regexp = "[A-z0-9.]+@[a-z0-9\\-]+\\.[a-z]{2,5}", message = "Podaj prawidlowy email.")
    private String email;
    @Size(min = 6, max = 10, message = "Hasło musi zawierać przynajmniej {min} oraz maksymalnie {max} znaków")
    private String password;


}
