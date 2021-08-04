package com.ilarahealth.management_module

import com.ilarahealth.management_module.dto.AddressDto
import com.ilarahealth.management_module.dto.HumanNameDto
import com.ilarahealth.management_module.dto.OrganizationDto
import com.ilarahealth.management_module.dto.PractitionerDto
import com.ilarahealth.management_module.mappers.OrganizationMapper
import com.ilarahealth.management_module.mappers.PractitionerMapper
import com.ilarahealth.management_module.mappers.PractitionerMapperImpl
import com.ilarahealth.management_module.rest.PractitionerController
import com.ilarahealth.management_module.services.PractitionerService
import org.assertj.core.api.Assertions.assertThat
import org.hl7.fhir.r4.model.HumanName
import org.hl7.fhir.r4.model.Organization
import org.hl7.fhir.r4.model.Practitioner
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import org.mapstruct.factory.Mappers.getMapper
import org.springframework.boot.test.context.SpringBootTest
import java.lang.constant.ConstantDescs.NULL

@SpringBootTest
class ManagementModuleApplicationTests {

	@Test
	fun contextLoads() {
		val mapper = getMapper(PractitionerMapper::class.java)


		//val practitionerService = PractitionerService()
		//var practitionerDto: PractitionerDto? =
			PractitionerDto(HumanNameDto("Smith", "John", "Mr."), "male", "07738699474")

		val practitioner : Practitioner = mapper.practitionerDtoToPractitioner(PractitionerDto(HumanNameDto("Smith", "John", "Mr."), "male", "07738699474"))
		//var practitioner: Practitioner? = practitionerDto?.let { mapper.practitionerDtoToPractitioner(it) }

		//val humanName : HumanNameDto
		//val humanName : HumanNameDto = HumanNameDto("Smith", "John", "Mr.")

		//val practitionerDto =  PractitionerDto(HumanNameDto("Smith", "John", "Mr."), "male", "07738699474")

		//then
		//var practitioner = Practitioner() = mapper.p

		assertThat(practitioner).isNotNull
		/*assertThat(practitioner.name.given == practitionerDto?.name?.firstName)
		assertThat(practitioner?.name?.family == practitionerDto?.name?.lastName)
		assertThat(practitioner?.name?.prefix == practitionerDto?.name?.prefix)*/
		assertThat(practitioner.gender).isEqualTo("male")
		assertThat(practitioner.telecom).isEqualTo("0123 334466")
		println("was null")


	}

		/*
		if ((mapper.practitionerDtoToPractitioner(practitionerDto))==null){

		}
		else
		{
			practitioner = mapper.practitionerDtoToPractitioner(practitionerDto)
			assertThat(practitioner).isNotNull
			assertThat(practitioner.name).isEqualTo("John Smith")
			assertThat(practitioner.gender).isEqualTo("male")
			assertThat(practitioner.telecom).isEqualTo("0123 334466")
		}

		 */



		/*
		if (practitioner == null)
		{
			practitioner = mapper.practitionerDtoToPractitioner(practitionerDto)
			//assertThat(practitioner).isNotNull
		}
		else{
return
		}
		assertThat(practitioner).isNotNull
		assertThat(practitioner?.name).isEqualTo("John Smith")
		assertThat(practitioner?.gender).isEqualTo("male")
		assertThat(practitioner?.telecom).isEqualTo("0123 334466")
	}

		 */

		/*
		if (practitionerDto!=null)
		{
			val practitioner = mapper.practitionerDtoToPractitioner(practitionerDto)
			if (practitioner!=null)
			{
				assertThat(practitioner).isNotNull
				assertThat(practitioner.name).isEqualTo("John Smith")
				assertThat(practitioner.gender).isEqualTo("male")
				assertThat(practitioner.telecom).isEqualTo("0123 334466")
			}
		}
	*/



	/*
	@Test
	fun testConvertDtoToPractitioner() {
		val mapper = getMapper(PractitionerMapper::class.java)

		//val humanName : HumanNameDto
		val humanName = HumanNameDto("Smith", "John", "Mr.")


		val practitionerDto: PractitionerDto = PractitionerDto(humanName, "male", "0123334466")
		//val practitionerDto = PractitionerDto(humanName, "male", "0123 334466")

			val practitioner = mapper.practitionerDtoToPractitioner(practitionerDto)
			assertThat(practitioner).isNotNull()
			assertThat(practitioner.name).isEqualTo("John Smith")
			assertThat(practitioner.gender).isEqualTo("male")
			assertThat(practitioner.telecom).isEqualTo("0123 334466")
*/

}
