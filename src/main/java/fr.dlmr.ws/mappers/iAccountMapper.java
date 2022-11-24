package fr.dlmr.ws.mappers;

import fr.dlmr.ws.models.dao.Account;
import fr.dlmr.ws.models.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface iAccountMapper
{
	AccountDto accountToAccountDto (Account account);
	Account accountDtoToAccount (AccountDto account);
}
