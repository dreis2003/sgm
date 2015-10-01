package br.com.sgm.web.controllers;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	private static Logger logger = Logger.getLogger(OlaMundoController.class);
	
	@RequestMapping("/olaMundoSpring")
	  public String execute() {
			logger.info("LOG: Executando a lógica com Spring MVC");
	      System.out.println("Executando a lógica com Spring MVC");
	      return "ok";
	  }

}
