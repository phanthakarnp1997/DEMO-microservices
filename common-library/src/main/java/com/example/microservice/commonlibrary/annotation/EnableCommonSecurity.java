package com.example.microservice.commonlibrary.annotation;

import com.example.microservice.commonlibrary.security.SecurityConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SecurityConfig.class)
public @interface EnableCommonSecurity {
}
