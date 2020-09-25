package com.example.demo.interfaceService;

import java.util.Optional;

import com.example.demo.model.Usuario;

import java.util.List;

public interface IusuarioService {
	public List<Usuario> listar();
	public Optional<Usuario> listarbyId(int id);
	public int save(Usuario u);
	public void delete(int id);
}
