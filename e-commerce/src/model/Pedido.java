package model;

import util.EmailService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private LocalDate dataCriacao;
    private String status;
    private List<ItemPedido> itens = new ArrayList<>();
    private String statusPagamento = "Pendente";

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.dataCriacao = LocalDate.now();
        this.status = "Aberto";
    }

    public void adicionarItem(ItemPedido item) {
        if (status.equals("Aberto")) {
            itens.add(item);
        }
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::getTotal).sum();
    }

    public void finalizarPedido() {
        if (!itens.isEmpty() && calcularTotal() > 0) {
            statusPagamento = "Aguardando pagamento";
            EmailService.notificar(cliente.getNome(), "Pedido aguardando pagamento.");
        }
    }

    public void pagar() {
        if (statusPagamento.equals("Aguardando pagamento")) {
            statusPagamento = "Pago";
            EmailService.notificar(cliente.getNome(), "Pagamento realizado.");
        }
    }

    public void entregar() {
        if (statusPagamento.equals("Pago")) {
            status = "Finalizado";
            EmailService.notificar(cliente.getNome(), "Pedido entregue.");
        }
    }
}
