package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.request.RequestTransac;
import com.example.demo.controller.dto.response.ResponseTransac;
import com.example.demo.controller.mappers.MappersTransac;
import com.example.demo.model.ModelTransac;
import com.example.demo.service.ServiceTransac;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/transac")
public class ControllerTransac {
	@Autowired
	private MappersTransac mappers;
	@Autowired
	private ServiceTransac service;
	@GetMapping("/{id}")
	public ModelTransac getTransac(@PathVariable ("id") String id) {
		return service.getTransac(id); 
	}
	@PostMapping
	public ResponseTransac postTransac(@Valid @RequestBody RequestTransac model) {
		ModelTransac models=service.postTransac(mappers.toModel(model));
		return mappers.toDto(models);
	}
	@DeleteMapping("/{id}")
	public ModelTransac deleteTransac(@PathVariable ("id") String id) {
		return service.deleteTransac(id); 
	}
	@PutMapping("/{id}")
	public ModelTransac putTransac(@PathVariable ("id") String id, @RequestBody ModelTransac model) {
		return service.putTransac(id,model); 
	}
}
