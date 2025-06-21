package github.com.diogenesssantos.apihospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.com.diogenesssantos.apihospital.model.Hospital;
import github.com.diogenesssantos.apihospital.modelDTOS.HospitalDTO;
import github.com.diogenesssantos.apihospital.service.HospitalService;

@RestController
@RequestMapping(path = "/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	
	@GetMapping
	public ResponseEntity<?> buscarPorNome(@RequestParam String nome) {
		var hospital = service.buscarPorNome(nome);
		
		if(hospital.isEmpty()) {
			return ResponseEntity.badRequest().
					body("O NOME DO HOSPITAL NÃO EXISTE");
		}
		HospitalDTO hospitalDTO = HospitalDTO.create(hospital.get());
		
		return ResponseEntity.ok(hospitalDTO);
	}
	
	
	
}
