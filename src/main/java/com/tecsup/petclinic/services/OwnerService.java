package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OwnerService {


    private final OwnerRespository ownerRepository;

    @Autowired
    public OwnerService(OwnerRespository ownerRepository){
        this.ownerRepository=ownerRepository;
    }




    public Owner findById(Integer id) {
        return ownerRepository.findById(id).orElseThrow(() ->
                new OwnerNotFoundException("Owner not found with id: " + id));
    }

    public List<Owner> findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner update(Owner owner) {
        if (!ownerRepository.existsById(owner.getId())) {
            throw new OwnerNotFoundException("Owner not found with id: " + owner.getId());
        }
        return ownerRepository.save(owner);
    }

    public void delete(Integer id) {
        if (!ownerRepository.existsById(id)) {
            throw new OwnerNotFoundException("Owner not found with id: " + id);
        }
        ownerRepository.deleteById(id);
    }
}
