package com.tobeto.a.spring.intro.core.utilities.mapper.services;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
