package com.protalento.componen;

import org.springframework.stereotype.Component;

@Component
public class ComponentImp implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println(" se inyecto la dependencia");
    }
}
