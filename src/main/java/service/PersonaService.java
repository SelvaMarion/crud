package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import interfaceService.IPersonaService;
import interfaces.IPersona;
import modelo.Persona;
@Service

public class PersonaService implements IPersonaService{
	@Autowired
	private IPersona dao;
	@Override
	public List<Persona> listar() {
		
		return (List<Persona>) dao.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public int save(Persona p) {
		int res=0;
        Persona per=dao.save(p);
        if(!per.equals(null)) {
            res=1;
        }
        return res;
	}

	@Override
	public void delete(int id) {
		dao.deleteById(null);
		
	
    }
}
