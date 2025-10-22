package com.example.demo.controller.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class RequestTransac {
	@NotEmpty
	private String idUser;

	@NotEmpty
	private String idSucursal;

	@NotNull
	private Integer idLibro;

	@NotNull
	private Date fecha;
}
