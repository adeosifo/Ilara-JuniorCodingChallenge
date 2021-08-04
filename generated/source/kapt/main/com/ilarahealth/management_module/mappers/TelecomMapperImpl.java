package com.ilarahealth.management_module.mappers;

import javax.annotation.processing.Generated;
import org.hl7.fhir.r4.model.ContactPoint;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T18:04:24+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class TelecomMapperImpl extends TelecomMapper {

    @Override
    public ContactPoint phoneNumberToContactPoint(String phoneNumber) {
        if ( phoneNumber == null ) {
            return null;
        }

        ContactPoint contactPoint = new ContactPoint();

        contactPoint.setValue( phoneNumber );

        return contactPoint;
    }
}
