package com.es.eoi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.eoi.dto.CuentaDto;
import com.es.eoi.entity.Banco;
import com.es.eoi.entity.Cliente;
import com.es.eoi.entity.Cuenta;
import com.es.eoi.service.CuentaService;

@RestController
public class CuentaRestController {

	@Autowired
	CuentaService cuentaService;
	
	@GetMapping("/cuenta/{id}")
	public Cuenta findCuenta(@PathVariable String id) {
		return cuentaService.findById(Integer.parseInt(id));
	}

	@PostMapping("/cuenta")
	public void updateCuenta(@RequestBody CuentaDto cuentaDto) {
		Cuenta cuenta = new Cuenta();
		BeanUtils.copyProperties(cuentaDto, cuenta);
		cuentaService.save(cuenta);
	}

	@DeleteMapping("/cuenta/{id}")
	public void deleteCuenta(@PathVariable String id) {
		cuentaService.remove(Integer.parseInt(id));
	}

	@GetMapping("/cuenta/all")
	public List<Cuenta> findAll() {
		return cuentaService.findAll();
	}

}