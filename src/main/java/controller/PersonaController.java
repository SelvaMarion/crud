package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import interfaceService.IPersonaService;
import modelo.Persona;

@Controller
@RequestMapping
public class PersonaController {
	@Autowired
	private IPersonaService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("personas", service.listar());
		return "index";
	}

	@GetMapping("/listar/{id}")
	public String listarId(@PathVariable int id, Model model) {
		model.addAttribute("persona", service.listarId(id));
		return "form";
	}

	@GetMapping("/new")
	public String nuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}

	@PostMapping("/save")
//public String save(@Valid Persona p,Model model) {
	public String save(Persona p, Model model) {

		int id = service.save(p);
		if (id == 0) {
			return "form";
		}
		return "redirect:/listar";
	}
}
