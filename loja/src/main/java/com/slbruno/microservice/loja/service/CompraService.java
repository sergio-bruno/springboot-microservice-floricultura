package com.slbruno.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.slbruno.microservice.loja.controller.dto.CompraDTO;
import com.slbruno.microservice.loja.controller.dto.EnderecoDTO;
import com.slbruno.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	public void realizaCompra(CompraDTO compra) {
		
		EnderecoDTO endereco = new EnderecoDTO();
		endereco.setEstado("PE");
		compra.setEndereco(endereco); 
		
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange =
				client.exchange("http://localhost:8081/info/"+compra.getEndereco().getEstado(),
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
		
	}

}
