package fr.dlmr.ws.models.dto;

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
public class BankDetailDto
{
	@Size(min=15, max=35)
	@NotNull
	@NotEmpty
	private String iban;
}
