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

- **Frontend:** Java Swing (interface gráfica desktop)
- **Backend:** Java (Programação Orientada a Objetos com padrão MVC)
- **Banco de Dados:** PostgreSQL (com script SQL e integração via JDBC)
- **Ferramentas:** NetBeans 25, GitHub, pgAdmin, Astah (diagramas), Terminal Linux (psql)

---

## 🧰 Instalação

### 1. Clonar o repositório
```bash
git clone https://github.com/joaomaggi03/ServeUp
```

### 2. Abrir no NetBeans
```bash
1. Abra o NetBeans IDE 25
2. Vá em File > Open Project
3. Selecione a pasta ServeUp clonada
```

### 3. Configurar o banco de dados (PostgreSQL)
```bash
1. Certifique-se de que o PostgreSQL está instalado e em execução
2. Crie um banco de dados chamado ServeUp
3. Execute o script SQL para criação das tabelas:

---

DROP TABLE IF EXISTS ItemComanda;
DROP TABLE IF EXISTS Comanda;
DROP TABLE IF EXISTS Produto;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Administrador;

CREATE TABLE Administrador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE Cliente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
    codigo_produto INTEGER UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco NUMERIC(10, 2) NOT NULL CHECK (preco >= 0)
);

CREATE TABLE Comanda (
    id SERIAL PRIMARY KEY,
    id_cliente VARCHAR(11) REFERENCES Cliente(cpf),
    data_abertura TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_fechamento TIMESTAMP,
    valor_total NUMERIC(10, 2) DEFAULT 0.00,
    status VARCHAR(20) DEFAULT 'ABERTA'
);

CREATE TABLE ItemComanda (
    id SERIAL PRIMARY KEY,
    id_comanda INTEGER NOT NULL REFERENCES Comanda(id),
    id_produto INTEGER NOT NULL REFERENCES Produto(id),
    quantidade INTEGER NOT NULL CHECK (quantidade > 0),
    preco_unitario NUMERIC(10, 2) NOT NULL,
    subtotal NUMERIC(10, 2) NOT NULL
);
```
---

### 4. Inserir administrador padrão (opcional)
```bash
INSERT INTO Administrador (nome, usuario, senha) VALUES ('Admin Padrão', 'admin', 'admin');

```

### 5. Rodar o servidor
```bash
INSERT INTO Administrador (nome, usuario, senha) VALUES ('Admin Padrão', 'admin', 'admin');

```

---

## ▶️ Executar o Projeto
1. Abra o NetBeans
2. Compile o projeto com Shift + F11
3. Execute o formulário principal com F6
4. A tela principal será exibida com opções de Cliente e Administrado
5. Utilize as funcionalidades do sistema: cadastro, pedidos, pagamento, gerenciamento de comandas

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

## 📄 Licença

Projeto acadêmico sem fins lucrativos. Todos os direitos reservados aos autores.


 
