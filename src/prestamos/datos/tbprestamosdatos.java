/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.datos;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import prestamos.controlador.TbclienteJpaController;
import prestamos.controlador.TbprestamoJpaController;
import prestamos.entity.Tbcliente;
import prestamos.entity.Tbprestamo;

/**
 *
 * @author Elisvan
 */
public class tbprestamosdatos {
     private TbprestamoJpaController tbpresjpa = new TbprestamoJpaController();
    private Tbprestamo nprestamo = new Tbprestamo();
    public String mensaje = "";
    
    public String Agregarprestamo(String nombres,Integer valorprestamo,Integer ncuotas,Integer interes,String tipoprestamo,Integer valorcuota,Date fechaprestamo,Date fechavencer){
       
        try {
          // nprestamo.setCodigo(codigo);
           nprestamo.setNombrec(nombres);
           
            nprestamo.setValorprestamo(valorprestamo);
           
            nprestamo.setNcuotas(ncuotas);
           
            nprestamo.setInteres(interes);
           
            nprestamo.setTipoprestamo(tipoprestamo);
          
            nprestamo.setValorcuota(valorcuota);
            
            nprestamo.setFechaprestamo(fechaprestamo);
           
            nprestamo.setFechavencer(fechavencer);
            
            tbpresjpa.create(nprestamo);
            mensaje = "Prestamo creado correctamente";
        } catch (Exception e) {
            System.out.println("Error al crear prestamo :"+e.getMessage());
            mensaje = "Error al crear el prestamo";
        }
        
    return mensaje;
    }
    public String Editarprestamo(Integer codigo,String nombrec,Integer valorprestamo,Integer ncuotas,Integer interes,String tipoprestamo,Integer valorcuota,Date fechaprestamo,Date fechavencer){
     try {
            
            nprestamo.setCodigo(codigo);
            nprestamo.setNombrec(nombrec);
            nprestamo.setValorprestamo(valorprestamo);
            nprestamo.setNcuotas(ncuotas);
            nprestamo.setInteres(interes);
            nprestamo.setTipoprestamo(tipoprestamo);
            nprestamo.setValorcuota(valorcuota);
            nprestamo.setFechaprestamo(fechaprestamo);
            nprestamo.setFechavencer(fechavencer);
            tbpresjpa.edit(nprestamo);
            mensaje = "Informacion del prestamo actualizada correctamente";
        } catch (Exception e) {
            System.out.println("Error al guardar :"+e.getMessage());
            mensaje = "Error al actualizar la informacion del prestamo \n "+ e.getMessage();
        }
        
    return mensaje;
    }
    
    
    public String Eliminarprestamo(int id){
        try {
            
            tbpresjpa.destroy(id);
            mensaje = " Prestamo eliminado correctamente";
        } catch (Exception e) {
            mensaje = "Error al eliminar el prestamo";
        }
        
        
    return mensaje;
    }
    public Tbprestamo Buscarprestamo(Integer codigo){
        
        try {
          return  tbpresjpa.findTbprestamo(codigo);
          
            
        } catch (Exception e) {
        }
       
        return null;
        
       
   
    }
   
    
    public void listarprestamos(JTable tabla){
    DefaultTableModel model;
    String[] titulo = {"Codigo","Nombre cliente","Valor del prestamo","Numero de cuotas","% Interes","Tipo de prestamo","Valor cuota","Fecha del prestamo","Fecha a vencer cuota"};
    model   = new DefaultTableModel(null, titulo);
    
    List<Tbprestamo> datos = tbpresjpa.findTbprestamoEntities();
    String [] Datosprestamo = new String[9];
        for (Tbprestamo tbpres : datos ) {
                Datosprestamo[0] = tbpres.getCodigo()+"";
                Datosprestamo[1] = tbpres.getNombrec()+"";
                Datosprestamo[2] = tbpres.getValorprestamo()+"";
                Datosprestamo[3] = tbpres.getNcuotas()+"";
                Datosprestamo[4] = tbpres.getInteres()+"";
                Datosprestamo[5] = tbpres.getTipoprestamo()+"";
                Datosprestamo[6] = tbpres.getValorcuota()+"";
                Datosprestamo[7] = tbpres.getFechaprestamo()+"";
                Datosprestamo[8] = tbpres.getFechavencer()+"";
                model.addRow(Datosprestamo);
        }
        tabla.setModel(model);
    }
}
