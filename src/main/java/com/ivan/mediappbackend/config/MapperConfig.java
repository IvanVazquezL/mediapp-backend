package com.ivan.mediappbackend.config;

import com.ivan.mediappbackend.dto.MedicDTO;
import com.ivan.mediappbackend.model.Medic;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    // JavaBeans are a reusable software component and are used to encapsulate and manage data, making
    // them suitable for representing objects in Java applications
    @Bean("defaultMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean("medicMapper")
    public ModelMapper medicMapper() {
        ModelMapper mapper = new ModelMapper();

        //Writing
        TypeMap<MedicDTO, Medic> typeMap1 = mapper.createTypeMap(MedicDTO.class, Medic.class);
        typeMap1.addMapping(MedicDTO::getName, (dest,v) -> dest.setFirstName((String) v));
        typeMap1.addMapping(MedicDTO::getSurname, (dest,v) -> dest.setLastName((String) v));
        typeMap1.addMapping(MedicDTO::getPhoto, (dest,v) -> dest.setPhotoUrl((String) v));

        //Reading
        TypeMap<Medic, MedicDTO> typeMap2 = mapper.createTypeMap(Medic.class, MedicDTO.class);
        typeMap2.addMapping(Medic::getFirstName, (dest,v) -> dest.setName((String) v));
        typeMap2.addMapping(Medic::getLastName, (dest,v) -> dest.setSurname((String) v));
        typeMap2.addMapping(Medic::getPhotoUrl, (dest,v) -> dest.setPhoto((String) v));





        return mapper;
    }
}
