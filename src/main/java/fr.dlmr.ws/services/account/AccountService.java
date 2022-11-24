package fr.dlmr.ws.services.account;

import fr.dlmr.ws.exceptions.ApiException;
import fr.dlmr.ws.mappers.iAccountMapper;
import fr.dlmr.ws.models.dao.Account;
import fr.dlmr.ws.models.dto.AccountDto;
import fr.dlmr.ws.repositories.iAccountRepository;
import fr.dlmr.ws.services.address.iAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements iAccountService
{
	private iAccountRepository repository;
	private iAddressService addressService;
	private iAccountMapper mapper;

	public AccountService (iAccountRepository repository, iAccountMapper mapper, iAddressService addressService)
	{
		super();
		this.repository = repository;
		this.mapper = mapper;
		this.addressService = addressService;
	}

	public AccountDto postAccount (AccountDto account)
	{
		if (!repository.findAccountByFirstNameAndLastName(account.getFirstName(), account.getLastName()).isEmpty())
		{
			throw new ApiException("Account already exists", HttpStatus.CONFLICT);
		}

		if(!addressService.checkAddress(account.getAddress()))
		{
			throw new ApiException("Valid address is required", HttpStatus.NOT_ACCEPTABLE);
		}

		repository.save(mapper.accountDtoToAccount(account));
		return account;
	}

	public Account delAccount (int id)
	{
		Account account = repository.findById(id).orElseThrow(() -> new ApiException("Account not found", HttpStatus.NOT_FOUND));
		repository.delete(account);
		return account;
	}

	public List<Account> getAllAccount ()
	{
		return repository.findAll();
	}

	public Account getAccountByID(int id) {
		return repository.findById(id).orElse(null);
	}

}
