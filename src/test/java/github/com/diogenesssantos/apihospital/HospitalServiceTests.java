package github.com.diogenesssantos.apihospital;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import github.com.diogenesssantos.apihospital.model.EnumeracaoITENS;
import github.com.diogenesssantos.apihospital.model.Hospital;
import github.com.diogenesssantos.apihospital.model.Hospital.HospitalBuilder;
import github.com.diogenesssantos.apihospital.model.ItemAgendamento;
import github.com.diogenesssantos.apihospital.model.ItemAgendamento.ItemAgendamentoBuilder;
import github.com.diogenesssantos.apihospital.service.HospitalService;

@SpringBootTest
public class HospitalServiceTests {

	@Autowired
	private HospitalService service;
	
	
	
	@Test
	public void salvar() {
		ItemAgendamento item = new ItemAgendamentoBuilder()
				.setConsulta(EnumeracaoITENS.CIRURGIA_PLASTICA)
				.setProtocolo("PADRÃO")
				.setHospitais(Collections.EMPTY_LIST)
				.setAtivo(true)
				.builder();
		
		Hospital hospital = new HospitalBuilder()
				.setNome("Hospital da clinicas")
				.setListaAgendamentos(List.of(item))
				.build();
	 
	
	
		
		var hospitalExists = service.buscarPorNome(hospital.getNome());
		
		if(hospitalExists.isPresent()) {
			hospital = hospitalExists.get();
			hospital.getListaAgendamentos().add(item);
		}
		hospital = service.salvar(hospital);
		
		
		
		
		
		System.out.println(hospital);
		
	}
	
	
	@Test
	public void buscarPorNome_happyPath() {
		var hospital  = service.buscarPorNome("Hospital da clinicas");
		System.out.println(hospital);
		
	}
	
	
	
}
