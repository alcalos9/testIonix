package cl.ionix.test.test.services;

import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import cl.ionix.test.test.model.RegisterResponse;
import cl.ionix.test.test.model.ResultRegister;
import cl.ionix.test.test.model.RootResponse;

@Service
public class CifradoService {
	
	public String cifrarRut(String rut) {
		String encryptedRut = "";
		try {
			String llave =  obtenerPropiedad("cifrado.llave");
			
			byte[] cleartext = rut.getBytes("UTF8");
			SecureRandom sr = new SecureRandom();
	        DESKeySpec deskey = new DESKeySpec(llave.getBytes("UTF8"));
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	        SecretKey key = keyFactory.generateSecret(deskey);
	        Cipher cipher = Cipher.getInstance("DES");
	        cipher.init(Cipher.ENCRYPT_MODE, key, sr);
	        encryptedRut = Base64.getEncoder().encodeToString(cipher.doFinal(cleartext));
		}catch(Exception e) {
			return null;
		}

		return encryptedRut;
	}
	
	public RegisterResponse obtenerRegistros(String cifrado){
		RestTemplate plantilla = new RestTemplate();
		RootResponse response = new RootResponse();
		RegisterResponse registerResponse = new RegisterResponse();
		ResultRegister registros = new ResultRegister();
		StopWatch watch = new StopWatch();
		try {
			String url = obtenerPropiedad("cifrado.url");
			url = url + cifrado;
			try {
				watch.start();
				response = plantilla.getForObject(url, RootResponse.class);
			} finally {
				watch.stop();
				long executionTime = watch.getLastTaskTimeMillis();
				if(response != null) {
					registros.setRegisterCount(response.getResult().getItems().size());
					registerResponse.setDescription(response.getDescription());
					registerResponse.setResponseCode(response.getResponseCode());
					registerResponse.setElapsedTime(executionTime);
					registerResponse.setResult(registros);
				}
			}
		}catch(Exception e) {
			return null;
		}
		return registerResponse;
	}
	
	public String obtenerPropiedad(String propiedad) {
		Properties prop = new Properties();
		String dumyOperador = "application.properties";
		String valor = "";
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(dumyOperador);
			prop.load(inputStream);
			valor =  prop.getProperty(propiedad);
			
		}catch(Exception e) {
			return null;
		}
		return valor;
	}
}
