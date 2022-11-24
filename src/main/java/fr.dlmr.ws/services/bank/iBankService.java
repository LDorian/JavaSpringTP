package fr.dlmr.ws.services.bank;

import fr.dlmr.ws.models.dto.BankDetailDto;

import java.util.List;

public interface iBankService {

    public BankDetailDto postBankDetail(String firstname, String lastname, BankDetailDto bankDetail);
    public List<BankDetailDto> getBankDetail(String firstname, String lastname);

    public BankDetailDto delBankDetail(int id);

}
