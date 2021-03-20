package br.com.rafael.mvc.mudi.controller;

import br.com.rafael.mvc.mudi.model.Pedido;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rafael.mvc.mudi.dto.RequisicaoNovoPedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		
		return "pedidos/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
			if(result.hasErrors()) {
				return "pedidos/formulario";
			}
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		return "pedidos/testando";
	}
}
