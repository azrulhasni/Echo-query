/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrul.echo.query.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author azrul
 */
@RestController
@RequestMapping("/echo")
public class EchoController {

    /*@GetMapping()
    public List<Object> list() {
        return null;
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }*/
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public @ResponseBody
    String echoQueryString(@RequestParam Map<String, String> query, @RequestHeader Map<String, String> headers, ModelMap model) {

        String queryJson = "{" + query.entrySet().stream()
                .map(e -> "\"" + e.getKey() + "\"" + ":\"" + String.valueOf(e.getValue()) + "\"")
                .collect(Collectors.joining(", ")) + "}";
        
        String headerJson = "{" + headers.entrySet().stream()
                .map(e -> "\"" + e.getKey() + "\"" + ":\"" + String.valueOf(e.getValue()) + "\"")
                .collect(Collectors.joining(", ")) + "}";
        return "{\"query\":"+queryJson+", \"header\":"+headerJson+"}";
    }
}
