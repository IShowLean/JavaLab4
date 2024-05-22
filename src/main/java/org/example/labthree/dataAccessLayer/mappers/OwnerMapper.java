package org.example.labthree.dataAccessLayer.mappers;

import lombok.RequiredArgsConstructor;
import org.example.labthree.dataAccessLayer.dao.CatDao;
import org.example.labthree.dataAccessLayer.entities.cat.CatBase;
import org.example.labthree.dataAccessLayer.entities.cat.CatDto;
import org.example.labthree.dataAccessLayer.entities.owner.OwnerBase;
import org.example.labthree.dataAccessLayer.entities.owner.OwnerDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerMapper {
    private final CatDao catsRepo ;

    public OwnerDto convertToDto(OwnerBase owner){
        return new OwnerDto(owner.getId(), owner.getName(), owner.getDateOfBirth(), owner.getCats().stream().map(CatBase::getId).toList());
    }
    public OwnerBase convertToBase(OwnerDto owner){
        Class<CatDto> catDtoClass = CatDto.class;
        return new OwnerBase(owner.getId(), owner.getName(), owner.getDateOfBirth(), owner.getCats().stream().map(x -> catsRepo.findById(x).orElse(null)).toList());
    }
}
