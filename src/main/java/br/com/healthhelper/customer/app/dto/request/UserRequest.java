package br.com.healthhelper.customer.app.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {

    private String name;
    private String document;
    private LocalDate birthDate;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String cep;
    private String cellphone;
    private String email;
}
