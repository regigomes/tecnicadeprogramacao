package model;

import Service.Notificador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pedido {
    private String id;
    private Cliente cliente;
    private LocalDateTime dataCriacao;
    private String status = "Aberto";
    private String pagamentoStatus = "Pendente";
    private List<ItemPedido> itens = new ArrayList<>();
    private CupomDesconto cupom;

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataCriacao = LocalDateTime.now();
    }
    public void adicionarItem(ItemPedido item) {
        if (status.equals("Aberto")) itens.add(item);
    }
    public void removerItem(String produtoId) {
        if (status.equals("Aberto")) {
            itens.removeIf(item -> item.getProduto().getId().equals(produtoId));
        }
    }
    public void alterarQuantidade(String produtoId, int novaQuantidade) {
        if (status.equals("Aberto")) {
            Optional<ItemPedido> itemOpt = itens.stream()
                    .filter(item -> item.getProduto().getId().equals(produtoId))
                    .findFirst();
            itemOpt.ifPresent(item -> item.setQuantidade(novaQuantidade));
        }
    }
    public void finalizarPedido(Notificador notificador) {
        double total = itens.stream()
                .mapToDouble(item -> item.getQuantidade() * item.getPrecoVenda())
                .sum();

        if (cupom != null && cupom.isValido()) {
            total = cupom.aplicarDesconto(total);
        }

        if (!itens.isEmpty() && total > 0) {
            pagamentoStatus = "Aguardando pagamento";
            notificador.notificar("Pedido finalizado com cupom. Total com desconto: R$" + total);
        }
    }
    public void aplicarCupom(CupomDesconto cupom) {
        if (cupom.isValido()) {
            this.cupom = cupom;
        }
    }
    public void pagar(Notificador notificador) {
        if (pagamentoStatus.equals("Aguardando pagamento")) {
            pagamentoStatus = "Pago";
            notificador.notificar("Pagamento realizado com sucesso.");
        }
    }
    public void entregar(Notificador notificador) {
        if (pagamentoStatus.equals("Pago")) {
            status = "Finalizado";
            notificador.notificar("Pedido entregue com sucesso.");
        }
    }
    public String getStatus() { return status; }
    public String getPagamentoStatus() { return pagamentoStatus; }
    public Cliente getCliente() { return cliente; }
}
