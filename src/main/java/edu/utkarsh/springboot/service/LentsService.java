package edu.utkarsh.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utkarsh.springboot.dto.Lents;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.repo.LentRepo;
import edu.utkarsh.springboot.repo.UserRepo;

@Service
public class LentsService {

	@Autowired
	private LentRepo lentRepo;

	@Autowired
	private UserRepo userrepo;

	public Lents addLent(Lents lents) {
		return lentRepo.save(lents);

	}

	public User MapUserToLent(int uid, int lid) {

		User user = userrepo.findById(uid).get();
		Lents lents = lentRepo.findById(lid).get();

		List<Lents> lents2 = user.getLents();
		lents2.add(lents);
		user.setLents(lents2);
		return userrepo.save(user);

	}

	public User deleteLent(int uid, int lid) {
		User user = userrepo.findById(uid).get();
		Lents lents = lentRepo.findById(lid).get();

		List<Lents> lents2 = user.getLents();

		boolean isPresent = false;
		for (Lents lent : lents2) {
			if (lent.equals(lents)) {
				isPresent = true;
				break;
			}
		}

		if (isPresent) {
			lents2.remove(lents);
		}

		user.setLents(lents2);

		User save = userrepo.save(user);
		lentRepo.delete(lents);

		return save;

	}

	public Lents findlentsById(int lid) {
		try {
			return lentRepo.findById(lid).get();
		} catch (Exception e) {
			return null;
		}
	}

	public User updateLent(Lents lent, int uid, int sid) {
		User user = userrepo.findById(uid).get();
		
		Lents lent2 = lentRepo.findById(sid).get();

		lent2.setLocalDate(lent.getLocalDate());
		lent2.setLent_name(lent.getLent_name());
		lent2.setRs(lent.getRs());
		lent2.setToUser(lent.getToUser());

		lentRepo.save(lent2);
		return userrepo.save(user);
	}

}
