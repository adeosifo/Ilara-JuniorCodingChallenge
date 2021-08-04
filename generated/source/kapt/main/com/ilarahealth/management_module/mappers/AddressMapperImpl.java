package com.ilarahealth.management_module.mappers;

import com.ilarahealth.management_module.dto.AddressDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T18:04:24+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl extends AddressMapper {

    @Autowired
    private StringTypeMapper stringTypeMapper;

    @Override
    public Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setDistrict( addressDto.getTown() );
        address.setState( addressDto.getCounty() );
        address.setText( addressDto.getText() );
        address.setLine( stringListToStringTypeList( addressDto.getLine() ) );
        address.setCity( addressDto.getCity() );
        address.setCountry( addressDto.getCountry() );

        return address;
    }

    protected List<StringType> stringListToStringTypeList(List<String> list) {
        if ( list == null ) {
            return null;
        }

        List<StringType> list1 = new ArrayList<StringType>( list.size() );
        for ( String string : list ) {
            list1.add( stringTypeMapper.stringToStringType( string ) );
        }

        return list1;
    }
}
