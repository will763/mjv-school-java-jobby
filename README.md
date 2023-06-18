# mjv-school-java-jobby
Esse foi o case da segunda semana da mjv school de java, O escopo inicial do projeto contempla a elaboração de um programa simples onde é possível que o candidato preencha via console seus dados pessoais, endereço, contato e experiência profissional mencionando uma faixa salarial pretendida. Este registro deverá ser coletado pelo sistema e gerar dois arquivos com os layouts delimitado e posicional respectivamente considerando as informações abaixo.

- Dados Pessoais: Nome, CPF, Data Nascimento, Sexo
- Dados Endereço: Logradouro, Número, Complemento, Bairro, Cidade, Estado
- Dados model.Contato: E-mail, Telefone, Celular, Se celular for WhatsApp
- Dados Profissionais: Profissão, Empresa, Salário, Emprego Atual
- Habilidades: Uma lista de habilidades
- Pretenção Salarial: Valor Mínimo, Valor Máximo

Conforme requisitos de nosso software, será necessário a geração de dois arquivos de acordo com as especificações abaixo:

1-Nome: cadastro.csv - Destino: c:\jobby\files - Layout: delimitado por ;
A ordem dos campos deve estar conforme imagem acima considerando os ajustes abaixo:

- Campo data precisa estar no formato YYYY-MM-DD (Y=Ano, M=Mes, D=Dia);
- Campo decimal (double) precisa estar no formato 00.00, exemplo: 1234.56;
- Campo lógico (boolean) precisa salvar o valor literal true ou false;
- Campo nulo (null) precisa ser convertido para vazio;
- Campo enum salvar o literal da opção selecionada: MASCULINO ou FEMININO

2-Nome: cadastro-{CPF}.txt - Destino: c:\jobby\files - Layout: posicional
A empresa People Job espera receber dos candidatos o arquivo cadastro-{CPF}.txt para que ela possa processar e armazenar em seu banco de dados central.

Este aquivo deverá seguir a estrutura posicional.

