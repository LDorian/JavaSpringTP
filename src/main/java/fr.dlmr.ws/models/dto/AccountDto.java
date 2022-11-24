package fr.dlmr.ws.models.dto;

import fr.dlmr.ws.models.dao.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto
{
	@Size(min=3, max=15)
	@NotNull
	@NotEmpty
	private String firstName;
	private String lastName;
	private AddressDto address;
}
