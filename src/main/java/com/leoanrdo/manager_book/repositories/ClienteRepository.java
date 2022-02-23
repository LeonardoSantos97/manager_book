package com.leoanrdo.manager_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.manager_book.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
