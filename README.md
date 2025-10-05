# Sistema de E-commerce API

Uma API simples de e-commerce desenvolvida em Java, demonstrando conceitos de programação orientada a objetos, incluindo gestão de pedidos, produtos, clientes e sistema de cupons de desconto.

## 📋 Funcionalidades

- **Gestão de Clientes**: Cadastro e gerenciamento de informações de clientes
- **Catálogo de Produtos**: Sistema para criação e gerenciamento de produtos
- **Sistema de Pedidos**: Criação, modificação e finalização de pedidos
- **Cupons de Desconto**: Sistema de cupons com validação de data e aplicação automática
- **Notificações**: Sistema de notificações para acompanhar o status dos pedidos
- **Processamento Assíncrono**: Utilização de threads para processamento de vendas

## 🏗️ Estrutura do Projeto

```
ECommerceAPI/
├── src/
│   ├── Main.java                    # Classe principal com exemplo de uso
│   ├── model/                       # Modelos de dados
│   │   ├── Cliente.java            # Representação do cliente
│   │   ├── Produto.java            # Representação do produto
│   │   ├── Pedido.java             # Gestão de pedidos
│   │   ├── ItemPedido.java         # Itens do pedido
│   │   └── CupomDesconto.java      # Sistema de cupons
│   ├── Service/                    # Serviços
│   │   └── Notificador.java        # Interface para notificações
│   └── util/                       # Utilitários
│       └── EmailService.java       # Serviço de email
└── ECommerceAPI.iml               # Arquivo de configuração do IntelliJ
```

## 🚀 Como Executar

### Pré-requisitos

- Java 8 ou superior
- IDE Java (IntelliJ IDEA, Eclipse, etc.) ou compilador Java

### Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/regigomes/meu-primeiro-app.git
   cd meu-primeiro-app
   ```

2. **Compile o projeto:**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Execute a aplicação:**
   ```bash
   java -cp bin Main
   ```

### Exemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        // Criar notificador
        Notificador notificador = mensagem -> System.out.println("Notificação: " + mensagem);

        // Criar cliente e produto
        Cliente cliente = new Cliente(UUID.randomUUID().toString(), "João", "123456789");
        Produto produto = new Produto(UUID.randomUUID().toString(), "Notebook", 3000.0);

        // Criar pedido e aplicar cupom
        Pedido pedido = new Pedido(UUID.randomUUID().toString(), cliente);
        CupomDesconto cupom = new CupomDesconto("PROMO10", 10.0, true, LocalDate.now().plusDays(5));
        pedido.aplicarCupom(cupom);

        // Adicionar item e processar pedido
        ItemPedido item = new ItemPedido(produto, 1, 2900.0);
        pedido.adicionarItem(item);
        pedido.finalizarPedido(notificador);
        pedido.pagar(notificador);
        pedido.entregar(notificador);
    }
}
```

## 📦 Classes Principais

### Cliente
Representa um cliente do sistema com informações básicas como ID, nome e documento.

### Produto
Modela os produtos disponíveis para venda com ID, nome e preço.

### Pedido
Gerencia o ciclo de vida completo de um pedido:
- Adição/remoção de itens
- Aplicação de cupons de desconto
- Finalização e pagamento
- Controle de status

### CupomDesconto
Sistema de cupons com:
- Validação por data
- Desconto percentual ou valor fixo
- Controle de uso único

### Notificador
Interface funcional para sistema de notificações, permitindo diferentes implementações de notificação.

## 🎯 Funcionalidades Demonstradas

- **Programação Orientada a Objetos**: Encapsulamento, herança e polimorfismo
- **Interfaces Funcionais**: Uso de lambda expressions com `Notificador`
- **Streams API**: Processamento de listas com operações funcionais
- **Programação Concorrente**: Uso de threads para processamento assíncrono
- **Validação de Dados**: Validação de cupons e status de pedidos
- **Padrões de Design**: Observer pattern através do sistema de notificações

## 📝 Status do Pedido

O sistema gerencia os seguintes status:

### Status do Pedido:
- `Aberto`: Pedido em construção, permite modificações
- `Finalizado`: Pedido concluído e entregue

### Status do Pagamento:
- `Pendente`: Aguardando finalização do pedido
- `Aguardando pagamento`: Pedido finalizado, aguardando pagamento
- `Pago`: Pagamento confirmado

## 🛠️ Melhorias Futuras

- [ ] Persistência de dados (banco de dados)
- [ ] API REST com Spring Boot
- [ ] Sistema de autenticação e autorização
- [ ] Testes unitários e de integração
- [ ] Validação de entrada de dados
- [ ] Logging estruturado
- [ ] Documentação da API
- [ ] Sistema de estoque
- [ ] Histórico de pedidos
- [ ] Múltiplas formas de pagamento

## 👨‍💻 Autor

**Regi Gomes**
- GitHub: [@regigomes](https://github.com/regigomes)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

*Projeto desenvolvido como parte de estudos em programação Java e conceitos de e-commerce.*