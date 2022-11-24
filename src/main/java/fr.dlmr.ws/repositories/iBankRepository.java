package fr.dlmr.ws.repositories;

import fr.dlmr.ws.models.dao.Account;
import fr.dlmr.ws.models.dao.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface iBankRepository extends JpaRepository<BankDetail, Integer> {

    List<BankDetail> findBankDetailByAccount(@Param("account") Account account);
    List<BankDetail> findBankDetailByIban(@Param("iban") String iban);
}

