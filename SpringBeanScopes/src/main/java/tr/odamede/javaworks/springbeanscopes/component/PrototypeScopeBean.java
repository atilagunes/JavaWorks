package com.odamede.javanotes.springbeanscopes.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //@Scope("prototype")
public class PrototypeScopeBean {

    public PrototypeScopeBean() {
        System.out.println("Prototype scope bean initialized");
    }

    private int exampleValue = 0;

    public int getExampleValue() {
        return this.exampleValue++;
    }


}
