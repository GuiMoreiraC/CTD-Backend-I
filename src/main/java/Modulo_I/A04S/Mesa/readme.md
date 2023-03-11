# Exercício Mesas de Trabalho: Chain of Responsibility

## Objetivo

Realizar o diagrama **UML** e programar em **Java**, implementando o padrão **Chain of
Responsibility**, de acordo com o seguinte enunciado:

Considerar:

- Exercício individual
- Nível de complexidade intermediário: 🔥🔥

## Enunciado

Em uma empresa, você deseja controlar a qualidade de um produto. Desta forma, são
considerados três controles diferentes e em cada um é verificado se o produto está de
acordo com os padrões de qualidade. De acordo com os controles:

- **Lote:** deve estar entre 1000 e 2000. 
- **Peso:** deve estar entre 1200 e 1300. 
- **Embalagem:** deve ser igual a “saudável” ou “quase saudável”.

Se não atender a nenhum dos critérios, deve ser informado que foi **rejeitado** ou, se
atender a todos os requisitos, deve ser relatado que foi **aceito**.

O artigo pertence a uma classe de **artigo** que possui quatro informações:

- Nome: String. 
- Lote: int. 
- Peso: int. 
- Embalagem: String (“saudável”, “quase saudável”, etc.).

Deseja-se que uma classe **CheckQuality** envie o artigo para cada um dos controles.
Primeiro, é o lote: se estiver correto, irá para o controle de peso. Se não estiver correto, ele
informa que o lote está errado. A sequência de cada controle continua até que, ao passar
em todos os controles, ele deve informar que está correto.

Finalmente, deve ser feita uma classe que crie um artigo e, em seguida, peça a
**CheckQuality** para verificá-lo.

**Bons estudos!**