package com.edu.ec.matricula.service;

import com.edu.ec.matricula.repository.modelo.Matricular;

public interface IMatricularService {
	public Matricular buscar(String placa);
	public void agregar(Matricular matricular);
	public void actualizar(Matricular matricular);
	public void borrar(String placa);
	public void matriculacion(String cedula,String placa);
}
