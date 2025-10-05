# 📚 Projeto Sistema de E-commerce
Desenvolvido em Java, este é um sistema de e-commerce simplificado que implementa a gestão de produtos, clientes, pedidos e cupons. O projeto dá continuidade aos estudos em backend do curso da Adatech, sendo uma evolução do projeto "Adacommerce".

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

## ⚙️Como Executar
- Clone o repositório: git clone https://github.com/regigomes/tecnicadeprogramacao.git
- Abra o projeto em uma IDE de sua preferencia (como IntelliJ ou Eclipse)
- Execute a classe Main para simular o processo de venda.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Programação orientada a objetos**
- **Threads**
- **Interface funcional**
- **Simulação de serviços**

---

## 📚 Aprendizados

Este projeto é ideal para praticar e consolidar:

- **Encapsulamento e abstração**
- **Manipulação de listas e streams**
- **Uso de Optional**
- **Design de classes e responsabilidades**
- **Simulação de notificações assíncronas**

---

### 👨‍💻 Autora

**Regiane Gomes**
- GitHub: [@regigomes](https://github.com/regigomes)

*Projeto desenvolvido como parte de estudos em programação orientada a objeto Java *
