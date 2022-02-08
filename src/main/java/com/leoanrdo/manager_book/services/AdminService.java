package com.leoanrdo.manager_book.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.repositories.AdminRepository;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository repository;
	
	public Admin findById(Integer id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
