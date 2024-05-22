package org.example.labthree.serviceLayer.cat;

import org.example.labthree.dataAccessLayer.entities.cat.CatDto;
import org.example.labthree.dataAccessLayer.entities.cat.CatFinderDto;
import org.example.labthree.dataAccessLayer.entities.owner.OwnerDto;

import java.util.List;
import java.util.UUID;

public interface CatService {

     CatDto findCat(UUID id);
     List<CatDto> findCatByOwnerId(UUID id);
     void saveCat(CatDto cat);

     Boolean update(CatDto cat, UUID id);

     Boolean delete(UUID id);
     CatDto findFriendById(UUID id);
     OwnerDto findOwnerById(UUID id);

     List<CatDto> findAll();
    List<CatDto> findCatsByParam(CatFinderDto param);
    boolean IsItCurrentCatOwner(String username, UUID id);


     List<CatDto> findCatByName(String name);
}

