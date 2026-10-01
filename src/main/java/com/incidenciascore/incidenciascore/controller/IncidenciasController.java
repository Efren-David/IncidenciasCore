package com.incidenciascore.incidenciascore.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incidenciascore.incidenciascore.request.ContadoresRequest;
import com.incidenciascore.incidenciascore.request.IncidenciasRequest;
import com.incidenciascore.incidenciascore.response.ContadoresIncidenciasResponse;
import com.incidenciascore.incidenciascore.response.IncidenciasResponse;
import com.incidenciascore.incidenciascore.response.ParamDataResponse;
import com.incidenciascore.incidenciascore.service.IncidenciasService;

import lombok.extern.slf4j.Slf4j;

@Slf4j @RestController @RequestMapping("/core/v1")
public class IncidenciasController {

    private final IncidenciasService service;

    public IncidenciasController(IncidenciasService service) {
        this.service = service;
    }

    @GetMapping("/getInfo")
    public ResponseEntity<ParamDataResponse> getInfo() {

        ParamDataResponse response = service.getInfo();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateIncidencias")
    public ResponseEntity<IncidenciasResponse> updateIncidencias(@RequestBody IncidenciasRequest request) {

        log.info(" >> Inicia el servcio de updateIncidencias. ");

        IncidenciasResponse response = service.eventIncidecnias(request);

        log.info(" << Termina el servcio de updateIncidencias. ");

        return ResponseEntity.ok(response);

    }

    @PostMapping("/eventosIncidencias")
    public ResponseEntity<ContadoresIncidenciasResponse> eventosIncidencias(@RequestBody ContadoresRequest request) {

        log.info(" >> Inicia el servcio de eventosIncidencias. ");

        ContadoresIncidenciasResponse response = service.eventContaInciden(request);

        log.info(" << Termina el servcio de eventosIncidencias. ");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/reporteCompletoCSV")
    public ResponseEntity<byte[]> reporteCompletoCSV() {

        byte[] csv = service.generarCsv();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=incidencias.csv").contentType(MediaType.parseMediaType("text/csv")).body(csv);
    }

}
