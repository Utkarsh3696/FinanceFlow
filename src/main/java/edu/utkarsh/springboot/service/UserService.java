package edu.utkarsh.springboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.utkarsh.springboot.dto.Income;
import edu.utkarsh.springboot.dto.Spend;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.repo.IncomeRepo;
import edu.utkarsh.springboot.repo.SpendRepo;
import edu.utkarsh.springboot.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private SpendRepo spendRepo;
	
	@Autowired
  	private IncomeRepo incomeRepo;
	


	
	
	
	
	public User addUser(User user) {
		User save = repo.save(user);
		return save;
	}

	public List<User> findAllUsers() {
		
		List<User> all = repo.findAll();
		return all;
		
	}

	public User findUserByID(int id) {
		
		try {
		Optional<User> byId = repo.findById(id);
		return byId.get();
		}catch(NoSuchElementException e)
		{
			return null;
		}
	}

	
	public List<User> deleteUserById(int id) {
		Optional<User> byId = repo.findById(id);
		User user =null;
		try {
		 user = byId.get();
		}catch(NoSuchElementException e)
		{
			user = null;
		}
		
		if(user!=null) {
		repo.deleteById(id); 
		return repo.findAll();
		}
		else
		return repo.findAll();
	}

	public User findByEmailAndPassword(String email, String password) {
		//User user = repo.findbyEmailAndPassword(email,password);
		User user = repo.findByEmailAndPassword(email,password);
		return user;
		
	}

	public User mapSpendToUser(int uid, int sid) {
		User user = repo.findById(uid).get();
		Spend spend = spendRepo.findById(sid).get();
		
		List<Spend> spendList = user.getSpendList();
		spendList.add(spend);
		return repo.save(user);
		
	}

	public User maIncomeToUser(int uid, int iid) {
		User user = repo.findById(uid).get();
		Income income = incomeRepo.findById(iid).get();
		
		List<Income> incomeslist = user.getIncomeslist();
		incomeslist.add(income);
		user.setIncomeslist(incomeslist);
		
		return repo.save(user);
	}

	public String encodePass(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(password);
		
		
	}

	public User findUserByEmail(String email) {
	
		return repo.findByEmail(email);
		
	}

	public boolean mathcpass(String password, String password2) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder.matches(password, password2);
		
	}

	public User UpdateUser(User user, int uid) {
		
		User user2 = repo.findById(uid).get();
		
		user2.setEmail(user.getEmail());
		user2.setName(user.getName());
		user2.setMobile(user.getMobile());
		
		
		
		return repo.save(user2);
	}

	
	
	
	
	
}
