package cl.ionix.test.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.ionix.test.test.model.RegisterResponse;
import cl.ionix.test.test.services.CifradoService;

@RestController
public class CifradoController {
	
	@Autowired
	private CifradoService  services;
	
	@PostMapping("cifrado")
	public RegisterResponse cifrado(@RequestParam("rut") String rut) {
		RegisterResponse response = new RegisterResponse();
		String rutCifrado = services.cifrarRut(rut);
		
		try {
			if(rutCifrado != null) {
				response = services.obtenerRegistros(rutCifrado);
			}
			return response;
		}catch(Exception e){
			return null;
		}
		
	}
}
