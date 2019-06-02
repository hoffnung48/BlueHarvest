package mx.com.blueharvest.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.blueharvest.commons.exception.BusinessServiceException;
import mx.com.blueharvest.commons.validator.Validator;
import mx.com.blueharvest.controller.AccountController;
import mx.com.blueharvest.model.dto.AccountDto;
import mx.com.blueharvest.model.dto.URLDto;
import mx.com.blueharvest.service.AccountService;

@Controller
public class AccountControllerImpl implements AccountController {

	@Autowired
	private AccountService service;

	@Autowired
	private Validator validator;

	@ApiOperation(value = "create an account", notes = "This endpoint get an especific account", response = HttpStatus.class, tags = {
			"Account" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The confirmation code.", response = URLDto.class),
			@ApiResponse(code = 400, message = "service not found"),
			@ApiResponse(code = 500, message = "Bussines service ERROR", response = BusinessServiceException.class) })
	@RequestMapping(value = "/account", produces = { "application/json" }, method = RequestMethod.POST)
	@Override
	public ResponseEntity<URLDto> createAccount(@RequestBody AccountDto account) {

		validator.isNull(account);
		validator.isNull(account.getCustomerId());

		return new ResponseEntity<>(service.createAccount(account), HttpStatus.OK);
	}

	@ApiOperation(value = "create an account", notes = "This endpoint create an account from existing customer", response = HttpStatus.class, tags = {
			"Account" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The confirmation code.", response = AccountDto.class),
			@ApiResponse(code = 400, message = "service not found"),
			@ApiResponse(code = 500, message = "Bussines service ERROR", response = BusinessServiceException.class) })
	@RequestMapping(value = "/account/{accountId}", produces = { "application/json" }, method = RequestMethod.GET)
	@Override
	public ResponseEntity<AccountDto> getAccount(@PathVariable long accountId) {
		return new ResponseEntity<>(service.getAccount(accountId), HttpStatus.OK);
	}

}
