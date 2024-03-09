package com.odamede.javanotes.springbeanscopes.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) // @org.springframework.web.context.annotation.SessionScope
public class SessionScopeBean {

    public SessionScopeBean() {
        System.out.println("Session Scope Bean Created");
    }

    private int exampleValue = 0;

    public int getExampleValue() {
        return this.exampleValue++;
    }


}
