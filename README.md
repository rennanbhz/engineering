# Engineering
Engineering test

AVALIAÇÃO TÉCNICA – Desenvolvedor Junior/Pleno 

INFORMAÇÕES
Temos uma entidade Cliente (id, nome, CPF, Sexo) com relacionamento muitos para um e entidade Vendedor (id, nome, CPF).
Construir um serviço RESTful com Python (preferência em Flask mas pode usar outro framework caso desejar) para realizar o CRUD das 2 entidades citas.

Back-end:
A API deve conter os seguintes endpoints:
1. Criar e alterar Vendedor (exclusão pode ser cascade);
2. Criar e alterar Cliente (exclusão pode ser cascade);
3. Buscar Vendedor por id;
4. Buscar Cliente por id;
5. Listar todos Vendedores;
6. Listar todos Clientes;
7. Listar todos os Clientes (id, nome, CPF, Sexo) com seu respectivo Vendedor (apenas nome);
8. Buscar lista de Cliente utilizando filtro id do Vendedor;

Especificações técnicas:
1. Escrever testes unitários;
2. Validação nas 2 entidades:
a. CPF,
b. Nome: deverá ser único ter e tamanho mínimo de 10 caracteres e máximo de 50;
3. API REST deve ser stateless e utilizar banco in-memory para persistir os dados;
4. Código deve ser disponibilizado no github e o link seja enviado para avaliação;
5. Prover README.txt (plain text) ou README.md (Markdown) exemplificando como compilar, executar a aplicação (cada endpoint junto com o body do request caso existir) e os testes unitários;
6. Ter apenas o Python instalado na máquina como pré-requisito para executar o projeto. O restante das necessidades serem providas pela própria aplicação e comando para execução no arquivo README.txt ou README.md.
7. Dependencias do projeto serão instaladas via pip install -r requirements.txt.

Front-end:
2
1. Criar projeto front-end para consumir todos os end-point criados
2. Utilizar framework Angular ou React.
3. Desejável testes automatizados para o front-end.

Avaliações:
1. Se atende todos os requisitos técnicos;
2. Qualidade do código;
3. Não repetição de código;
4. Quanto menos código para resolver o problema, melhor;
5. Testes unitários para os “corners case”.
Orientações  Prazo 7 dias após recebimento do e-mail;  Use sua criatividade!!!
