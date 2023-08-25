package com.example.microservice.commonlibrary.annotation;

import com.example.microservice.commonlibrary.configuration.CommonLibraryConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CommonLibraryConfiguration.class)
public @interface EnableCommonLibrary {
}
