package com.weine.services;

import com.weine.entities.Catalog;
import com.weine.mappers.IProductMapper;
import com.weine.model.dtos.CatalogDto;
import com.weine.repositories.jpa.ICatalogRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to get the catalog information
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class CatalogService implements IServiceApi<CatalogDto, Object>{
    private final ICatalogRep catalogRep;
    private final IProductMapper productMapper;

    @Override
    public List<CatalogDto> getObjects() {
        return productMapper.toCatalogDtoList(catalogRep.findAll());
    }

    @Override
    public CatalogDto find(Integer id) {
        if(id != null){
            Optional<Catalog> optional = catalogRep.findById(id);
            if(optional.isPresent()){
                return productMapper.toCatalogDto(optional.get());
            }
        }
        return null;
    }

    @Override
    public CatalogDto save(CatalogDto request) throws RuntimeException {
        return null;
    }

    @Override
    public CatalogDto update(CatalogDto request) throws RuntimeException {
        if(request != null){
            Catalog catalog = productMapper.catalogDtoToCatalog(request);
            Catalog response = catalogRep.save(catalog);
            return productMapper.toCatalogDto(response);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        return false;
    }

    @Override
    public boolean checkExistence(Integer id) {
        return false;
    }
}
