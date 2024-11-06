package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SpecialtyServiceTest {

	@Autowired
	private OwnerService ownerService;

	@Test
	public void testCreateOwner() {
		Owner owner = new Owner();
		owner.setFirstName("Carlos");

		Owner savedOwner = ownerService.create(owner);

		// Verificar que el propietario fue creado correctamente
		assertNotNull(savedOwner, "El propietario no debe ser nulo después de la creación");
		assertNotNull(savedOwner.getId(), "El propietario debe tener un ID después de ser guardado");

		// Log para verificar el resultado
        log.info("Propietario creado: {}", savedOwner);
	}

	@Test
	public void testFindOwnerById() {
		// Crear un propietario y guardarlo
		Owner owner = new Owner();
		owner.setFirstName("Carlos");
		Owner savedOwner = ownerService.create(owner);

		// Buscar el propietario por ID
		Owner foundOwner = ownerService.findById(savedOwner.getId());

		// Verificar que se encontró el propietario correcto
		assertNotNull(foundOwner, "El propietario encontrado no debe ser nulo");
		assertEquals(savedOwner.getId(), foundOwner.getId(), "Los IDs deben coincidir");

		// Log para verificar el resultado
		log.info("Propietario encontrado: {}", foundOwner);
	}

}
