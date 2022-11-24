package fr.dlmr.ws.controllers;

import fr.dlmr.ws.exceptions.ApiException;
import fr.dlmr.ws.mappers.iAccountMapper;
import fr.dlmr.ws.models.dao.Account;
import fr.dlmr.ws.models.dto.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fr.dlmr.ws.services.account.iAccountService;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController
{
	private iAccountService service;

	public AccountController(iAccountService service)
	{
		super();
		this.service = service;
	}

	@PostMapping("/accounts")
	public ResponseEntity<AccountDto> postAccount (@RequestBody @Valid AccountDto account, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			throw new ApiException("Invalid fields", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(service.postAccount(account), HttpStatus.CREATED);
	}

	@DeleteMapping("/accounts/{id}")
	public Account delAccount (@PathVariable int id)
	{
		return service.delAccount(id);
	}

	@GetMapping("/accounts")
	public List<Account> getAllAccounts ()
	{
		return service.getAllAccount();
	}

	@GetMapping("/accounts/{id}")
	public Account getAccount (@PathVariable int id)
	{
		return service.getAccountByID(id);
	}

	@DeleteMapping("/accounts")
	public void deleteAllAccounts ()
	{
		service.getAllAccount().forEach(account -> service.delAccount(account.getAccountId()));
	}
}
