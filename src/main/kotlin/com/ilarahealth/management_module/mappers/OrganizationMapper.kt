package com.ilarahealth.management_module.mappers

import com.ilarahealth.management_module.dto.AddressDto
import com.ilarahealth.management_module.dto.OrganizationDto
import org.hl7.fhir.r4.model.Address
import org.hl7.fhir.r4.model.Organization
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", uses = [AddressMapper::class, TelecomMapper::class])
abstract class OrganizationMapper {

    @Mapping(source = "phoneNumbers", target = "telecom", ignore = true)
    abstract fun organizationDtoToOrganization(organizationDto: OrganizationDto) : Organization

    fun organizationDtoToOrganizationList(organizationDto: OrganizationDto) : List<Organization> {
        return listOf(organizationDtoToOrganization(organizationDto))
    }


}