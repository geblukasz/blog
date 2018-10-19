package com.akademiakodu.blog.models.forms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//todo czy generuje blad Lombok
@Getter
@Setter
@ToString(exclude = "password")
public class LoginForm {

    private String userName;
    private String password;


}
