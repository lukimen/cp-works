package com.cpworks.controller;

import com.cpworks.dao.AccountDaoService;
import com.cpworks.model.BaseResponse;
import com.cpworks.model.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cp-works/account")
@Api(value = "Account Controller")
public class AccountController {

	@Autowired
	private AccountDaoService accountDaoService;

	@ApiOperation(value = "register", notes = "register account")
	@GetMapping("/register")
	public BaseResponse<String> register(
			@RequestParam(required = true) String email,
			@RequestParam(required = true) String password) {

		accountDaoService.register(email, password);

		return BaseResponse.<String>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data("Register Sukses")
				.build();
	}

}