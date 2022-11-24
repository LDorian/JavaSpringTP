package fr.dlmr.ws.controllers;

import fr.dlmr.ws.models.dto.BankDetailDto;
import fr.dlmr.ws.services.bank.iBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BankController
{
	private iBankService service;

	public BankController(iBankService service)
	{
		super();
		this.service = service;
	}

	@GetMapping("/bankdetails/{firstname}/{lastname}")
	public ResponseEntity<List<BankDetailDto>> getBank (@PathVariable String firstname, @PathVariable String lastname)
	{
		return new ResponseEntity<>(service.getBankDetail(firstname, lastname), HttpStatus.OK);
	}

	@PostMapping("/bankdetails/{firstname}/{lastname}")
	public ResponseEntity<BankDetailDto> postBank (@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname, @RequestBody BankDetailDto bankdetail)
	{
		return new ResponseEntity<>(service.postBankDetail(firstname, lastname, bankdetail), HttpStatus.CREATED);
	}


}
