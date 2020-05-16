package me.celso.agra.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.celso.agra.model.Information;
import me.celso.agra.service.InformationReadService;
import me.celso.agra.service.InformationCommandService;

@RestController
@RequestMapping(value = "/backend")
public class BackendRestController {

	@Autowired
	private InformationCommandService commandService;
	
	@Autowired
	private InformationReadService queryService;

	@PostMapping(value = "/message")
	public void commandCreate(@RequestParam("message") String message) {
		this.commandService.create(Information.newInstance(message));
	}

	@GetMapping(value = "/message")
	public List<Information> queryAll() {
		return this.queryService.findAll();
	}	
}
