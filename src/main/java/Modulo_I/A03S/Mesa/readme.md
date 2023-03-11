> Durante esta aula, sugerimos que faça os exercícios das aulas anteriores que não completou para recuperar
o atraso ou, caso os tenha feito, deixamos-lhe os seguintes desafios para continuar a colocar em prática o
que aprendeu.

# Exercício Integrador: Template Method pattern

## Objetivo

Analisar o seguinte enunciado em conjunto com o código e, em seguida, **modifique-o de
acordo com o enunciado**.

### Desafio I

Uma empresa de vendas digitais nos pede para modificar a modelagem de seu sistema.

Atualmente, o sistema permite que os vendedores sejam classificados de acordo com o
cumprimento de determinados requisitos.

Os seguintes aspectos são considerados:

- Tanto **funcionários** quanto **afiliados** são vendedores;
- Cada **vendedor** retorna uma categoria (**mostrarCategoria**) de acordo com o
número de pontos obtidos.
- O objetivo dos **funcionários** é conseguir afiliados (**obterAfiliado**) e realizar vendas
(**vender**). Cada um recebe 10 pontos por cada novo afiliado, 5 pontos por cada
venda que fizer e 5 pontos por cada ano de antiguidade que tiver.
- O objetivo dos **afiliados** é realizar vendas (**vender**), mas o cálculo dos pontos é
diferente: eles ganham 15 pontos a cada nova venda.

Os vendedores são categorizados da seguinte forma:

- Menos de 20 pontos = novato;
- Entre 20 e 30 pontos = aprendiz;
- Entre 31 e 40 pontos = bom;
- Mais de 40 pontos = mestre.
Deve ser implementado um método **mostrarCategoria** que deve primeiro **calcularPontos**, 
depois **recategorizar** de acordo com a pontuação obtida no método anterior e, finalmente, 
exibir o nome do vendedor, total de pontos e categoria por console.

> Se você chegou até aqui, parabéns! Se você ainda tem tempo, propomos o seguinte
desafio para continuar praticando.

### Desafio II

Somos solicitados a criar um terceiro tipo de **vendedor** chamado **estagiário**. O
objetivo dos **estagiários** é fazer vendas, onde para cada uma, eles receberão 5
pontos. Os **estagiários** são categorizados da seguinte forma:

- Menos de 50 pontos = estagiário novato.
- 50 pontos ou mais = estagiário experiente.

Exemplos de saída para os dois desafios:

```
Estagiária Mônica tem um total de 22 pontos e categoriza como vendedor aprendiz.
Estagiário Pedro tem um total de 9 pontos e categoriza como estagiário novato.
```

**Bons estudos!**
