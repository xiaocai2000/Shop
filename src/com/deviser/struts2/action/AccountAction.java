package com.deviser.struts2.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.deviser.shop.model.Account;

@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	private static final long serialVersionUID = -7802106106473811278L;

	public String query() {
		jsonList = accountService.query();
		return "jsonList";
	}
}
