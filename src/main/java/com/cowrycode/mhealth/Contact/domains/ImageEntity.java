package com.cowrycode.mhealth.Contact.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity extends BaseEntity {
    @Lob
    private byte[] data;

}
