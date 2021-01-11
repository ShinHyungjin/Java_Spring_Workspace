package com.koreait.fashionshop.model.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koreait.fashionshop.model.bank.repository.SbankDAO;
import com.koreait.fashionshop.exception.DepositFailException;
import com.koreait.fashionshop.exception.WithdrawFailException;
import com.koreait.fashionshop.model.bank.repository.KbankDAO;

@Service
public class BankServiceImpl implements BankService{
	@Autowired
	private KbankDAO kbankDAO; 
	@Autowired
	private SbankDAO sbankDAO;
	
	@Override
	public void send(int money) throws DepositFailException, WithdrawFailException{
		kbankDAO.withdraw(money);
		sbankDAO.deposit(money);
	}
	
}
