package com.example.demo.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.DaoTransac;
import com.example.demo.dao.jpa.entity.EntityTransac;
import com.example.demo.dao.jpa.repository.RepoTransac;
import com.example.demo.model.ModelTransac;
@Service
public class DaoTransacImpl implements DaoTransac{

	@Autowired
	private RepoTransac repository;
	@Override
	public ModelTransac getTransac(String id) {
		Optional<EntityTransac> e = repository.findById(id);
		ModelTransac model = new ModelTransac();
		
		if (e.isPresent()) {
			model.setIdTransaccion(e.get().getIdTransaccion());
			model.setFecha(e.get().getFecha());
			model.setIdLibro(e.get().getIdLibro());
			model.setIdUser(e.get().getIdUser());
			model.setIdSucursal(e.get().getIdSucursal());
		}else {
			//Si no hay user entonces que lance una excepcion controlada de tipo UserNotFoundException
			throw new RuntimeException("Usuario no encontrado con ID: " + id);
		}
		return model;
	}

	@Override
	public ModelTransac postTransac(ModelTransac model) {
		EntityTransac entity = new EntityTransac();
		entity.setFecha(model.getFecha());
		entity.setIdLibro(model.getIdLibro());
		entity.setIdSucursal(model.getIdSucursal());
		entity.setIdUser(model.getIdUser());

		entity = repository.save(entity);
		model.setIdTransaccion(entity.getIdTransaccion());

	    return model;
	}

	@Override
	public ModelTransac putTransac(String id, ModelTransac model) {
		Optional<EntityTransac> existingUser = repository.findById(id);
	    if (existingUser.isPresent()) {
	    	EntityTransac Entity = existingUser.get();
	    	Entity.setFecha(model.getFecha());
			Entity.setIdLibro(model.getIdLibro());
			Entity.setIdSucursal(model.getIdSucursal());
			Entity.setIdUser(model.getIdUser());
	        repository.save(Entity);

	        model.setIdTransaccion(id);
	        return model;
	    } else {
	        throw new RuntimeException("Usuario no encontrado con ID: " + id);
	    }
	}

	@Override
	public ModelTransac deleteTransac(String id) {
	    Optional<EntityTransac> e = repository.findById(id);

	    ModelTransac model = new ModelTransac();

	    if (e.isPresent()) {
	        repository.deleteById(id);
	        model.setIdTransaccion("Transacción eliminada correctamente");
	    } else {
	        model.setIdTransaccion("El ID proporcionado no existe");
	    }

	    return model;
	}


}
