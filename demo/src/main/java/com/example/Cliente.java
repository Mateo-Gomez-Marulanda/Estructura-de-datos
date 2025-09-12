package com.example;

/* 
public Cliente[] encontrarClienteVenta(){
 Cliente[] listaClientesVenta;
   
 int cantClientes = 0; //index

    for(int i = 0; i < listVentas.length(); i++){ //recorre el arreglo 
        DetalleVenta listDetalles = listVentas[i].obtenerListaDetallesVenta; //crear listaDetalles y se le asigna a un elemento de la listVentas en bse a su posicion

            for(int j = 0; j < listDetalles.length(); j ++){ //reocorre la listDetalles 
                if(listDetalles[j].getCantidad() == 4 
                    && listDetalles[j].getProducto().getNombre().equals("Atun")){
                    cantClientes++; 
                }
            }
        }

    listaClientesVenta = new Cliente[cantClientes];
    
    int index = 0;
    for(int i = 0; i < listVentas().length(); i++){
        DetalleVenta listDetalles = listVentas[i].obtenerListaDetallesVenta();
            for(int j = 0; j < listDetalles.length(); j ++){
                if(listDetalles[j].getCantidad() == 4
                     && listDetalles[j].getProducto().getNombre().equals("Atun")){
                        listaClientesVenta[index] = listVentas[i].getCliente();
                    index++;
     }
   }
  }

  /*
  for(T elemento : elementos){
    if(listDetalles[j].getCantidad == 4
                     && listDetalles[j].getProducto.getNombre.equals("Atun")){
                         listaClientesVenta[index] = listVentas[i].getCliente;
                    index++;
                     }
  }
}
*/
