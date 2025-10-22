package com.example.demo.model;


import java.util.Date;

import lombok.Data;

@Data
public class ModelTransac {
	private String idUser;
	private String idSucursal;
	private int idLibro;
	private String idTransaccion;
	private Date fecha;
}
