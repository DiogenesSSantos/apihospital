package github.com.diogenesssantos.apihospital.modelDTOS;

import java.util.List;

import github.com.diogenesssantos.apihospital.model.Hospital;


public class HospitalDTO {

  

    private String nome;

    private List<ItemAgendamentoDTO> listaAgendamentos;

    

    public HospitalDTO() {}
    
    public HospitalDTO(String nome, List<ItemAgendamentoDTO> listaAgendamentos) {
		this.nome = nome;
		this.listaAgendamentos = listaAgendamentos;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemAgendamentoDTO> getListaAgendamentos() {
		return listaAgendamentos;
	}

	public void setListaAgendamentos(List<ItemAgendamentoDTO> listaAgendamentos) {
		this.listaAgendamentos = listaAgendamentos;
	}

	
	
	
	public static HospitalDTO create(Hospital hospital) {
		List<ItemAgendamentoDTO> listAgendamentoDTOS = hospital.getListaAgendamentos()
														.stream()
														.map(ItemAgendamentoDTO::create)
														.toList();
		
		return new HospitalDTO(hospital.getNome() , listAgendamentoDTOS);
	}
    
    
}
