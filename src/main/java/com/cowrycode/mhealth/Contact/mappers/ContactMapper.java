package com.cowrycode.mhealth.Contact.mappers;

import com.cowrycode.mhealth.Contact.domains.ContactEntity;
import com.cowrycode.mhealth.Contact.models.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDTO entityToDTO (ContactEntity userProfile);
    ContactEntity DTOtoEntity(ContactDTO userProfileDTO);
}
