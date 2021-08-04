package com.ilarahealth.management_module.mappers;

import com.ilarahealth.management_module.dto.PractitionerDto;
import javax.annotation.processing.Generated;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T18:04:24+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class PractitionerMapperImpl extends PractitionerMapper {

    @Autowired
    private HumanNameMapper humanNameMapper;
    @Autowired
    private TelecomMapper telecomMapper;

    @Override
    public Practitioner practitionerDtoToPractitioner(PractitionerDto practitionerDto) {
        if ( practitionerDto == null ) {
            return null;
        }

        Practitioner practitioner = new Practitioner();

        practitioner.setTelecom( telecomMapper.phoneNumberToContactPointList( practitionerDto.getPhoneNumber() ) );
        practitioner.setName( humanNameMapper.humanNameDtoToHumanNameList( practitionerDto.getName() ) );
        if ( practitionerDto.getGender() != null ) {
            practitioner.setGender( Enum.valueOf( AdministrativeGender.class, practitionerDto.getGender() ) );
        }

        return practitioner;
    }
}
