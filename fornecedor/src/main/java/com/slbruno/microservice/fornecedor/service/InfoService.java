package com.slbruno.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slbruno.microservice.fornecedor.model.InfoFornecedor;
import com.slbruno.microservice.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		
		return infoRepository.findByEstado(estado);
		
	}
	
}
