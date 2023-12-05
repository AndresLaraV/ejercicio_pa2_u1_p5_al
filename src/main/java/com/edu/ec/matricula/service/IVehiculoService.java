package com.edu.ec.matricula.service;

import com.edu.ec.matricula.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public Vehiculo buscar(String placa);
	public void agregar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public void borrar(String placa);
}
