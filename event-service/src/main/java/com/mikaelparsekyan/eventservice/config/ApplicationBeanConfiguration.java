package com.mikaelparsekyan.eventservice.config;

import com.mikaelparsekyan.common.config.CommonBeanConfiguration;
import com.mikaelparsekyan.common.config.KafkaConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({
        KafkaConfiguration.class,
        CommonBeanConfiguration.class
})
public class ApplicationBeanConfiguration {
}
