package com.ilarahealth.management_module.mappers;

import com.ilarahealth.management_module.dto.OrganizationDto;
import javax.annotation.processing.Generated;
import org.hl7.fhir.r4.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T18:04:24+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class OrganizationMapperImpl extends OrganizationMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Organization organizationDtoToOrganization(OrganizationDto organizationDto) {
        if ( organizationDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( organizationDto.getName() );
        organization.setAddress( addressMapper.addressDtoToAddressList( organizationDto.getAddress() ) );

        return organization;
    }
}
