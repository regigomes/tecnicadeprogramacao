import java.time.LocalDate;
import java.util.UUID;
import model.*;

public class Main {
    public static void main(String[] args) {
        Runnable processoVenda = () -> {
            Service.Notificador notificador = mensagem -> System.out.println("Notificação: " + mensagem);

            Cliente cliente = new Cliente(UUID.randomUUID().toString(), "João", "123456789");
            Produto produto = new Produto(UUID.randomUUID().toString(), "Notebook", 3000.0);
            Pedido pedido = new Pedido(UUID.randomUUID().toString(), cliente);
            CupomDesconto cupom = new CupomDesconto("PROMO10", 10.0, true, LocalDate.now().plusDays(5));
            pedido.aplicarCupom(cupom);
            ItemPedido item = new ItemPedido(produto, 1, 2900.0);
            pedido.adicionarItem(item);
            pedido.finalizarPedido(notificador);
            pedido.pagar(notificador);
            pedido.entregar(notificador);

            System.out.println("Pedido finalizado para " + pedido.getCliente().getNome() +
                    " com status " + pedido.getStatus() +
                    " e pagamento " + pedido.getPagamentoStatus());
        };
        Thread thread = new Thread(processoVenda);
        thread.start();
    }
}