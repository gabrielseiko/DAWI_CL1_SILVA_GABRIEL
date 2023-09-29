package org.cibertec.edu.pe.services;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductoService;
import org.cibertec.edu.pe.interfaces.IProducto;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
	
	@Autowired
	private IProducto data;
	
	@Override
	public List<Producto> Listado() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> Buscar(int id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Producto ObjC) {
		int rpta = 0;
		Producto c = data.save(ObjC);
		if(!c.equals(null))rpta = 1;
		return rpta;
	}

	

}
