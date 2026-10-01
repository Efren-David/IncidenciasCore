package com.incidenciascore.incidenciascore.service;

import com.incidenciascore.incidenciascore.request.ContadoresRequest;
import com.incidenciascore.incidenciascore.request.IncidenciasRequest;
import com.incidenciascore.incidenciascore.response.ContadoresIncidenciasResponse;
import com.incidenciascore.incidenciascore.response.IncidenciasResponse;
import com.incidenciascore.incidenciascore.response.ParamDataResponse;

public interface IncidenciasService {

    ParamDataResponse getInfo();

    IncidenciasResponse eventIncidecnias(IncidenciasRequest request);

    ContadoresIncidenciasResponse eventContaInciden(ContadoresRequest request);

    byte[] generarCsv();

}
