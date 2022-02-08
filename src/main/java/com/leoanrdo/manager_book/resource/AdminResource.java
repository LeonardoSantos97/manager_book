package com.leoanrdo.manager_book.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leoanrdo.manager_book.domain.Admin;
import com.leoanrdo.manager_book.domain.dtos.AdminDTO;
import com.leoanrdo.manager_book.services.AdminService;

@RestController
@RequestMapping(value = "/admins")
public class AdminResource {

	@Autowired
	private AdminService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> findById(@PathVariable Integer id) {
		Admin obj = service.findById(id);
		return ResponseEntity.ok().body(new AdminDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<AdminDTO>> findAll() {
		List<Admin> list = service.findAll();
		List<AdminDTO> listDTO = list.stream().map(obj -> new AdminDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<AdminDTO> create(@Valid @RequestBody AdminDTO objDTO) {
		Admin newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> update(@PathVariable Integer id, @Valid @RequestBody AdminDTO objDTO){
		Admin Obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new AdminDTO(Obj));
	}
}
