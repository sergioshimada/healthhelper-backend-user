package br.com.healthhelper.customer.app.listerner.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateUserMessage {

    private UUID id;
    private String name;
    private String document;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
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
