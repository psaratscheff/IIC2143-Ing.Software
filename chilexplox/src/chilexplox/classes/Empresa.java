/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chilexplox.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peter
 */
public class Empresa {
    
    //SINGLETON!! Clase maestra
    private final static Empresa instance = new Empresa();

    /**
     * Retorna la única instancia (singleton) de Empresa
     * @return
     */
    public static Empresa getInstance() {
        return instance;
    }
    
    public List<Sucursal> sucursales;
    public List<Camion> camiones;
    public List<Cliente> clientes;
    public List<Encomienda> encomiendas;
    public List<Empleado> empleados;
    public Empleado empleadoActual;
    public Sucursal sucursalActual;
    public int IDEncomienda = 0;
    public int IDPedido = 0;
    public Pedido pedidotemp;
    
    public Empresa()
    {
        //Inicializo los arrays para poder agregar valores
        this.sucursales = new ArrayList();
        this.camiones = new ArrayList();
        this.clientes = new ArrayList();
        this.encomiendas = new ArrayList();
        this.empleados = new ArrayList();
    }
    public List<String> getDireccionSucursales()
    {
        List<String> array = new ArrayList();
        for (Sucursal s: sucursales) 
        {
            array.add(s.direccion);
        }
        return array;
    }
    public void AddEmpleado(Empleado e)
    {
        this.empleados.add(e);
    }
    public Camion EntregarCamion()
    {
        for(Camion c: camiones)
        {
            if (c.getdisponibilidad()==true)
            {return c;}
        }
        return null;
    }
    
    public Cliente BuscarPersona(String rut)
    {
        for(Cliente c: clientes)
        {
        if (c.getrut()==rut)
        {
        return c;
        }
        }
        return null;
    }
    
    public void CambiarEstadoEncomienda(int id, String estado)
    {
        for(Encomienda e: encomiendas)
        {
            if(e.id==id)
            {
                e.estado=estado;
            }
        }
    }
    
    public String VerEstadoEncomienda(int id)
    {
        for(Encomienda e: encomiendas)
        {
            if(e.id==id)
            {
                String estado=e.estado;
                return estado;
            }
        }
        return null;   
    }
    
    public int AsignarIDEnco()
    {
        int temp = IDEncomienda;
        IDEncomienda += 1;
        return temp;
    }
    
    public int AsignarIDPedido()
    {
        int temp = IDPedido;
        IDPedido += 1;
        return temp;
    }
   /* public int buscarmenoridencomienda()
    {
        int largo=encomiendas.size();
        int menorid=0;
        boolean esta=true;
        for(int i=0; i<largo;i++)
        {
        for(Encomienda e: encomiendas)
        {
           
        }
        }
    }*/

}
