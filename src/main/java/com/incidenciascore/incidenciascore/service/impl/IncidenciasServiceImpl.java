package com.incidenciascore.incidenciascore.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.incidenciascore.incidenciascore.dao.IncidenciasReporteRepository;
import com.incidenciascore.incidenciascore.dao.IncidenciasRepository;
import com.incidenciascore.incidenciascore.entity.IncidenciasEntity;
import com.incidenciascore.incidenciascore.request.ContadoresRequest;
import com.incidenciascore.incidenciascore.request.IncidenciasRequest;
import com.incidenciascore.incidenciascore.response.ContadoresIncidenciasResponse;
import com.incidenciascore.incidenciascore.response.IncidenciasResponse;
import com.incidenciascore.incidenciascore.response.ParamDataResponse;
import com.incidenciascore.incidenciascore.response.ResponseBuilder;
import com.incidenciascore.incidenciascore.service.IncidenciasService;

import lombok.extern.slf4j.Slf4j;

@Service @Slf4j
public class IncidenciasServiceImpl implements IncidenciasService {

    private final IncidenciasRepository repository;
    private final IncidenciasReporteRepository reporteRepository;

    public IncidenciasServiceImpl(IncidenciasRepository repository, IncidenciasReporteRepository reporteRepository) {
        this.repository = repository;
        this.reporteRepository = reporteRepository;

    }

    @Override
    public ParamDataResponse getInfo() {

        ParamDataResponse response = repository.getInfo();
        return response;
    }

    @Override
    public IncidenciasResponse eventIncidecnias(IncidenciasRequest request) {

        try {

            if (request.getCodSucursal() == null) {

                log.warn("Validación fallida. request={}",
                        request);

                return ResponseBuilder.buildErrorResponse("ERROR EN EL JSON",
                        HttpStatus.BAD_REQUEST);

            }
            IncidenciasResponse response = reporteRepository.spEventIncidencias(request);
            response.setIncidencia(request);

            return response;

        }
        catch (Exception e) {
            log.info("Error interno al procesar la solicitud",
                    e.getMessage());

            return ResponseBuilder.buildErrorResponse("Error interno del servidor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ContadoresIncidenciasResponse eventContaInciden(ContadoresRequest request) {

        try {

            if (request.getTipoClasificacion() == null) {
                log.warn("Validación fallida. request={}",
                        request);

                return ResponseBuilder.buildErrorContadoresResponse("ERROR EN EL JSON",
                        HttpStatus.BAD_REQUEST);

            }
            ContadoresIncidenciasResponse response = reporteRepository.spContaIncidencias(request);

            return response;

        }
        catch (Exception e) {
            log.info("Error interno al procesar la solicitud",
                    e.getMessage());

            return ResponseBuilder.buildErrorContadoresResponse("Error interno del servidor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public byte[] generarCsv() {

        List<IncidenciasEntity> incidencias = reporteRepository.spConsultaReporteIncidencias();

        StringBuilder csv = new StringBuilder();

        csv.append("ID_EVENTO,COD_SUCURSAL,NOMBRE_CLIENTE,FECHA_REGISTRO,")
                .append("TIPO_CLASIFICACION,MARCA_PRODUCTO,COD_CAJERO,COD_REFERENCIA,")
                .append("FECHA_ULTIMA_ACT,DATO_EXTRA,ID_REPORTE,ESTADO_REPORTE,")
                .append("IND_CITA,IND_ATENCION,FECHA_CITA,COD_TIPO_EVENTO,")
                .append("OBSERVACIONES,FECHA_RESOLUCION,ID_OBSERVACION").append("\n");

        for (IncidenciasEntity incidencia : incidencias) {

            csv.append(incidencia.getIdEvento()).append(",").append(incidencia.getCodSucursal()).append(",")
                    .append(incidencia.getNombreCliente()).append(",").append(incidencia.getFechaRegistro()).append(",")
                    .append(incidencia.getTipoClasificacion()).append(",").append(incidencia.getMarcaProducto())
                    .append(",").append(incidencia.getCodCajero()).append(",").append(incidencia.getCodReferencia())
                    .append(",").append(incidencia.getFechaUltimaAct()).append(",").append(incidencia.getDatoExtra())
                    .append(",").append(incidencia.getIdReporte()).append(",").append(incidencia.getEstadoReporte())
                    .append(",").append(incidencia.getIndCita()).append(",").append(incidencia.getIndAtencion())
                    .append(",").append(incidencia.getFechaCita()).append(",").append(incidencia.getCodTipoEvento())
                    .append(",").append(incidencia.getObservaciones()).append(",")
                    .append(incidencia.getFechaResolucion()).append(",").append(incidencia.getIdObservacion())
                    .append("\n");
        }

        byte[] reporteCSV = csv.toString().getBytes(StandardCharsets.UTF_8);

        return reporteCSV;
    }

}
