package com.ilarahealth.management_module.services

import ca.uhn.fhir.rest.api.PreferReturnEnum
import com.ilarahealth.management_module.dto.OrganizationDto
import com.ilarahealth.management_module.mappers.OrganizationMapper
import com.ilarahealth.management_module.models.HapiClient
import org.hl7.fhir.r4.model.Bundle
import org.hl7.fhir.r4.model.Organization
import org.springframework.stereotype.Service

@Service
class OrganizationService(val hapiClient: HapiClient,
                          val organizationMapper: OrganizationMapper) {

    fun createOrganization(organizationDto: OrganizationDto): String {
        val resource = organizationMapper.organizationDtoToOrganization(organizationDto)
        val methodOutcome = hapiClient.client.create()
                .resource(resource)
                .prefer(PreferReturnEnum.REPRESENTATION)
                .prettyPrint()
                .encodedJson()
                .execute()

        return hapiClient.fhirContext.newJsonParser()
                .setPrettyPrint(true)
                .encodeResourceToString(methodOutcome.resource)
    }

    //TODO - Implement the search for organization business logic here
    fun searchForOrganization(): String {
        val query = hapiClient.client
            .search<Bundle>()
            .forResource(Organization::class.java)

        val resultBundle = query.returnBundle(Bundle::class.java).execute()
        return hapiClient.fhirContext
            .newJsonParser()
            .encodeResourceToString(resultBundle)
    }

    fun searchForOrganization(organization:String): String {
        val query = hapiClient.client
            .search<Bundle>()
            .forResource(Organization::class.java)
            .where(Organization.NAME.matches().value(organization))

        val resultBundle = query.returnBundle(Bundle::class.java).execute()
        return hapiClient.fhirContext
            .newJsonParser()
            .encodeResourceToString(resultBundle)
    }
}