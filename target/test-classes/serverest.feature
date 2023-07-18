#language: pt
#Author: gigi_benedetti@hotmail.com.br
Funcionalidade: Testes da API ServeRest

  @CT001
  Cenario: Validar cadastro de carrinho na rota /carrinhos
    Dado que eu faca uma requisicao POST na rota /carrinhos com requestBody valido
    Entao valido status code 201

  @CT002
  Cenario: Validar cadastro de carrinho na rota /carrinhos sem o requestBody
    Dado que eu faca uma requisicao POST na rota /carrinhos e envio SEM o requestBody
    Entao valido status code 400
    E mensagem "Nao e permitido possuir produto duplicado | Nao e permitido ter mais de 1 carrinho | Produto nao encontrado | Produto nao possui quantidade suficiente"

  @CT003
  Cenario: Validar cadastro de carrinho na rota /carrinhos sem o campo idProduto
    Dado que eu faca uma requisicao POST na rota /carrinhos e envio SEM o campo idProduto
    Entao valido status code 400
    E mensagem "Nao e permitido possuir produto duplicado | Nao e permitido ter mais de 1 carrinho | Produto nao encontrado | Produto nao possui quantidade suficiente"

  @CT004
  Cenario: Validar cadastro de carrinho na rota /carrinhos sem o campo idProduto
    Dado que eu faca uma requisicao POST na rota /carrinhos e envio com campo idProduto com valor int
    Entao valido status code 400
    E mensagem "Nao e permitido possuir produto duplicado | Nao e permitido ter mais de 1 carrinho | Produto nao encontrado | Produto nao possui quantidade suficiente"
    