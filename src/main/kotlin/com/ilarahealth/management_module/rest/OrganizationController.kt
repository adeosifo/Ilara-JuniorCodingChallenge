package com.ilarahealth.management_module.rest

import com.ilarahealth.management_module.dto.OrganizationDto
import com.ilarahealth.management_module.models.GenericSerializedResponse
import com.ilarahealth.management_module.services.OrganizationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("organization")
class OrganizationController(val organizationService: OrganizationService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrganization(@RequestBody organizationDto: OrganizationDto) : GenericSerializedResponse {
        var organization = organizationService.createOrganization(organizationDto)
        return GenericSerializedResponse(
                "OK",
                organization
        )
    }

    //TODO - Implement the search for organization endpoint here
    @GetMapping
    fun searchForOrganization() : GenericSerializedResponse {
        var resultString = organizationService.searchForOrganization()
        return GenericSerializedResponse(
            "OK",
            resultString
        )
    }

   // fun searchOrganization(@Req)
}