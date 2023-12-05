package com.edu.ec.matricula.repository;

import com.edu.ec.matricula.repository.modelo.Matricular;

public interface IMatricularRepository {
	public Matricular seleccionar(String placa);
	public void insertar(Matricular matricular);
	public void actualizar(Matricular matricular);
	public void eliminar(String placa);
}
