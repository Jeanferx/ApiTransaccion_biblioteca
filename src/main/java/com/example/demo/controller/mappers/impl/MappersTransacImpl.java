package com.example.demo.controller.mappers.impl;

import org.springframework.stereotype.Component;

import com.example.demo.controller.dto.request.RequestTransac;
import com.example.demo.controller.dto.response.ResponseTransac;
import com.example.demo.controller.mappers.MappersTransac;
import com.example.demo.model.ModelTransac;
@Component
public class MappersTransacImpl implements MappersTransac{

	@Override
	public ModelTransac toModel(RequestTransac dto) {
		if(dto == null)
			return null;
		ModelTransac model=new ModelTransac();
		model.setIdSucursal(dto.getIdSucursal());
		model.setIdLibro(dto.getIdLibro());
		model.setIdUser(dto.getIdUser());
		model.setFecha(dto.getFecha());
		
		return model;
	}

	@Override
	public ResponseTransac toDto(ModelTransac model) {
	    if (model == null)
	        return null;

	    ResponseTransac dto = new ResponseTransac();
	    dto.setIdTransaccion(model.getIdTransaccion()); // copiar desde model, no desde dto

	    return dto;
	}


}
