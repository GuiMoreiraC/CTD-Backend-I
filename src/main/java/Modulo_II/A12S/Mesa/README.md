# Exercício para mesas de trabalho

Nesta aula, vamos revisar o que vimos anteriormente por meio do exercício a
seguir, considerando:

- Exercício individual
- Nível de complexidade: Intermediário 🔥🔥

## Enunciado
Utilizaremos um statement para criar uma tabela de funcionários com cinco
colunas. A única coluna obrigatória será a coluna ID, que também é Primary Key,
e as demais colunas são de livre escolha. Em seguida:

- Devemos inserir três linhas com dados diferentes, e uma delas deve
conter o ID repetido; 
- Verificar se está ocorrendo o erro: “Unique index or primary key violation”,
ocasionado ao tentar inserir dois registros com o mesmo ID. Então
devemos tratá-lo como exceção, registar o erro em log e continuar com a
execução das demais instruções; 
- Em seguida, você deve atualizar um dos funcionários com um novo valor
em uma de suas colunas e registrar com um objeto de depuração (debug)
as informações do funcionário; 
- Posteriormente, temos que excluir um funcionário de acordo com o ID e
registrar as informações do funcionário excluído como um objeto de
informação (info); 
- Por último, excluir outro funcionário utilizando como critério outra coluna
que não seja o ID, como por exemplo o e-mail, e registrar as informações
do funcionário excluído como um objeto de informação (info).