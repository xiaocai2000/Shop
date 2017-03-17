package com.deviser.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.deviser.service.AccountService;
import com.deviser.shop.model.Account;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

}
