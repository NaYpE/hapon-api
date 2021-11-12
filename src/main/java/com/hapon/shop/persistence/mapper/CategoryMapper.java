package com.hapon.shop.persistence.mapper;

import com.hapon.shop.domain.Category;
import com.hapon.shop.persistence.entity.Categorie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategorie", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active"),
    })
    Category toCategory(Categorie categorie);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categorie toCategorie(Category category);
}
