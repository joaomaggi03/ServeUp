# ServeUp 📝

**Sistema para gestão de pedidos e controle de comandas. 
Projeto desenvolvido para a disciplina Programação Orientada a Objetos 2**.

---

## 📚 Funcionalidades do sistema

O sistema ServeUp foi desenvolvido para gerenciar comandas de pedidos em estabelecimentos como bares, restaurantes e lanchonetes. Abaixo estão listadas as principais funcionalidades:

### 📦 Cadastro e Gerenciamento de Produtos
- Permite o cadastro de produtos (alimentos e bebidas) disponíveis para pedido.

### 🧾 Gerenciamento de Comandas
- Criação de uma comanda por mesa.
- Adição de itens à comanda. 
- Edição ou remoção de itens (alteração de quantidade, exclusão). 
- Visualização em tempo real de todos os itens pedidos. 
- Controle e registro do pagamento da comanda. 

### 👀 Visualização para Atendentes
- O atendente pode visualizar todas as comandas abertas no sistema. 

### 👤 Cadastro de Clientes 
- Cadastro de clientes para associar uma comanda específica, quando necessário. 

### 💡 Interface Amigável
- Interface pensada para facilitar a interação do atendente ou cliente com o sistema.

---

## 📁 Estrutura de Pastas
```bash

serveup/
├── src/
│   └── main/
│       └── java/
│           ├── Controller/
│           │   ├── ControladorAdministrador.java
│           │   ├── ControladorCliente.java
│           │   ├── ControladorComanda.java
│           │   ├── ControladorItemComanda.java
│           │   ├── ControladorProduto.java
│           │   └── FabricaDeConexoes.java
│           ├── com/
│           │   └── mycompany/
│           │       └── serveup/
│           │           └── ServeUp.java
│           ├── model/
│           │   ├── Administrador.java
│           │   ├── Cliente.java
│           │   ├── Comanda.java
│           │   ├── ItemComanda.java
│           │   └── Produto.java
│           └── view/
├── .gitattributes
├── .gitignore
├── README.md
└── pom.xml

```

---

## 🧪 Tecnologias Utilizadas

- **Frontend:** PREENCHER
- **Backend:** PREENCHER
- **Banco de Dados:** PREENCHER
- **Ferramentas:** PREENCHER

---

## 🧰 Instalação

### 1. Clonar o repositório
```bash
git clone https://github.com/joaomaggi03/ServeUp
cd ServeUp/backend
```

### 2. Instalar dependências do backend
```bash
npm install
```

### 3. Criar o arquivo `.env`
```bash
echo "MONGO_URI=<sua-URI-do-MongoDB>" > .env
```

> Exemplo de URI:
> ```
> MONGO_URI=mongodb+srv://admin:senha@cluster0.mongodb.net/portal?retryWrites=true&w=majority
> ```

### 4. Criar usuário admin (opcional)
```bash
node createAdmin.js
```

### 5. Rodar o servidor
```bash
node server.js
```

Servidor rodando em: `http://localhost:3000`

---

## ▶️ Executar o Projeto
1. PREENCHER
2. PREENCHER
3. PREENCHER

**Credenciais padrão:**
```
Usuário: PREENCHER
Senha: PREENCHER
```

---

## Requisitos Funcionais

| Identificador | Descrição                                                                                                                                           | Prioridade |
|---------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|------------|
| RF01          | O sistema deve permitir o cadastro de produtos disponíveis para o pedido, como alimentos e bebidas.                                                 | Alta       |
| RF02          | O sistema deve permitir adicionar itens ao pedido da comanda.                                                                                       | Alta       |
| RF03          | O sistema deve permitir que o cliente ou atendente altere a quantidade ou remova itens da comanda.                                                  | Alta       |
| RF04          | O sistema deve permitir a visualização da comanda em tempo real, com todos os itens pedidos.                                                        | Alta       |
| RF05          | O sistema deve registrar e controlar o pagamento da comanda.                                                                                        | Média      |
| RF06           | O sistema deve permitir que o atendente visualize todas as comandas abertas.                                                                       | Média      |
| RF07           | O sistema pode permitir o cadastro de clientes, caso seja necessário associar uma comanda a um cliente específico.                                 | Baixa      |
| RF08           | O sistema deve ter uma interface amigável para o atendente ou cliente visualizar e interagir com a comanda.                                        | Alta       |

## Requisitos Não Funcionais

| Identificador | Descrição                                                                                                                                     | Tipo  |
|---------------|-----------------------------------------------------------------------------------------------------------------------------------------------|--------|
| RNF01         | A interface deve ser intuitiva e amigável, facilitando o uso por pessoas sem treinamento prévio.                                              | Alta   |
| RNF02         | O sistema deve ter um tempo de resposta inferior a 1 segundo para ações como adicionar itens.                                                 | Média  |
| RNF03         | Os dados da comanda devem ser salvos localmente mesmo após atualização da página.                                                             | Alta   |
| RNF04         | O sistema deve suportar pelo menos 20 comandas abertas simultaneamente.                                                                       | Média  |
| RNF05         | As mensagens de erro devem ser claras e informativas, ajudando o usuário a corrigir problemas.                                                | Alta   |
| RNF06         | O sistema deve estar disponível 100% do tempo durante o horário de funcionamento do estabelecimento.                                          | Alta   |
| RNF07         | O código deve ser modular e bem documentado para facilitar a manutenção e futuras melhorias.                                                  | Média  |

--- 

## 🔒 Rotas Backend (API REST)

| Método | Rota                    | Função                       |
|--------|-------------------------|------------------------------|
| POST   | `PREENCHER`         | PREENCHER             |
| GET    | `PREENCHER`         | PREENCHER               |
| POST   | `PREENCHER`     | PREENCHER         |
| GET    | `PREENCHER`     | PREENCHER           |
| POST   | `PREENCHER`       | PREENCHER           |
| GET    | `PREENCHER`       | PREENCHER             |
| POST   | `PREENCHER`           | PREENCHER       |

---

## 📄 Licença

Projeto acadêmico sem fins lucrativos. Todos os direitos reservados aos autores.


 
