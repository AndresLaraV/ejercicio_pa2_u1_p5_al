package com.edu.ec.matricula.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.matricula.repository.IMatricularRepository;
import com.edu.ec.matricula.repository.IPropietarioRepository;
import com.edu.ec.matricula.repository.IVehiculoRepository;
import com.edu.ec.matricula.repository.modelo.Matricular;
import com.edu.ec.matricula.repository.modelo.Propietario;
import com.edu.ec.matricula.repository.modelo.Vehiculo;

@Service
public class IMatricularServiceImpl implements IMatricularService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	@Autowired
	private IMatricularRepository iMatricularRepository;

	@Override
	public Matricular buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iMatricularRepository.seleccionar(placa);
	}

	@Override
	public void agregar(Matricular matricular) {
		// TODO Auto-generated method stub
		this.iMatricularRepository.insertar(matricular);
	}

	@Override
	public void actualizar(Matricular matricular) {
		// TODO Auto-generated method stub
		this.iMatricularRepository.actualizar(matricular);
	}

	@Override
	public void borrar(String placa) {
		// TODO Auto-generated method stub
		this.iMatricularRepository.eliminar(placa);
	}

	@Override
	public void matriculacion(String cedula, String placa) {
		// TODO Auto-generated method stub

		Propietario propietario = this.iPropietarioRepository.seleccionar(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.seleccionar(placa);

		Matricular matricular = new Matricular();
		matricular.setPropietario(propietario);
		matricular.setVehiculo(vehiculo);
		matricular.setFechaMatricula(LocalDate.now());

		Vehiculo vehiculoMatricula = matricular.getVehiculo();

		if (vehiculoMatricula != null && "pesado".equals(vehiculoMatricula.getTipo())) {
			matricular.setValorMatricula(vehiculoMatricula.getPrecio().multiply(new BigDecimal(0.25)));
			System.out.println("Valor de la Matricula: " + matricular);
			if (matricular.getValorMatricula().compareTo(new BigDecimal(2200)) > 0) {
				BigDecimal descuento = matricular.getValorMatricula().multiply(new BigDecimal(0.05));
				matricular.setValorMatricula(matricular.getValorMatricula().subtract(descuento));
				System.out.println("El valor de la matricula con descuento es : " + matricular);
			}
		} else {
			matricular.setValorMatricula(vehiculoMatricula.getPrecio().multiply(new BigDecimal(0.20)));
			System.out.println("Matricula: " + matricular);
			if (matricular.getValorMatricula().compareTo(new BigDecimal(2200)) > 0) {
				BigDecimal descuento = matricular.getValorMatricula().multiply(new BigDecimal(0.05));
				matricular.setValorMatricula(matricular.getValorMatricula().subtract(descuento));
				System.out.println("El valor de la matricula con descuento es : " + matricular);
			}
		}

	}

}
