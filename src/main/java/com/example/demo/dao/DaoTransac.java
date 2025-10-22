package com.example.demo.dao;

import com.example.demo.model.ModelTransac;

public interface DaoTransac {
	ModelTransac getTransac(String id);
	ModelTransac postTransac(ModelTransac model);
	ModelTransac putTransac(String id,ModelTransac model);
	ModelTransac deleteTransac(String id);
}
