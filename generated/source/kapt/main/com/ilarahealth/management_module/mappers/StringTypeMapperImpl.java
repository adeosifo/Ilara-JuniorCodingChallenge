package com.ilarahealth.management_module.mappers;

import javax.annotation.processing.Generated;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T18:04:24+0100",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class StringTypeMapperImpl extends StringTypeMapper {

    @Override
    public StringType stringToStringType(String string) {
        if ( string == null ) {
            return null;
        }

        StringType stringType = new StringType();

        return stringType;
    }
}
