package fr.dlmr.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.dlmr.ws.models.dao.Account;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iAccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findAccountByFirstNameAndLastName (@Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName);

}

