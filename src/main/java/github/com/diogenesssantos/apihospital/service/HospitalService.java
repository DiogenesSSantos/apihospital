package github.com.diogenesssantos.apihospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.com.diogenesssantos.apihospital.model.Hospital;
import github.com.diogenesssantos.apihospital.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	public HospitalService() {}
	
	
	public Optional<Hospital> buscarPorNome(String nome) {
		return repository.findBynome(nome);
	}


	public Hospital salvar(Hospital hospital) {
		return repository.save(hospital);
		
		
		
	}
	
	
}
