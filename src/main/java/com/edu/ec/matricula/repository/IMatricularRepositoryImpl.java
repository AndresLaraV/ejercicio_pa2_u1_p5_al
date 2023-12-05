package com.edu.ec.matricula.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.matricula.repository.modelo.Matricular;

@Repository
public class IMatricularRepositoryImpl implements IMatricularRepository {
	
	private static List<Matricular> base = new ArrayList<>();

	@Override
	public Matricular seleccionar(String placa) {
		// TODO Auto-generated method stub
		for (Matricular matricular : base) {
			if (matricular.getVehiculo().getPlaca().equals(placa)) {
				return matricular;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricular matricular) {
		// TODO Auto-generated method stub
		base.add(matricular);
	}

	@Override
	public void actualizar(Matricular matricular) {
		// TODO Auto-generated method stub
		this.eliminar(matricular.getVehiculo().getPlaca());
		this.insertar(matricular);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Matricular matricular = this.seleccionar(placa);
		base.remove(placa);
	}

}
