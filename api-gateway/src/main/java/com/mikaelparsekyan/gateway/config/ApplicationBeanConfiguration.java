package com.mikaelparsekyan.gateway.config;

import com.mikaelparsekyan.common.config.CommonBeanConfiguration;
import com.mikaelparsekyan.common.config.KafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration(exclude={
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class}
)
@Import({
    KafkaConfiguration.class,
    CommonBeanConfiguration.class
})
@Configuration
public class ApplicationBeanConfiguration {

}
