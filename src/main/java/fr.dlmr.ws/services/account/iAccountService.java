package fr.dlmr.ws.services.account;

import fr.dlmr.ws.models.dao.Account;
import fr.dlmr.ws.models.dto.AccountDto;

import java.util.List;

public interface iAccountService
{
	public AccountDto postAccount (AccountDto account);
	public Account delAccount (int id);
	public List<Account> getAllAccount ();
    public Account getAccountByID(int id);
}
