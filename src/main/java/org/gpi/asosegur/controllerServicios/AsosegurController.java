package org.gpi.asosegur.controllerServicios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsosegurController {

	@GetMapping("/servicios")
	public String getServicios() {
		return "servicios/servicios";
	}
}
