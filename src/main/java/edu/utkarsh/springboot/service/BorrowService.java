package edu.utkarsh.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utkarsh.springboot.dto.Borrow;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.repo.BorrowRepo;
import edu.utkarsh.springboot.repo.UserRepo;

@Service
public class BorrowService {

	@Autowired
	private BorrowRepo borrowRepo;
	
	@Autowired
	private UserRepo userRepo;
	

	
	public Borrow addBorrow(Borrow borrow) {
		
		return borrowRepo.save(borrow);
		
	}

	public User mapBorrowToUser(int uid, int bid) {
		
		  User user = userRepo.findById(uid).get();
		  Borrow borrow = borrowRepo.findById(bid).get();
		  List<Borrow>  borrowList = user.getBorrowslist();
		  borrowList.add(borrow);
		  user.setBorrowslist(borrowList);
		  userRepo.save(user);
		  return userRepo.save(user);

	}

	public String getNameOfUser(int from_uerid) {
		return userRepo.findById(from_uerid).get().getName();

	}

	public User updateBorrow(Borrow borrow, int uid, int bid) {
		User user = userRepo.findById(uid).get();
	
	 Borrow borrow2 = borrowRepo.findById(bid).get();

		borrow2.setLocalDate(borrow.getLocalDate());
		borrow2.setBorrow_name(borrow.getBorrow_name());
		borrow2.setRs(borrow.getRs());
		borrow2.setFrom_user(borrow.getFrom_user());

		borrowRepo.save(borrow2);
		return userRepo.save(user);

	}

	public User deleteborrow(int uid, int bid) {
		User user = userRepo.findById(uid).get();
		Borrow borrow = borrowRepo.findById(bid).get();

		 List<Borrow> borrowslist = user.getBorrowslist();

		boolean isPresent = false;
		for (Borrow b : borrowslist) {
			if (b.equals(borrow)) {
				isPresent = true;
				break;
			}
		}
		if (isPresent) {
			borrowslist.remove(borrow);
		}

		user.setBorrowslist(borrowslist);

		User save = userRepo.save(user);
		borrowRepo.delete(borrow);

		return save;

	}
	public Borrow findbyBId( int bid){
		try {
			return borrowRepo.findById(bid).get();
		}catch(Exception e )
		{return null;
		
	}
	}
}
