package br.com.healthhelper.customer.app.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserResponse {

    private UUID id;
    private String name;
    private String document;
    private LocalDate birthDate;
    private String indication;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String cep;
    private String cellphone;
}
