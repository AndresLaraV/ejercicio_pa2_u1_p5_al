package com.edu.ec;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.ec.matricula.repository.modelo.Propietario;
import com.edu.ec.matricula.repository.modelo.Vehiculo;
import com.edu.ec.matricula.service.IMatricularService;
import com.edu.ec.matricula.service.IPropietarioService;
import com.edu.ec.matricula.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5AlApplication implements CommandLineRunner {

	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IMatricularService iMatricularService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5AlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Crear vehicuolo
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setPlaca("PCD - 001");
		vehiculo.setTipo("liviano");
		vehiculo.setPrecio(new BigDecimal(25000));

		this.iVehiculoService.agregar(vehiculo);
		System.out.println(vehiculo);

		// Crear Propietario
		Propietario propietario = new Propietario();
		propietario.setNombre("Andres");
		propietario.setApellido("Lara");
		propietario.setCedula("1722121835");
		propietario.setGenero("Masculino");
		this.iPropietarioService.agregar(propietario);
		System.out.println(propietario);

		// Actualizar Propietario
		propietario.setNombre("Sebastian");
		propietario.setApellido("Viana");
		this.iPropietarioService.actualizar(propietario);
		System.out.println(propietario);

		this.iMatricularService.matriculacion("1722121835", "PCD - 001");

	}

}
