package fr.dlmr.ws.mappers;

import fr.dlmr.ws.models.dao.BankDetail;
import fr.dlmr.ws.models.dto.BankDetailDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface iBankMapper
{
	BankDetailDto bankToBankDetailDto (BankDetail bankDetail);
	BankDetail bankDtoToBank (BankDetailDto bankDetail);

}
