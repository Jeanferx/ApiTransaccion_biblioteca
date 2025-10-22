package com.example.demo.dao.jpa.entity;

import java.util.Date;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "tran")
public class EntityTransac {
	@Id
	@UuidGenerator
	private String idTransaccion;
	private String idUser;
	private String idSucursal;
	private int idLibro;
	private Date fecha;
}
