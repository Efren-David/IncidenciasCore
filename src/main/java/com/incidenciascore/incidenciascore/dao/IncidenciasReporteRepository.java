package com.incidenciascore.incidenciascore.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.incidenciascore.incidenciascore.entity.IncidenciasEntity;
import com.incidenciascore.incidenciascore.request.ContadoresRequest;
import com.incidenciascore.incidenciascore.request.IncidenciasRequest;
import com.incidenciascore.incidenciascore.response.ContadoresIncidenciasResponse;
import com.incidenciascore.incidenciascore.response.IncidenciasResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;

@Repository @Transactional @Slf4j
public class IncidenciasReporteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public IncidenciasResponse spEventIncidencias(IncidenciasRequest request) {

        IncidenciasResponse response = new IncidenciasResponse();

        try {

            log.info("-- > Iniciando registro de incidencias... -- > {}",
                    request);

            StoredProcedureQuery procedureQuery = entityManager.createNamedStoredProcedureQuery("evntIncidencias")

                    .registerStoredProcedureParameter("P_COD_SUCURSAL",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_NOMBRE_CLIENTE",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_FECHA_REGISTRO",
                            LocalDateTime.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_TIPO_CLASIFICACION",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_MARCA_PRODUCTO",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_COD_CAJERO",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_COD_REFERENCIA",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_FECHA_ULTIMA_ACT",
                            LocalDateTime.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_DATO_EXTRA",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_ID_REPORTE",
                            Long.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_ESTADO_REPORTE",
                            Integer.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_IND_CITA",
                            Integer.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_IND_ATENCION",
                            Integer.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_FECHA_CITA",
                            LocalDateTime.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_COD_TIPO_EVENTO",
                            Long.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_OBSERVACIONES",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_FECHA_RESOLUCION",
                            LocalDateTime.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_ID_OBSERVACION",
                            Long.class,
                            ParameterMode.IN)

                    .registerStoredProcedureParameter("P_CODIGO",
                            Integer.class,
                            ParameterMode.OUT)
                    .registerStoredProcedureParameter("P_MENSAJE",
                            String.class,
                            ParameterMode.OUT);

            procedureQuery.setParameter("P_COD_SUCURSAL",
                    request.getCodSucursal());
            procedureQuery.setParameter("P_NOMBRE_CLIENTE",
                    request.getNombreCliente());
            procedureQuery.setParameter("P_FECHA_REGISTRO",
                    request.getFechaRegistro());
            procedureQuery.setParameter("P_TIPO_CLASIFICACION",
                    request.getTipoClasificacion());
            procedureQuery.setParameter("P_MARCA_PRODUCTO",
                    request.getMarcaProducto());
            procedureQuery.setParameter("P_COD_CAJERO",
                    request.getCodCajero());
            procedureQuery.setParameter("P_COD_REFERENCIA",
                    request.getCodReferencia());
            procedureQuery.setParameter("P_FECHA_ULTIMA_ACT",
                    request.getFechaUltimaAct());
            procedureQuery.setParameter("P_DATO_EXTRA",
                    request.getDatoExtra());
            procedureQuery.setParameter("P_ID_REPORTE",
                    request.getIdReporte());
            procedureQuery.setParameter("P_ESTADO_REPORTE",
                    request.getEstadoReporte());
            procedureQuery.setParameter("P_IND_CITA",
                    request.getIndCita());
            procedureQuery.setParameter("P_IND_ATENCION",
                    request.getIndAtencion());
            procedureQuery.setParameter("P_FECHA_CITA",
                    request.getFechaCita());
            procedureQuery.setParameter("P_COD_TIPO_EVENTO",
                    request.getCodTipoEvento());
            procedureQuery.setParameter("P_OBSERVACIONES",
                    request.getObservaciones());
            procedureQuery.setParameter("P_FECHA_RESOLUCION",
                    request.getFechaResolucion());
            procedureQuery.setParameter("P_ID_OBSERVACION",
                    request.getIdObservacion());

            procedureQuery.execute();

            Integer codigo = (Integer) procedureQuery.getOutputParameterValue("P_CODIGO");

            String mensaje = (String) procedureQuery.getOutputParameterValue("P_MENSAJE");

            response.setCodigo(codigo);
            response.setMsj(mensaje);

            log.info("< -- Termina el registro de incidencias...  < -- {} {}",
                    codigo,
                    mensaje);

        }
        catch (Exception e) {
            log.info(" < -- Termina registro de incidencias con errores < -- {} ",
                    e.getMessage());
        }

        return response;

    }

    public ContadoresIncidenciasResponse spContaIncidencias(ContadoresRequest request) {

        ContadoresIncidenciasResponse response = new ContadoresIncidenciasResponse();

        try {

            log.info("-- > Iniciando consultaS de contadores e incidencias... -- > {}",
                    request);

            StoredProcedureQuery procedureQuery = entityManager
                    .createNamedStoredProcedureQuery("consultarIncidenciasPorTipo")

                    .registerStoredProcedureParameter("P_TIPO_CLASIFICACION",
                            String.class,
                            ParameterMode.IN)
                    .registerStoredProcedureParameter("P_CURSOR",
                            Class.class,
                            ParameterMode.REF_CURSOR)
                    .registerStoredProcedureParameter("P_CODIGO",
                            Integer.class,
                            ParameterMode.OUT)
                    .registerStoredProcedureParameter("P_MENSAJE",
                            String.class,
                            ParameterMode.OUT);

            procedureQuery.setParameter("P_TIPO_CLASIFICACION",
                    request.getTipoClasificacion());

            procedureQuery.execute();

            Integer codigo = (Integer) procedureQuery.getOutputParameterValue("P_CODIGO");

            String mensaje = (String) procedureQuery.getOutputParameterValue("P_MENSAJE");

            List<IncidenciasEntity> listIncidencias = new ArrayList<>();

            if (codigo == 0) {
                for (Object item : procedureQuery.getResultList()) {
                    listIncidencias.add((IncidenciasEntity) item);
                }
            }

            int contadores = listIncidencias.size();

            response.setCodigo(codigo);
            response.setMsj(mensaje);
            response.setTotalIncidencias(contadores);
            response.setIncidencias(listIncidencias);

            log.info("< -- Termina consulta de contadores e incidencias...  < -- {} ",
                    response);

        }
        catch (Exception e) {
            log.info(" < -- Termina consulta de incidencias con errores < -- {} ",
                    e.getMessage());
        }

        return response;
    }

    public List<IncidenciasEntity> spConsultaReporteIncidencias() {

        StoredProcedureQuery procedureCSVquery = entityManager
                .createNamedStoredProcedureQuery("consultarIncidenciasCsv");

        procedureCSVquery.registerStoredProcedureParameter("P_CURSOR",
                void.class,
                ParameterMode.REF_CURSOR).registerStoredProcedureParameter("P_CODIGO",
                        Integer.class,
                        ParameterMode.OUT)
                .registerStoredProcedureParameter("P_MENSAJE",
                        String.class,
                        ParameterMode.OUT);

        procedureCSVquery.execute();

        return procedureCSVquery.getResultList();
    }

}
