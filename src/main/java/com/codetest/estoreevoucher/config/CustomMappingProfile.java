package com.codetest.estoreevoucher.config;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class CustomMappingProfile implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory factory) {

	}
}
