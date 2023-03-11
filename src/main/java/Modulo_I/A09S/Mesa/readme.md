# Exercício para as mesas de trabalho

> Durante esta aula, sugerimos que você faça os exercícios das semanas 
> anteriores que não completou para recuperar o atraso ou, caso os tenha completado, 
> deixamos os seguintes desafios para continuar colocando em prática o que aprendeu.

## Vamos testar nossos conhecimentos

Considere que:

- Exercício em grupo;
- Nível de complexidade intermediário: 🔥🔥

## Enunciado
Suponha que temos uma produção de roupas e temos que exibir diferentes listas de roupas:

- Lista Tamanho XS;
- Lista Tamanho S;
- Lista Tamanho M;
- Lista Roupas Importadas;
- Lista Roupas usadas.

**Em grupo**, utilizando o padrão flyweight, devemos fazer um projeto para gerar o cliente **roupa**, 
com os seguintes atributos:

- Tamanho: é uma string.
- Tipo: é uma string que descreve o tipo de vestuário. Exemplo: calça.
- eNovo: flag (bandeira) para saber se é uma vestimenta nova ou não.
- importada: flag (bandeira) para saber se é uma vestimenta nacional ou internacional

Quando inserida uma nova roupa, cada lista deve ser preenchida de acordo com as informações passadas. 
Por exemplo, uma roupa de tamanho M, que é do tipo calça, é nova e importada deve ser salva nas 
listas de Tamanho M e de Roupas Importadas apenas.

Em seguida, devemos gerar dois testes: um para verificar se a fábrica retorna o item que 
precisamos e outro, que mede o tamanho da fábrica e mostra que é menor do que o número de pedidos. 
Por exemplo, se encomendarmos cinco calças iguais e duas camisas iguais, o tamanho da 
fábrica deve ser dois.