package com.cowrycode.mhealth.Contact.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String imgURL;

    @PreUpdate
    public void onUpdate() {
        setDateUpdated(LocalDateTime.now());
    }
}
