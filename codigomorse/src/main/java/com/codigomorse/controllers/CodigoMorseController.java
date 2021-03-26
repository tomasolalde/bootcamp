package com.codigomorse.controllers;

import com.codigomorse.utils.CodigoMorseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.PathParam;

@RestController("/codigo-morse")
public class CodigoMorseController {

    @GetMapping("/{codigo}")
    public String codigoMorse(@PathParam(value = "codigo") String codigo) {
        return CodigoMorseUtil.traducir(codigo);
    }
}
