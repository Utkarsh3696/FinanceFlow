package edu.utkarsh.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utkarsh.springboot.dto.Lents;

@Repository
public interface LentRepo extends JpaRepository<Lents, Integer> {

}
