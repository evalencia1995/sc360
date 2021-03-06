/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc360.struts.jdbc.dao;

import com.sc360.struts.dto.Apelacion;
import com.sc360.struts.dto.Beneficiario;
import com.sc360.struts.dto.EstadoSolicitud;
import com.sc360.struts.dto.Nomina;
import com.sc360.struts.dto.SEYCI;
import com.sc360.struts.dto.Solicitud;
import com.sc360.struts.dto.Detalle;
import com.sc360.struts.dto.Dictamen;
import com.sc360.struts.dto.Reevaluacion;
import com.sc360.struts.dto.Traslado;
import com.sc360.struts.jdbc.conexion.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author epuma
 */
public class ImpSolicitud implements IfaceSolicitud{
    
    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public ImpSolicitud() {
        this.db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String InsertarSolicitud(Solicitud dto) {
       

        /*sql.append("INSERT INTO SOLICITUD(")
                .append("CUSPP,")
                .append("NUMEROEXPEDIENTE,")
                .append("NOMBREAFILIADO")
                .append(") VALUES(?,?,?)");*/
        
       String query = "{ call SP_INSERTAR_SOLICITUD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getCuspp().trim());
                ps.setString(2, dto.getExpediente());
                ps.setString(3, dto.getAfiliado());
                
                ps.setString(4, dto.getPrimerNombre());
                ps.setString(5, dto.getSegundoNombre());
                ps.setString(6, dto.getPrimerApellido());
                ps.setString(7, dto.getSegundoApellido());
                
                ps.setString(8, dto.getEstadoCuenta());
                ps.setString(9, dto.getCausalAfiliado());
                ps.setString(10, dto.getPlanTramite());
                ps.setString(11, dto.getAgenciaInicio());
                ps.setString(12, dto.getPlan());
                ps.setString(13, dto.getBeneficio());
                ps.setString(14, dto.getNroSolicitudFisico());
                ps.setString(15, dto.getSolicitudSysde());
                ps.setString(16, dto.getEtapa());
                ps.setString(17, dto.getEstado());
                ps.setString(18, dto.getCobertura());
                ps.setString(19, dto.getCausalCobertura());
                ps.setString(20, dto.getIndicadorTuitiva());
                ps.setString(21, dto.getCiaProvisional());
                ps.setString(22, dto.getFechaSiniestro());
                ps.setString(23, dto.getFechaDevengue());
                ps.setString(24, dto.getTipoPago()); 
                ps.setString(25, dto.getFechaSeccionI());
                ps.setString(26, dto.getCalculoExcedente());
                ps.setString(27, dto.getRetiroAPV());
                ps.setString(28, dto.getRetiroParcialTotal());
                ps.setString(29, dto.getMontoRetiroAPV());
                ps.setString(30, dto.getFechaSeccionII());
                ps.setString(31, dto.getFechaImpSeccionII());
                ps.setString(32, dto.getPensionPreliminar());
                ps.setString(33, dto.getFechaElecMonSeccionII());
                ps.setString(34, dto.getMontoTipoActSeccionII()); 
                ps.setString(35, dto.getMontoBDRSeccionII());
                ps.setString(36, dto.getEstadoBDRSeccionII());
                ps.setString(37, dto.getDocCompletoSeccionII());
                ps.setString(38, dto.getPensionCalculada());
                ps.setString(39, dto.getPremAFP());
                ps.setString(40, dto.getPremCIASeguros());
                ps.setString(41, dto.getTipoCambioAA());
                ps.setString(42, dto.getCapitalRequeridoAA());
                ps.setString(43, dto.getReservaGSAA());
                ps.setString(44, dto.getCICInformadaAA()); 
                ps.setString(45, dto.getPensionDevengada());
                ps.setString(46, dto.getPensionPagadas());
                ps.setString(47, dto.getMontoAAMeller());
                ps.setString(48, dto.getFechaValorCuotaAA());
                ps.setString(49, dto.getCuotasAA());
                ps.setString(50, dto.getValorCuotaAA());
                ps.setString(51, dto.getFechaPagoAA());
                ps.setString(52, dto.getFechaAcreditacionAA());
                ps.setString(53, dto.getMontoBDRMeller());
                ps.setString(54, dto.getFechaValorCuotaBDR());
                ps.setString(55, dto.getCuotasBDR());
                ps.setString(56, dto.getValorCuotaBDR());
                ps.setString(57, dto.getFechaPagoBDR());
                ps.setString(58, dto.getFechaAcreditacionBDR());
                ps.setString(59, dto.getFechaSeccionIII());
                ps.setString(60, dto.getDevengueDefinitivo());
                ps.setString(61, dto.getCapitalPension());
                ps.setString(62, dto.getCICMeller());
                ps.setString(63, dto.getMontoAAMellerActualizado());
                ps.setString(64, dto.getMontoBDRMellerActualizado());
                ps.setString(65, dto.getFechaSeccionIV());
                ps.setString(66, dto.getFechaEleccionModalidad());
                ps.setString(67, dto.getCiaAsegurosAFP());
                ps.setString(68, dto.getNroCotizacion());
                ps.setString(69, dto.getProducto());
                ps.setString(70, dto.getMonedaProductoGanador());
                ps.setString(71, dto.getCaractMoneda());
                ps.setString(72, dto.getAnioRT());
                ps.setString(73, dto.getPorcRT());
                ps.setString(74, dto.getAnioPG());
                ps.setString(75, dto.getPorcPG());
                ps.setString(76, dto.getDerechoCrecer());
                ps.setString(77, dto.getGrati());
                ps.setString(78, dto.getTasaInteresAFP());
                ps.setString(79, dto.getPensionBaseRT());
                ps.setString(80, dto.getTasaInteresCIASeguro());
                ps.setString(81, dto.getPensionBaseRVD());
                ps.setString(82, dto.getFechaNotificacion());
                ps.setString(83, dto.getFechaEmisionRecalculo());
                ps.setString(84, dto.getFechaRecepcionRecalculo());
                ps.setString(85, dto.getMontoTrxCiaSeguro());
                ps.setString(86, dto.getMontoPagoAfpRT());
                ps.setString(87, dto.getNuevaPensionRT());
                ps.setString(88, dto.getNuevaPensionBaseRVD());
                ps.setString(89, dto.getMtoTransPagado());
                ps.setString(90, dto.getFecTransferencia_FechaOperacion());
                ps.setString(91, dto.getMontoPagoGS());
                ps.setString(92, dto.getFecPagoGS());
                ps.setString(93, dto.getFecPrimerPago());
                ps.setString(94, dto.getMontoPrimerPago());
                ps.setString(95, dto.getFechaUltimoPago());
                ps.setString(96, dto.getIndicadorCargoCuenta());
                ps.setString(97, dto.getNumeroPoliza());
                ps.setString(98, dto.getFechaPoliza());
                ps.setString(99, dto.getIndicadorEndoso());
                
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
    }

    @Override
    public List<Solicitud> ListadoSolicitud(Solicitud dto) {
        
         List<Solicitud> listSolicitud = null;
         String query = "{ call SP_LISTAR_SOLICITUDES(?,?,?,?,?,?,?,?,?,?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getTipoDocumento());
                ps.setString(2, dto.getNumeroDocumento());
                ps.setString(3, dto.getFechaSeccionIni());
                ps.setString(4, dto.getFechaSeccionFin());
                ps.setString(5, dto.getFechaAsigIni());
                ps.setString(6, dto.getFechaAsigFin());
                ps.setString(7, dto.getFechaVencIni());
                ps.setString(8, dto.getFevhaVencFin());
                ps.setString(9, dto.getAnalista());
                ps.setString(10,dto.getEstadoSolicitud());
                
                ResultSet rs = ps.executeQuery();

                listSolicitud = new LinkedList<>();
                
                while (rs.next()) {
                Solicitud p = new Solicitud();

                p.setIdSolicitud(rs.getString(1));
                p.setCuspp(rs.getString(2));
                p.setAfiliado(rs.getString(3));
                p.setPlan(rs.getString(4));
                p.setEtapa(rs.getString(5));
                p.setFechaVencimientoSolicitud(rs.getString(6));
                p.setEstado(rs.getString(7));

                listSolicitud.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listSolicitud;
        
        
        
        
    }

    @Override
    public String InsertarBeneficiario(Beneficiario dto) {
        
        String query = "{ call SP_INSERTAR_BENEFICIARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getCuspp().trim());
                ps.setString(2, dto.getExpediente());
                ps.setString(3, dto.getCodPersona());
                ps.setString(4, dto.getNumeroCuenta());
                ps.setString(5, dto.getEstadoCuenta());
                ps.setString(6, dto.getCausalAfiliado());
                ps.setString(7, dto.getCodMatricula());
                ps.setString(8, dto.getAfiliado());
                ps.setString(9, dto.getFechaNcmtoAfi());
                ps.setString(10, dto.getFechaFallecAfi());
                ps.setString(11, dto.getSexoAfi());
                ps.setString(12, dto.getTipDocAfi());
                ps.setString(13, dto.getNumDocAfi());
                ps.setString(14, dto.getDireccionAfi());
                ps.setString(15, dto.getUbigeoAfi());
                ps.setString(16, dto.getDepartamentoAfi());
                ps.setString(17, dto.getProvinciaAfi());
                ps.setString(18, dto.getDistritoAfi());
                ps.setString(19, dto.getNroSolicitud());
                ps.setString(20, dto.getFechaSolicitud()); 
                ps.setString(21, dto.getTipoDeSolicitud());
                ps.setString(22, dto.getEstadoSol());
                ps.setString(23, dto.getAgencia1());
                ps.setString(24, dto.getEjecutiva());
                ps.setString(25, dto.getCodigoDeBeneficiario());
                ps.setString(26, dto.getMatricula());
                ps.setString(27, dto.getBeneficiario());
                ps.setString(28, dto.getParentesco());
                ps.setString(29, dto.getFechaNcmtoBnef());
                ps.setString(30, dto.getSexoBnef()); 
                ps.setString(31, dto.getEstadoBnef());
                ps.setString(32, dto.getIndAfiliado());
                ps.setString(33, dto.getTipoDocBnef());
                ps.setString(34, dto.getNumDocBnef());
                ps.setString(35, dto.getPorcentaje());
                ps.setString(36, dto.getDoc());
                ps.setString(37, dto.getDict());
                ps.setString(38, dto.getInv());
                ps.setString(39, dto.getSeci());
                ps.setString(40, dto.getDep()); 
                ps.setString(41, dto.getEstudios());
                ps.setString(42, dto.getCodApoderado());
                ps.setString(43, dto.getApoderado());
                ps.setString(44, dto.getTipDocApod());
                ps.setString(45, dto.getNumDocApod());
                ps.setString(46, dto.getDieBeneficios());
                ps.setString(47, dto.getDireccionApod());
                ps.setString(48, dto.getUbigeoApod());
                ps.setString(49, dto.getDepartamentoApod());
                ps.setString(50, dto.getProvinciaApod());
                ps.setString(51, dto.getDistritoApod());
                ps.setString(52, dto.getCorreoElectronicoApo());
                ps.setString(53, dto.getFormaPago());
                ps.setString(54, dto.getTipoCuenta());
                ps.setString(55, dto.getNroCuenta());
                ps.setString(56, dto.getBanco());
                ps.setString(57, dto.getLugarRemBoleta());
                ps.setString(58, dto.getAgencia2());
                ps.setString(59, dto.getEjecutivaIngBnef());
                ps.setString(60, dto.getFechaRegistroBnef());
                ps.setString(61, dto.getCodDemandante());
                ps.setString(62, dto.getDemandante());
                ps.setString(63, dto.getTipDocDem());
                ps.setString(64, dto.getNumDocDem());
                ps.setString(65, dto.getFormaPagoDem());
                ps.setString(66, dto.getBancoDem());
                ps.setString(67, dto.getTipoCuentaDem());
                ps.setString(68, dto.getNumCuentaDem());
                ps.setString(69, dto.getAgenciaDem());
                ps.setString(70, dto.getNroOrdenJudicial());
                ps.setString(71, dto.getDescOrganismoRetJud());
                ps.setString(72, dto.getFechaAprobacionDemandaJud());
                ps.setString(73, dto.getPersonaDemandada());
                
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
        
        
        
    }

    @Override
    public String InsertarSEYCI(SEYCI dto) {
        
        
        String query = "{ call SP_INSERTAR_SEYCI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getCuspp().trim());
                ps.setString(2, dto.getExp());
                ps.setString(3, dto.getAfiliado());
                ps.setString(4, dto.getPrimerNombre());
                ps.setString(5, dto.getSegundoNombre());
                ps.setString(6, dto.getPrimerApellido());
                ps.setString(7, dto.getSegundoApellido()); 
                ps.setString(8, dto.getEstadoCuenta());
                ps.setString(9, dto.getCausal());
                ps.setString(10, dto.getTipoDocumento());
                ps.setString(11, dto.getNumeroDocumento());
                ps.setString(12, dto.getDireccionAfi());
                ps.setString(13, dto.getUbigeoAfi());
                ps.setString(14, dto.getDepartamentoAfi());
                ps.setString(15, dto.getProvinciaAfi());
                ps.setString(16, dto.getDistritoAfi());
                ps.setString(17, dto.getEmailAfi());
                ps.setString(18, dto.getTelefonoAfi());
                ps.setString(19, dto.getAgenciaInicioTramite());
                ps.setString(20, dto.getEjecutivaAgencia());
                ps.setString(21, dto.getTipoDeTramite());
                ps.setString(22, dto.getTipoSolicitud());
                ps.setString(23, dto.getNaturalezaDeSolicitud());
                ps.setString(24, dto.getNaturalezaOriginal()); 
                ps.setString(25, dto.getGradoOriginal());
                ps.setString(26, dto.getDjDeBeneficiarios());
                ps.setString(27, dto.getIndicadorDeBenficiarios());
                ps.setString(28, dto.getTipoDeEvaluado());
                ps.setString(29, dto.getSexo());
                ps.setString(30, dto.getFechaNacEvaluado());
                ps.setString(31, dto.getApellidosNombresBnef());
                ps.setString(32, dto.getParentescoSolicitanteBnef());
                ps.setString(33, dto.getNumeroSolicitud());
                ps.setString(34, dto.getEstado1()); 
                ps.setString(35, dto.getSubEstadoMotivo());
                ps.setString(36, dto.getFechaDeEstado());
                ps.setString(37, dto.getCobertura());
                ps.setString(38, dto.getCausalDeCobertura());
                ps.setString(39, dto.getTuitiva());
                ps.setString(40, dto.getCiaPrevisional());
                ps.setString(41, dto.getFechaSeccionI());
                ps.setString(42, dto.getFechaSeccionIIISolicitante());
                ps.setString(43, dto.getFecSecIVMedicoRepAFP());
                ps.setString(44, dto.getCausalDeInvalidez()); 
                ps.setString(45, dto.getFechaEnvioCOMAFP());
                ps.setString(46, dto.getFecEnvioEvaluado());
                ps.setString(47, dto.getFecEvaluadoRecibeNotif());
                ps.setString(48, dto.getFechaEnvioCíaSeguros());
                ps.setString(49, dto.getNivelEstudios());
                ps.setString(50, dto.getGrado1());
                ps.setString(51, dto.getSubdisio());
                ps.setString(52, dto.getFechaInicioSubsidio());
                ps.setString(53, dto.getFechaFinSubsidio());
                ps.setString(54, dto.getSituacionLaboralActual());
                ps.setString(55, dto.getSeguroComplementario());
                ps.setString(56, dto.getFecIniOcurrenciaSCTR());
                ps.setString(57, dto.getFecFinOcurrenciaSCTR());
                ps.setString(58, dto.getActividadLaboral());
                ps.setString(59, dto.getCircunstanciasInvalidez());
                ps.setString(60, dto.getDiagnostico());
                ps.setString(61, dto.getDetalleOtrosDocs());
                ps.setString(62, dto.getObservacionesSeyci());
                ps.setString(63, dto.getMotivoDeCancelacion());
                ps.setString(64, dto.getObservacionesCancelacion());
                ps.setString(65, dto.getNroDictamenCOMAFP());
                ps.setString(66, dto.getNroDeEvaluacion1());
                ps.setString(67, dto.getEntidadEvaluadora1());
                ps.setString(68, dto.getFechaDeEmision1());
                ps.setString(69, dto.getFechaRecepcion1());
                ps.setString(70, dto.getFechaInicioVigencia1());
                ps.setString(71, dto.getFechaFinVigencia1());
                ps.setString(72, dto.getMeses1());
                ps.setString(73, dto.getFechaProximaEvaluacion1());
                ps.setString(74, dto.getFechaOcurrencia1());
                ps.setString(75, dto.getIndicadorDeDefinitivo1());
                ps.setString(76, dto.getEstado2());
                ps.setString(77, dto.getGrado2());
                ps.setString(78, dto.getNaturaleza1());
                ps.setString(79, dto.getPorcMenoscaboAsignado1());
                ps.setString(80, dto.getCalificacionInvalidez1());
                ps.setString(81, dto.getIndExclusion1());
                ps.setString(82, dto.getFecNotifDictAlEvaluado());
                ps.setString(83, dto.getObservacionesDictamenCOMAFP());
                ps.setString(84, dto.getSolApelacion());
                ps.setString(85, dto.getFecSolicitudApelacion());
                ps.setString(86, dto.getFecEnvioApelacion());
                ps.setString(87, dto.getFecNotificacionApelacion());
                ps.setString(88, dto.getFecRecepcionDelAfiliado());
                ps.setString(89, dto.getObjetoApelacion());
                ps.setString(90, dto.getMotivoApelacion());
                ps.setString(91, dto.getEntidadQueApela());
                ps.setString(92, dto.getNroDictamenCOMEC());
                ps.setString(93, dto.getNroDeEvaluacion2());
                ps.setString(94, dto.getEntidadEvaluadora2());
                ps.setString(95, dto.getFechaDeEmision2());
                ps.setString(96, dto.getFechaRecepcion2());
                ps.setString(97, dto.getFechaInicioVigencia2());
                ps.setString(98, dto.getFechaFinVigencia2());
                ps.setString(99, dto.getMeses2());
                ps.setString(100, dto.getFechaProximaEvaluacion2());
                ps.setString(101, dto.getFechaOcurrencia2());
                ps.setString(102, dto.getIndicadordeDefinitivo2());
                ps.setString(103, dto.getEstado3());
                ps.setString(104, dto.getGrado3());
                ps.setString(105, dto.getNaturaleza2());
                ps.setString(106, dto.getPorMenoscaboAsignado2());
                ps.setString(107, dto.getIndExclusion2());
                ps.setString(108, dto.getCalificacionInvalidez2());
                ps.setString(109, dto.getFecNotifDictCOMECAFP());
                ps.setString(110, dto.getObservacionesDictamenCOMEC());
                ps.setString(111, dto.getNroRetiro());
                ps.setString(112, dto.getFechaSolicitudRetiro());
                ps.setString(113, dto.getTramitePensionIniciado());
                ps.setString(114, dto.getCalificacionInvalidez3());
                ps.setString(115, dto.getSaldoFechaDeRetiro());
                ps.setString(116, dto.getPorcDeRetiro());
                ps.setString(117, dto.getMontoEntregar());         
                ps.setString(118, dto.getEstadoDeRetiro());
                ps.setString(119, dto.getFechaDeAcreditacion());
                ps.setString(120, dto.getMontoAcreditado());
                ps.setString(121, dto.getNroSolJA());
                ps.setString(122, dto.getTipoDeBeneficio());
                ps.setString(123, dto.getFechaSolJA());
                ps.setString(124, dto.getStadoSolJA());

                
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
        
    }

    @Override
    public String InsertarNomina(Nomina dto) {
        
        String query = "{ call SP_INSERTAR_NOMINA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getFecha().trim());
                ps.setString(2, dto.getNumeroDeSolicitud().trim());
                ps.setString(3, dto.getCUSPP1());
                ps.setString(4, dto.getAfiliado1());
                ps.setString(5, dto.getEjecutivoDeServicioDeAtencion1());
                ps.setString(6, dto.getAgencia1());
                ps.setString(7, dto.getEjecutiva());
                ps.setString(8, dto.getTramiteDerivacionPensionistas());
                ps.setString(9, dto.getComentario());
                ps.setString(10, dto.getFechaDeValija());
                ps.setString(11, dto.getFechaTramite());
                ps.setString(12, dto.getFechaDigitalizacionRecepcion());
                ps.setString(13, dto.getFechaDeEntrega());
                ps.setString(14, dto.getCUSPP2());
                ps.setString(15, dto.getAfiliado2());
                ps.setString(16, dto.getTipoTramite());
                ps.setString(17, dto.getSeccion());
                ps.setString(18, dto.getAnalista());
                ps.setString(19, dto.getNumeroSolicitud());
                ps.setString(20, dto.getAgencia2()); 
                ps.setString(21, dto.getEjecutivoDeServicioDeAtencion2());
                ps.setString(22, dto.getObservacionesDelAnalistaDeAsigna());

        
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
    }

    @Override
    public List<Detalle> ListadoDetalleSolicitud(Solicitud dto) {
        
         List<Detalle> listSolicitud = null;
         String query = "{ call SP_LISTAR_DETALLE_SOLICITUD(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getIdSolicitud());

                ResultSet rs = ps.executeQuery();

                listSolicitud = new LinkedList<>();
                
                while (rs.next()) {
                Detalle p = new Detalle();
                
                p.setNumeroSolicitud(rs.getString(1));
                p.setExp(rs.getString(2));
                p.setCuspp(rs.getString(3));
                p.setPrimerNombre(rs.getString(4));
                p.setSegundoNombre(rs.getString(5));
                p.setPrimerApellido(rs.getString(6));
                p.setSegundoApellido(rs.getString(7));
                p.setFechaNacimiento(rs.getString(8));
                p.setCorreo(rs.getString(9));
                p.setSexo(rs.getString(10));
                p.setTelefono(rs.getString(11));
                p.setEstadoCivil(rs.getString(12));
                p.setDireccion(rs.getString(13));
                p.setNombreDepartamento(rs.getString(14));
                p.setDepartamento(rs.getString(15));
                p.setNombreProvincia(rs.getString(16));
                p.setProvincia(rs.getString(17));
                p.setNombreDistrito(rs.getString(18));
                p.setDistrito(rs.getString(19));
                
                

                listSolicitud.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listSolicitud;
        
        
    }

    @Override
    public List<SEYCI> ListadoSeyci(SEYCI dto) {
        
        List<SEYCI> listSeyci = null;
         String query = "{ call SP_LISTAR_DETALLE_SEYCI(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getExp());

                ResultSet rs = ps.executeQuery();

                listSeyci = new LinkedList<>();
                
                while (rs.next()) {
                SEYCI p = new SEYCI();
                
                p.setEjecutivaAgencia(rs.getString(1));
                p.setNumeroSolicitud(rs.getString(2));
                p.setTipoSolicitud(rs.getString(3));
                p.setTipoDeEvaluado(rs.getString(4));
                p.setPrimerNombre(rs.getString(5));
                p.setSegundoNombre(rs.getString(6));
                p.setPrimerApellido(rs.getString(7));
                p.setSegundoApellido(rs.getString(8));
                p.setFechaNacEvaluado(rs.getString(9));
                p.setFechaSeccionI(rs.getString(10));
                p.setFechaEnvioCOMAFP(rs.getString(11));
                p.setObservacionesSeyci(rs.getString(12));
                p.setExp(rs.getString(13));

                listSeyci.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listSeyci;
        
        
    }

    @Override
    public String ActualizarSEYCI(SEYCI dto) {
        
        
        String query = "{ call SP_ACTUALIZAR_SEYCI_DG(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getExp());
                ps.setString(2, dto.getCuspp());
                ps.setString(3, dto.getPrimerNombre());
                ps.setString(4, dto.getSegundoNombre());
                ps.setString(5, dto.getPrimerApellido());
                ps.setString(6, dto.getSegundoApellido());
                ps.setString(7, dto.getFechaNacEvaluado());
                ps.setString(8, dto.getEmailAfi());
                ps.setString(9, dto.getSexo());
                ps.setString(10, dto.getTelefonoAfi());
                ps.setString(11, dto.getDireccionAfi());
                ps.setString(12, dto.getDepartamentoAfi());
                ps.setString(13, dto.getProvinciaAfi());
                ps.setString(14, dto.getDistritoAfi());
        
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
    }

    @Override
    public String ActualizarSEYCITab(SEYCI dto) {
        
        String query = "{ call SP_ACTUALIZAR_SEYCI_TAB(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getExp());
                ps.setString(2, dto.getEjecutivaAgencia());
                ps.setString(3, dto.getNumeroSolicitud());
                ps.setString(4, dto.getTipoSolicitud());
                ps.setString(5, dto.getTipoDeEvaluado());
                ps.setString(6, dto.getPrimerNombre());
                ps.setString(7, dto.getSegundoNombre());
                ps.setString(8, dto.getPrimerApellido());
                ps.setString(9, dto.getSegundoApellido());
                ps.setString(10, dto.getFechaNacEvaluado());
                ps.setString(11, dto.getFechaSeccionI());
                ps.setString(12, dto.getFechaEnvioCOMAFP());
                ps.setString(13, dto.getObservacionesSeyci());
        
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
        
    }

    @Override
    public List<Traslado> ListadoTraslado(Traslado dto) {
        
        
        List<Traslado> listTraslado = null;
         String query = "{ call SP_LISTAR_TRASLADO_SEYCI(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getNroExpSeyci());

                ResultSet rs = ps.executeQuery();

                listTraslado = new LinkedList<>();
                
                while (rs.next()) {
                Traslado p = new Traslado();
                
                p.setIdTraslado(rs.getString(1));
                p.setNroExpSeyci(rs.getString(2));
                p.setNroTraslado(rs.getString(3));
                p.setFechaCita(rs.getString(4));
                p.setAcompanante(rs.getString(5));
                p.setTipo(rs.getString(6));
                p.setOrigen(rs.getString(7));
                p.setDestino(rs.getString(8));
                p.setFechaAprobacion(rs.getString(9));
                p.setMoneda1(rs.getString(10));
                p.setTipoMovilidad(rs.getString(11));
                p.setMontoMovilidad(rs.getString(12));
                p.setMoneda2(rs.getString(13));
                p.setDiasAlimentacion(rs.getString(14));
                p.setMontoAlimentacion(rs.getString(15));
                p.setMonto3(rs.getString(16));
                p.setDiasAlojamiento(rs.getString(17));
                p.setMontoAlojamiento(rs.getString(18));
                p.setMontoExtraMedicos(rs.getString(19));
                p.setTotalGasto(rs.getString(20));
                p.setEjecutiva(rs.getString(21));
                p.setAnalista(rs.getString(22));
                

                listTraslado.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listTraslado;
        
        
    }

    @Override
    public String InsertarActualizarTraslado(Traslado dto) {
        
        String query = "{ call SP_INSERT_UPDATE_TRASLADO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getNroExpSeyci());
                ps.setString(2, dto.getNroTraslado());
                ps.setString(3, dto.getFechaCita());
                ps.setString(4, dto.getAcompanante());
                ps.setString(5, dto.getTipo());
                ps.setString(6, dto.getOrigen());
                ps.setString(7, dto.getDestino());
                ps.setString(8, dto.getFechaAprobacion());
                ps.setString(9, dto.getMoneda1());
                ps.setString(10, dto.getTipoMovilidad());
                ps.setString(11, dto.getMontoMovilidad());
                ps.setString(12, dto.getMoneda2());
                ps.setString(13, dto.getDiasAlimentacion());
                ps.setString(14, dto.getMontoAlimentacion());
                ps.setString(15, dto.getMonto3());
                ps.setString(16, dto.getDiasAlojamiento());
                ps.setString(17, dto.getMontoAlojamiento());
                ps.setString(18, dto.getMontoExtraMedicos());
                ps.setString(19, dto.getTotalGasto());
                ps.setString(20, dto.getEjecutiva());
                ps.setString(21, dto.getAnalista());
                
                
        
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
        
    }

    @Override
    public List<Reevaluacion> ListadoReevaluacion(Reevaluacion dto) {
        
        
         List<Reevaluacion> listReevaluacion = null;
         String query = "{ call SP_LISTAR_REEVALUACION(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getNumeroSeyci());

                ResultSet rs = ps.executeQuery();

                listReevaluacion = new LinkedList<>();
                
                while (rs.next()) {
                Reevaluacion p = new Reevaluacion();
                
                p.setNumeroSeyci(rs.getString(1));
                p.setFechaIngresoBeneficios(rs.getString(2));
                p.setTipoDocumento(rs.getString(3));
                p.setFechaEvaluacion(rs.getString(4));
                p.setAnalista(rs.getString(5));
                p.setFechaNotificacion(rs.getString(6));
                p.setResponsable(rs.getString(7));
                p.setObservaciones(rs.getString(8));
                

                listReevaluacion.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listReevaluacion;
        
    }

    @Override
    public String InsertarActualizarReevaluacion(Reevaluacion dto) {
        
        
        String query = "{ call SP_INSERT_UPDATE_REEVALUACION(?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getNumeroSeyci());
                ps.setString(2, dto.getFechaIngresoBeneficios());
                ps.setString(3, dto.getTipoDocumento());
                ps.setString(4, dto.getFechaEvaluacion());
                ps.setString(5, dto.getAnalista());
                ps.setString(6, dto.getFechaNotificacion());
                ps.setString(7, dto.getResponsable());
                ps.setString(8, dto.getObservaciones());

                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
        
    }

    @Override
    public List<Dictamen> ListadoDictamen(Dictamen dto) {
        
        List<Dictamen> listDictamen = null;
         String query = "{ call SP_LISTAR_DICTAMEN(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getNroSeyci());

                ResultSet rs = ps.executeQuery();

                listDictamen = new LinkedList<>();
                
                while (rs.next()) {
                Dictamen p = new Dictamen();
                
                p.setNroSeyci(rs.getString(1));
                p.setFecRecAFP(rs.getString(2));
                p.setFecEmision(rs.getString(3));
                p.setInstancia(rs.getString(4));
                p.setNroEvaluacion(rs.getString(5));
                p.setNroDictamen(rs.getString(6));
                p.setPorcMenoscabio(rs.getString(7));
                p.setCalifica(rs.getString(8));
                p.setIndEnf(rs.getString(9));
                p.setDefinitivo(rs.getString(10));
                p.setGrado(rs.getString(11));
                p.setNaturaleza(rs.getString(12));
                p.setMeses(rs.getString(13));
                p.setFecInicial(rs.getString(14));
                p.setFecFinal(rs.getString(15));
                p.setFecOcurrencia(rs.getString(16));
                p.setProximaEvaluacion(rs.getString(17));
                p.setFecNotificacion(rs.getString(18));
                p.setFecRecNotificacion(rs.getString(19));
                p.setEdad(rs.getString(20));
                p.setAnalista(rs.getString(21));
                p.setObservaciones(rs.getString(22));

                listDictamen.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listDictamen;
    }

    @Override
    public String InsertarActualizarDictamen(Dictamen dto) {
        
        String query = "{ call SP_INSERT_UPDATE_DICTAMEN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getNroSeyci());
                ps.setString(2, dto.getFecRecAFP());
                ps.setString(3, dto.getFecEmision());
                ps.setString(4, dto.getInstancia());
                ps.setString(5, dto.getNroEvaluacion());
                ps.setString(6, dto.getNroDictamen());
                ps.setString(7, dto.getPorcMenoscabio());
                ps.setString(8, dto.getCalifica());
                ps.setString(9, dto.getIndEnf());
                ps.setString(10, dto.getDefinitivo());
                ps.setString(11, dto.getGrado());
                ps.setString(12, dto.getNaturaleza());
                ps.setString(13, dto.getMeses());
                ps.setString(14, dto.getFecInicial());
                ps.setString(15, dto.getFecFinal());
                ps.setString(16, dto.getFecOcurrencia());
                ps.setString(17, dto.getProximaEvaluacion());
                ps.setString(18, dto.getFecNotificacion());
                ps.setString(19, dto.getFecRecNotificacion());
                ps.setString(20, dto.getEdad());
                ps.setString(21, dto.getAnalista());
                ps.setString(22, dto.getObservaciones());
                
                
        
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
  
    }

    @Override
    public List<Apelacion> ListadoApelacion(Apelacion dto) {
        
        List<Apelacion> listApelacion = null;
         String query = "{ call SP_LISTAR_APELACION(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getNroSeyci());

                ResultSet rs = ps.executeQuery();

                listApelacion = new LinkedList<>();
                
                while (rs.next()) {
                Apelacion p = new Apelacion();
                
                p.setNroSeyci(rs.getString(1));
                p.setPersonaApela(rs.getString(2));
                p.setMotivoApelacion(rs.getString(3));
                /*p.setFechaEvaluacion(rs.getString(4));
                p.setAnalista(rs.getString(5));
                p.setFechaNotificacion(rs.getString(6));
                p.setResponsable(rs.getString(7));
                p.setObservaciones(rs.getString(8));*/
                

                listApelacion.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listApelacion;
        
    }

    @Override
    public String InsertarActualizarApelacion(Apelacion dto) {
        
        
        String query = "{ call SP_INSERT_UPDATE_APELACION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        
        try (
                Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString())){
               
                ps.setString(1, dto.getNroSeyci());
                ps.setString(2, dto.getNroDictamenApelado());
                ps.setString(3, dto.getPersonaApela());
                ps.setString(4, dto.getFechaApelacion());
                ps.setString(5, dto.getFecIngBeneficios());
                ps.setString(6, dto.getFecEnvCarta());
                ps.setString(7, dto.getRecepCOMAFP());
                ps.setString(8, dto.getAnalista());
                ps.setString(9, dto.getMotivoApelacion());
                ps.setString(10, dto.getNroExpDictamenApelado());
                ps.setString(11, dto.getDisPacifico());
                ps.setString(12, dto.getFecDictamen());
                ps.setString(13, dto.getFecEnvioDis());
                ps.setString(14, dto.getOK());
                ps.setString(15, dto.getFecNotAfiliado());
                ps.setString(16, dto.getFecNotCOMEC());
                ps.setString(17, dto.getObservaciones());
                
                int cant = ps.executeUpdate();
                System.out.println(" Cantidad : " + cant);
                sql.delete(0, sql.length());
                if (cant == 0) {
                throw new SQLException("0 filas afectadas");
            }


        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return message;
        
    }

    @Override
    public List<Traslado> ListadoTrasladoItem(Traslado dto) {
        
        List<Traslado> listTraslado = null;
         String query = "{ call SP_LISTAR_TRASLADO_SEYCI_ITEM(?) }";
        
        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(query.toString());
                ) {
            
                ps.setString(1, dto.getIdTraslado());

                ResultSet rs = ps.executeQuery();

                listTraslado = new LinkedList<>();
                
                while (rs.next()) {
                Traslado p = new Traslado();
                
                p.setIdTraslado(rs.getString(1));
                p.setNroExpSeyci(rs.getString(2));
                p.setNroTraslado(rs.getString(3));
                p.setFechaCita(rs.getString(4));
                p.setAcompanante(rs.getString(5));
                p.setTipo(rs.getString(6));
                p.setOrigen(rs.getString(7));
                p.setDestino(rs.getString(8));
                p.setFechaAprobacion(rs.getString(9));
                p.setMoneda1(rs.getString(10));
                p.setTipoMovilidad(rs.getString(11));
                p.setMontoMovilidad(rs.getString(12));
                p.setMoneda2(rs.getString(13));
                p.setDiasAlimentacion(rs.getString(14));
                p.setMontoAlimentacion(rs.getString(15));
                p.setMonto3(rs.getString(16));
                p.setDiasAlojamiento(rs.getString(17));
                p.setMontoAlojamiento(rs.getString(18));
                p.setMontoExtraMedicos(rs.getString(19));
                p.setTotalGasto(rs.getString(20));
                p.setEjecutiva(rs.getString(21));
                p.setAnalista(rs.getString(22));
                

                listTraslado.add(p);
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return listTraslado;
    }
        
    
    
    
    
}
