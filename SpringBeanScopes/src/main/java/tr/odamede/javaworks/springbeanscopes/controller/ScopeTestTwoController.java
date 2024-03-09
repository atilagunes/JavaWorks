package com.odamede.javanotes.springbeanscopes.controller;

import com.odamede.javanotes.springbeanscopes.component.DefaultScopeBean;
import com.odamede.javanotes.springbeanscopes.component.PrototypeScopeBean;
import com.odamede.javanotes.springbeanscopes.component.RequestScopeBean;
import com.odamede.javanotes.springbeanscopes.component.SessionScopeBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RequestMapping(value = "/v1/scope-test-two")
@RestController
public class ScopeTestTwoController {

    private final DefaultScopeBean defaultScopeBean;

    private final PrototypeScopeBean prototypeScopeBean;

    private final RequestScopeBean requestScopeBean;

    private final SessionScopeBean sessionScopeBean;

    public ScopeTestTwoController(DefaultScopeBean defaultScopeBean, PrototypeScopeBean prototypeScopeBean, RequestScopeBean requestScopeBean, SessionScopeBean sessionScopeBean) {
        this.defaultScopeBean = defaultScopeBean;
        this.prototypeScopeBean = prototypeScopeBean;
        this.requestScopeBean = requestScopeBean;
        this.sessionScopeBean = sessionScopeBean;
    }

    @GetMapping(value = "/default")
    public ResponseEntity<Integer> defaultBeanVariableDon() {
        return ResponseEntity.of(Optional.of(defaultScopeBean.getExampleValue()));
    }

    @GetMapping(value = "/prototype")
    public ResponseEntity<Integer> prototypeBeanVariableDon() {
        return ResponseEntity.of(Optional.of(prototypeScopeBean.getExampleValue()));
    }

    @GetMapping(value = "/request")
    public ResponseEntity<Integer> requestBeanVariableDon() {
        return ResponseEntity.of(Optional.of(requestScopeBean.getExampleValue()));
    }

    @GetMapping(value = "/session")
    public ResponseEntity<Integer> sessionBeanVariableDon() {
        return ResponseEntity.of(Optional.of(sessionScopeBean.getExampleValue()));
    }
}