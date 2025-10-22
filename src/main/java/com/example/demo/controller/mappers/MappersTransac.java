package com.example.demo.controller.mappers;

import com.example.demo.controller.dto.request.RequestTransac;
import com.example.demo.controller.dto.response.ResponseTransac;
import com.example.demo.model.ModelTransac;

public interface MappersTransac {
	ModelTransac toModel(RequestTransac dto);
	ResponseTransac toDto(ModelTransac model);
}
