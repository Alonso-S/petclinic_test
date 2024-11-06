package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
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
	public void testUpdateOwner(){
		//Crear un propietario y guardarlo
		Owner owner = new Owner();
		owner.setFirstName("Carlos");
		Owner savedOwner = ownerService.create(owner);

		// Actualizar el propietario

		savedOwner.setLastName("Pérez");
		Owner updatedOwner = ownerService.update(savedOwner);

		// Verificar que el propietario fue actualizado correctamente

		assertNotNull(updatedOwner, "El propietario actualizado no debe ser nulo");
		assertNotNull(updatedOwner.getId(), "El propietario debe tener un ID después de ser actualizado");
		assertEquals("Pérez", updatedOwner.getLastName(),"El apellido del propietario debe ser Pérez");

		// Log para verificar el resultado
		log.info("Propietario actualizado {}", updatedOwner );
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



	@Test
	public void testDeleteOwner() {
		// Crear un propietario y guardarlo
		Owner owner = new Owner();
		owner.setFirstName("Carlos");
		Owner savedOwner = ownerService.create(owner);

		// Eliminar el propietario
		ownerService.delete(savedOwner.getId());

		// Verificar que el propietario ya no existe
		assertThrows(OwnerNotFoundException.class, () -> {
			ownerService.findById(savedOwner.getId());
		}, "Debería lanzar una excepción al buscar un propietario eliminado");

		// Log para verificar el resultado
		log.info("Propietario eliminado: {}", savedOwner.getId());
	}



}
