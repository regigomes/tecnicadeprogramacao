# Sistema de E-commerce com base no projeto anterior AdaCommerce com algumas adaptações.

📚 Este projeto é um sistema simples de e-commerce feito em **Java**, criado para mostrar como organizar pedidos, produtos, clientes e cupons de desconto de forma prática e estruturada.


## Estrutura do Projeto

O projeto está organizado em pacotes:

- `model`: contém as classes principais como `Cliente`, `Produto`, `Pedido`, `ItemPedido` e `CupomDesconto`.
- `Service`: define a interface funcional `Notificador` para envio de notificações.
- `util`: contém o serviço de envio de e-mails simulado (`EmailService`).
- `Main`: classe principal que executa o fluxo de venda em uma thread separada.

---

##  Funcionalidades

- Cadastro de cliente e produto.
- Criação de pedido com múltiplos itens.
- Aplicação de cupom de desconto (percentual ou fixo).
- Validação de cupom por data e uso.
- Finalização de pedido com cálculo de total.
- Simulação de pagamento e entrega.
- Notificações via console e e-mail (simulado).

---

##  Regras de Negócio

- Todo cliente cadastrado precisa ter o documento de identificação.
- Um pedido sempre deve ter a data em que foi criado.
- Um pedido sempre deve iniciar com o status igual a **"Aberto"**.
- Pedidos com status igual a **"Aberto"** podem:
  - Receber itens (produtos).
  - Alterar a quantidade de itens.
  - Remover itens.
- Os produtos adicionados ao pedido devem ter um **valor de venda informado**, pois esse valor pode ser diferente do valor padrão do produto.
- Para que o cliente possa **finalizar o pedido**, ele deve conter ao menos **um item** e o **valor total deve ser maior que zero**.
  - O status do pagamento deve ser alterado para **"Aguardando pagamento"**.
  - O cliente deve ser **notificado via e-mail**.
- A ação de **pagar** só pode ocorrer se o status do pagamento for **"Aguardando pagamento"**.
  - Após o pagamento, o status deve ser alterado para **"Pago"**.
  - O cliente deve ser **notificado**.
- Após o pagamento, o pedido pode ser **entregue ao cliente**.
  - O status do pedido deve ser alterado para **"Finalizado"**.
  - O cliente deve ser **notificado sobre a entrega**.

---

### Tecnologias Utilizadas
Java 17+, Programação orientada a objetos, Threads, Interface funcional e Simulação de serviços.

### Execução
 Clone o repositório: git clone: https://github.com/regigomes/tecnicadeprogramacao.git, importe o projeto para a IDE de sua preferência (IntelliJ, VScode, Eclipse, etc.) ou compilador Java, e execute a classe Main para simular o processo de venda.
 
### Aprendizados
Este projeto é ideal para praticar conceitos como:
- Encapsulamento e abstração
- Manipulação de listas e streams
- Uso de Optional
- Design de classes e responsabilidades
- Simulação de notificações assíncronas

### 👨‍💻 Autora

**Regiane Gomes**
- GitHub: [@regigomes](https://github.com/regigomes)


*Projeto desenvolvido como parte de estudos em programação orientada a objeto Java *
