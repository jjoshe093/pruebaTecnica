package com.pruebatecnica.controller;

import com.pruebatecnica.entidades.Producto;
import com.pruebatecnica.service.ProductoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author jejacobo
 */
@Named
@ViewScoped
public class ProductoController implements Serializable {
    
    @Inject
    private ProductoService productoService;
    
    private List<Producto> productos;
    private Producto productoSeleccionado;
    
    @PostConstruct
    public void init(){
        this.productos = productoService.findAllProductos();
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
    public void guardarProducto(){
        if (this.productoSeleccionado.getIdProducto() == null) {
            if (this.productoSeleccionado.getNombre().isEmpty() || 
                    this.productoSeleccionado.getDescripcion().isEmpty() || 
                    this.productoSeleccionado.getPrecio().toString().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Por favor, llene los campos requeridos"));
            } else {
                try {
                    productoService.saveProducto(this.productoSeleccionado);
                    this.productos.add(this.productoSeleccionado);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro insertado correctamente"));
                    PrimeFaces.current().executeScript("PF('productoDetalleDialog').hide()");
                    PrimeFaces.current().ajax().update("productoForm:productoTable");
                } catch (Exception e) {
                    System.out.println("error al guardar producto "+e);
                }
            }
            
        } else {
            try {
                productoService.updateProducto(this.productoSeleccionado);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos actualizados correctamente"));
                PrimeFaces.current().executeScript("PF('productoDetalleDialog').hide()");
                PrimeFaces.current().ajax().update("productoForm:productoTable");
            } catch (Exception e) {
                System.out.println("error al actualizar producto "+e);
            }
        }
    }
    
    public void eliminarProducto(){
        if (this.productoSeleccionado.getIdProducto() != null) {
            try {
                this.productos.remove(this.productoSeleccionado);
                productoService.deleteProducto(this.productoSeleccionado);
                this.productoSeleccionado = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado correctamente"));
                PrimeFaces.current().ajax().update("productoForm:productoTable");
            } catch (Exception e) {
                System.out.println("error al eliminar producto "+e);
            }
        }
    }
    
    public void abrirNuevo(){
        this.productoSeleccionado = new Producto();
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    
}
