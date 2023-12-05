package com.edu.ec.matricula.service;

import com.edu.ec.matricula.repository.modelo.Propietario;

public interface IPropietarioService {
	public Propietario buscar(String cedula);

	public void agregar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void borrar(String cedula);
}
