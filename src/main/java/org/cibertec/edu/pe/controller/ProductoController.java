package org.cibertec.edu.pe.controller;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductoService;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoService servicio;
	
	//Listar
	@GetMapping("/listar")		// http://localhost:8080/listar
	public String Listar(Model m) {
		List<Producto> lista = servicio.Listado();
		m.addAttribute("Productos", lista);
		return "listar";		// listar.html
	}
	
	//Buscar
	@GetMapping("/bus/{id}")	// http://localhost:8080/bus/1
	public String ver(@PathVariable int id, Model m) {
		Optional<Producto> c = servicio.Buscar(id);
		m.addAttribute("Producto", c);
		return "busca";			// busca.html
	}
	
	//Agregar
	@GetMapping("/agregar")
	public String agregar(Model m) {
		m.addAttribute("Producto", new Producto());
		return "form";			// form.html
	}
	

	//metodo para guardar
	@PostMapping("/guardar")
	public String guardar(@Validated Producto c, Model m, RedirectAttributes redirectAttributes) {
	    servicio.Grabar(c);
	    redirectAttributes.addAttribute("success", "true");
	    return "redirect:/listar";
	}


	

}
