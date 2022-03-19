package com.projetoagencia.springboot.ClienteController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoagencia.springboot.ClienteModel.Cliente;
import com.projetoagencia.springboot.ClienteServices.ClienteServices;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServices clienteService;

	@GetMapping
	public List<Cliente> getAllCliente() {
		return clienteService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Cliente> getClientebyId(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping
	public void saveClient(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCliente(@PathVariable Long id) {
		clienteService.deleteById(id);
	}

	@PutMapping("/{id}")
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteAtual = clienteService.findById(id).get();
		BeanUtils.copyProperties(cliente, clienteAtual, "id");
		return clienteService.update(clienteAtual);
	}
}
