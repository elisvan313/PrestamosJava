/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.datos;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import prestamos.controlador.TbclienteJpaController;
import prestamos.entity.Tbcliente;

/**
 *
 * @author Elisvan
 */
public class tbclientedatos {
    
    private TbclienteJpaController tbcjpa = new TbclienteJpaController();
    private Tbcliente cliente = new Tbcliente();
    public String mensaje = "";
    
    public String Agregarcliente(String nombres,String apellidos,Integer cedula,String direccion,String telefono){
       
        try {
            
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setCedula(cedula);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            tbcjpa.create(cliente);
            mensaje = "Cliente creado correctamente";
        } catch (Exception e) {
            System.out.println("Error al guardar :"+e.getMessage());
            mensaje = "Error al crear el cliente";
        }
        
    return mensaje;
    }
    public String Editarcliente(String nombres,String apellidos,Integer cedula,String direccion,String telefono){
     try {
            
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setCedula(cedula);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            tbcjpa.edit(cliente);
            mensaje = "Informacion del cliente actualizada correctamente";
        } catch (Exception e) {
            System.out.println("Error al guardar :"+e.getMessage());
            mensaje = "Error al actualizar la informacion del cliente \n "+ e.getMessage();
        }
        
    return mensaje;
    }
    
    
    public String Eliminarcliente(int id){
        try {
            
            tbcjpa.destroy(id);
            mensaje = "Informacion del cliente eliminada correctamente";
        } catch (Exception e) {
            mensaje = "Error al eliminar la informacion del cliente";
        }
        
        
    return mensaje;
    }
    public Tbcliente BuscarCliente(Integer cedula){
        
        try {
          return  tbcjpa.findTbcliente(cedula);
          
            
        } catch (Exception e) {
        }
       
        return null;
        
       
   
    }
    
    public void listarclientes(JTable tabla){
    DefaultTableModel model;
    String[] titulo = {"cedula","nombres","apellidos","direccion","telefono"};
    model   = new DefaultTableModel(null, titulo);
    
    List<Tbcliente> datos = tbcjpa.findTbclienteEntities();
    String [] Datoscliente = new String[5];
        for (Tbcliente tbc : datos ) {
                Datoscliente[0] = tbc.getCedula()+"";
                Datoscliente[1] = tbc.getNombres()+"";
                Datoscliente[2] = tbc.getApellidos()+"";
                Datoscliente[3] = tbc.getDireccion()+"";
                Datoscliente[4] = tbc.getTelefono()+"";
                model.addRow(Datoscliente);
        }
        tabla.setModel(model);
    }
}
