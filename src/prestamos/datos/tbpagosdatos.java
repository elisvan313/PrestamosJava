/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.datos;

import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import prestamos.controlador.TbclienteJpaController;
import prestamos.controlador.TbpagosJpaController;
import prestamos.entity.Tbcliente;
import prestamos.entity.Tbpagos;
import prestamos.entity.Tbprestamo;

/**
 *
 * @author Elisvan
 */
public class tbpagosdatos {
  private TbpagosJpaController tbpagosjpa = new TbpagosJpaController();
    private Tbpagos pago = new Tbpagos();
    public String mensaje = "";
    
     public String Realizarpago(Integer codigoprestamo,String nombrec,Integer saldoactual,Integer cuotaspagadas,Integer cuotaspendientes,Date fechapago){
       
        try {
            pago.setCodigoprestamo(codigoprestamo);
            pago.setNombrec(nombrec);
            pago.setSaldoactual(saldoactual);
            pago.setCuotaspagadas(cuotaspagadas);
            pago.setCuotaspendientes(cuotaspendientes);
            pago.setFechapago(fechapago);
            
            tbpagosjpa.create(pago);
            mensaje = "Pago realizado correctamente";
        } catch (Exception e) {
            System.out.println("Error al realizar el pago :"+e.getMessage());
            mensaje = "Error al realizar el pago";
        }
        
    return mensaje;
    }
     
     public String Eliminarpago(int id){
        try {
            
            tbpagosjpa.destroy(id);
            mensaje = " Pago eliminado correctamente";
        } catch (Exception e) {
            mensaje = "Error al eliminar el pago";
        }
        
        
    return mensaje;
    }
     
   public void listarprestamos(JTable tabla){
    DefaultTableModel model;
    String[] titulo = {"Id pago","Codigo prestamo","Nombre cliente","Saldo actual","#Cuotas pagadas","#Cuotas pendientes","Fecha de pago"};
    model   = new DefaultTableModel(null, titulo);
    
    List<Tbpagos> datos = tbpagosjpa.findTbpagosEntities();
    String [] Datospago = new String[7];
        for (Tbpagos tbpagos : datos ) {
                Datospago[0] = tbpagos.getIdpago()+"";
                Datospago[1] = tbpagos.getCodigoprestamo()+"";
                Datospago[2] = tbpagos.getNombrec()+"";
                Datospago[3] = tbpagos.getSaldoactual()+"";
                Datospago[4] = tbpagos.getCuotaspagadas()+"";
                Datospago[5] = tbpagos.getCuotaspendientes()+"";
                Datospago[6] = tbpagos.getFechapago()+"";
               
                
                model.addRow(Datospago);
        }
        tabla.setModel(model);
    }
    
    
    
    
}
