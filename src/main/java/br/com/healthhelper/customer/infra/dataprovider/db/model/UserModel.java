package br.com.healthhelper.customer.infra.dataprovider.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_user")
public class UserModel {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String document;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(nullable = false)
    private String cellphone;
    @Column(nullable = false)
    private String email;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String cep;
}