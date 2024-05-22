package org.example.labthree.serviceLayer.owner;

import org.example.labthree.dataAccessLayer.entities.cat.CatDto;
import org.example.labthree.dataAccessLayer.entities.owner.OwnerDto;
import org.example.labthree.dataAccessLayer.entities.owner.OwnerFinderDto;

import java.util.List;
import java.util.UUID;

public interface OwnerService {
     OwnerDto findOwner(UUID id);

     void saveOwner(OwnerDto owner);

     Boolean deleteOwner(UUID id); //OwnerBase owner

     Boolean updateOwner(OwnerDto owner, UUID id);

     List<OwnerDto> findAllOwners();

     CatDto findCatById(UUID id);
    List<OwnerDto> findOwnersByParam(OwnerFinderDto param);

    OwnerDto getOwnerDtoByUsername(String username);
     OwnerDto findOwnerByName(String name);

}
