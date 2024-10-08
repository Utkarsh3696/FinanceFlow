package edu.utkarsh.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utkarsh.springboot.dto.Income;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.repo.IncomeRepo;
import edu.utkarsh.springboot.repo.UserRepo;

@Service
public class IncomeService {

	@Autowired 
	private  IncomeRepo incomeRepo;
	
	@Autowired
 	private  UserRepo repo;
	 
	public Income addIncome(Income income) {
		Income save = incomeRepo.save(income);
		return save;
	}

	public User deleteIncome(int uid, int iid) {
	User user = repo.findById(uid).get();
	Income income = incomeRepo.findById(iid).get();
	List<Income> incomeslist = user.getIncomeslist();
	boolean f = false;
	for (Income i : incomeslist) {
		if(i.equals(income))
		{
			f = true;
		}
	}
		
	if(f)
	{
		incomeslist.remove(income);
	}
	user.setIncomeslist(incomeslist);
	incomeRepo.delete(income);
	return  repo.save(user);
		
	}

	public User updateIncome(Income income, int uid, int iid) {
		User user = repo.findById(uid).get();
		
		Income income1 = incomeRepo.findById(iid).get();
		
		income1.setDate(income.getDate());
		income1.setIncome_name(income.getIncome_name());
		income1.setRs(income.getRs());
		
		incomeRepo.save(income);
	 	return repo.save(user);
		
	}

	public Income findIncome(int iid) {
		try { return incomeRepo.findById(iid).get();}
		catch(Exception e)
		{
			return null;
		}
		
	}

}
