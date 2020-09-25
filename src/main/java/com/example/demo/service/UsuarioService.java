package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IusuarioService;
import com.example.demo.interfaces.IUsuario;
import com.example.demo.model.Usuario;

@Service
public class UsuarioService implements IusuarioService {

	@Autowired
	private IUsuario data;

	@Override
	public List<Usuario> listar() {
		System.out.println("entra " + data.findAll());
		return (List<Usuario>) data.findAll();
	}

	@Override
	public Optional<Usuario> listarbyId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Usuario u) {
		int res = 0;
		Usuario usu = data.save(u);
		if (!usu.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);

	}

}
