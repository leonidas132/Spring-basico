package com.protalento.componen;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImple implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("hola implementando segundo componente");
    }
}
