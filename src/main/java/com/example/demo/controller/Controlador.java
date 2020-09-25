package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IusuarioService;
import com.example.demo.model.Usuario;

@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IusuarioService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = service.listar();
		model.addAttribute("usuario", usuarios);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuarios", new Usuario());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Validated Usuario u, Model model) {
		service.save(u);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Usuario> usuario = service.listarbyId(id);
		model.addAttribute("usuarios", usuario);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
}
