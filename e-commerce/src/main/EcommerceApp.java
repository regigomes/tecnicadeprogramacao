package main;

import model.*;
import util.EmailService;

import java.util.Optional;

@FunctionalInterface
interface Validador<T> {
    boolean validar(T t);
}

public class ECommerceApp {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123456789");
        Produto produto = new Produto("Notebook", 3000.0);

        Validador<Cliente> validadorDocumento = c -> c.getDocumento() != null && !c.getDocumento().isEmpty();
        if (!validadorDocumento.validar(cliente)) {
            System.out.println("Documento inválido.");
            return;
        }

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(produto, 1, 2800.0));
        pedido.finalizarPedido();
        pedido.pagar();
        pedido.entregar();

        Optional<Double> total = Optional.of(pedido.calcularTotal());
        total.ifPresent(t -> System.out.println("Total do pedido: " + t));
    }
}