package com.employees.users.container;

import com.employees.users.domain.core.EmployeesDomainService;
import com.employees.users.domain.core.EmployeesDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public EmployeesDomainService employeesDomainService(){
        return new EmployeesDomainServiceImpl();
    }
}
