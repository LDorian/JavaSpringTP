package fr.dlmr.ws.services.bank;

import fr.dlmr.ws.exceptions.ApiException;
import fr.dlmr.ws.mappers.iBankMapper;
import fr.dlmr.ws.models.dao.Account;
import fr.dlmr.ws.models.dao.BankDetail;
import fr.dlmr.ws.models.dto.BankDetailDto;
import fr.dlmr.ws.repositories.iAccountRepository;
import fr.dlmr.ws.repositories.iBankRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements iBankService{

    private iBankRepository repository;
    private iAccountRepository accountRepository;
    private iBankMapper mapper;

    public BankService (iBankRepository repository, iBankMapper mapper, iAccountRepository accountRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.accountRepository = accountRepository;
    }

    public BankDetailDto postBankDetail(String firstname, String lastname, BankDetailDto bankDetail)
    {
        BankDetail bankDetailDao = mapper.bankDtoToBank(bankDetail);

        if (!bankDetailDao.getIban().matches("^[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}$"))
            throw new ApiException("IBAN is not in the right format", HttpStatus.BAD_REQUEST);

        if (!repository.findBankDetailByIban(bankDetailDao.getIban()).isEmpty())
            throw new ApiException("IBAN already exists", HttpStatus.CONFLICT);

        try {
            Account account = accountRepository.findAccountByFirstNameAndLastName(firstname, lastname).get(0);
            bankDetailDao.setAccount(account);
            repository.save(bankDetailDao);
        } catch (Exception e) {
            throw new ApiException("Account not found", HttpStatus.NOT_FOUND);
        }

        return bankDetail;
    }

    public List<BankDetailDto> getBankDetail(String firstname, String lastname) {

        try{
            Account account = accountRepository.findAccountByFirstNameAndLastName(firstname, lastname).get(0);
            List<BankDetail> bankDetail = repository.findBankDetailByAccount(account);
            return bankDetail.stream().map(mapper::bankToBankDetailDto).toList();

        } catch (Exception e) {
            throw new ApiException("Account not found", HttpStatus.NOT_FOUND);
        }
    }

    public BankDetailDto delBankDetail(int id) {
        return null;
    }
}
