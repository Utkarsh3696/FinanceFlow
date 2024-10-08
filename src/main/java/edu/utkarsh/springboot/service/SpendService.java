package edu.utkarsh.springboot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import edu.utkarsh.springboot.dto.Spend;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.repo.SpendRepo;
import edu.utkarsh.springboot.repo.UserRepo;

@Service
public class SpendService {

	@Autowired
	private SpendRepo spendRepo;
	
	@Autowired
	private UserRepo userRepo;

	public Spend addSpend(Spend spend) {
		
		 return spendRepo.save(spend);
		
	}

	public User deleteSpend(int uid, int sid) {
		 Spend spend = spendRepo.findById(sid).get();
		 User user = userRepo.findById(uid).get();
		 
		 List<Spend> spendList = user.getSpendList();
		 spendList.remove(spend);
		 user.setSpendList(spendList);
		 User save = userRepo.save(user);
		 spendRepo.delete(spend);
		 return save;
		
	}

	public Spend findSpendById(int sid) {
		try { 
		return spendRepo.findById(sid).get();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public User updateIncome(Spend spend, int uid, int sid) {
		
		User user = userRepo.findById(uid).get();
	
		Spend spend2 = spendRepo.findById(sid).get();
		
		spend2.setDate(spend.getDate());
		spend2.setSpendName(spend.getSpendName());
		spend2.setRs(spend.getRs());
		
		spendRepo.save(spend2);
	 	return userRepo.save(user);
		
		
		

	}
	
	
}
