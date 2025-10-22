package com.example.demo.service;

import com.example.demo.model.ModelTransac;

public interface ServiceTransac {
	ModelTransac getTransac(String id);
	ModelTransac postTransac(ModelTransac model);
	ModelTransac putTransac(String id,ModelTransac model);
	ModelTransac deleteTransac(String id);
}
