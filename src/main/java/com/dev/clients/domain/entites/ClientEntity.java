package com.dev.clients.domain.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cellphone_number")
    private String cellphoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "observation")
    private String observation;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "disabling_date")
    private LocalDateTime disablingDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public ClientEntity(
            String code,
            String name,
            String email,
            String documentNumber,
            String phoneNumber,
            String cellphoneNumber,
            String gender,
            LocalDateTime birthday,
            String observation
    ) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.cellphoneNumber = cellphoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.observation = observation;
        this.disablingDate = null;
    }
}
