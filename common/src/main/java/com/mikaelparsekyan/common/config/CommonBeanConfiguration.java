package com.mikaelparsekyan.common.config;

import com.mikaelparsekyan.common.util.AuditAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AuditAwareImpl auditAware() {
        return new AuditAwareImpl();
    }
}
