# projeto-OO
# UnB - Universidade de Brasilia

FGA - Faculdade do Gama

OO - Orientação por Objetos

Prof. André Luiz Peron Martins Lanna

# Integrantes do Projeto:

João Pedro Fortaleza Menezes - 232003680

Maria Eduarda Dos Santos Rosa- 232023940

Pedro Henrique Conceição De Souza - 232030032

# Resumo do Projeto
## Objetivo
O objetivo desse trabalho é desenvolver um sistema que utilize os conceitos de orientação a objetos para gerenciar diversas funcionalidades de uma clínica médica. A aplicação prática dos conceitos de modularidade, encapsulamento, herança, polimorfismo e tratamento de exceções personalizadas.




# Funcionalidades Principais
#### Cadastro de Pacientes e Médicos
- cria, ler, atualiza, deleta os dados dos pacientes.
- adciona consultas ao histórico médico.
- Bloquear o cadastro de pacientes com CPF já registrado no sistema.
#### Agendamento de Consultas
- O sistema permiti que consultas sejam agendadas, visualizadas, atualizadas e canceladas.
#### Prescrição de Exames e Medicamentos
- O sistema permiti a criação, leitura, atualização e exclusão de exames e medicamentos.
- Médicos podem prescrever exames ou medicamentos, associando-os a uma consulta específica.
#### Gestão de Pagamentos
- Cada consulta e exame tem um valor associado que deve ser pago pelo paciente.
- Pacientes com pagamentos pendentes não podem agendar novas consultas até que regularizem a situação financeira.
#### Tratamento de Exceções
- Agendamento em horário indisponível: Quando o médico não está disponível para o horário solicitado.
- Paciente com pagamento pendente: Quando um paciente tentar agendar uma consulta sem quitar os pagamentos pendentes.
- Médico não encontrado para uma especialidade: Quando o sistema não encontrar um médico disponível para a especialidade desejada.
## Exceções
 Ao implementar essas exceções, o sistema consegue tratar de forma eficaz erros de lógica, prevenindo que ações indesejadas ou inválidas sejam executadas e oferecendo uma experiência mais confiável para o usuário.
 
   - HorarioIndisponivelException: Lançada quando se tenta agendar uma consulta em um horário que já está ocupado.
   - PagamentoPendenteException: Lançada quando o paciente tenta agendar uma consulta ou exame com pendências financeiras.
   - EspecialidadeInvalidaException: Lançada quando o paciente tenta agendar uma consulta com um médico que não possui a especialidade necessária.
## Desafios e Soluções
- Utilizar herança e polimorfismo de forma eficaz para representar diferentes tipos de médicos, consultas e exames, sem criar um código complexo ou difícil de entender.
- boas práticas de orientação a objetos, como o uso de encapsulamento, herança e polimorfismo, além de uma análise cuidadosa do fluxo de trabalho da clínica médica e a implementação de regras de negócio de forma clara e eficiente.
     
# 💻 Modelagem
utilizado a Linguagem de Modelagem Unificada (UML) para a minimalização de eventuais erros estruturais, além de guiar nosso desenvolvimento. Somado a isso, vale ressaltar que o artefato Diagrama de Classes UML desenvolvido foi atualizado conforme a necessidade durante o desenvolvimento do projeto. Confira o artefato UML desenvolvido na imagem.
![Texto alternativo](![Captura de tela 2025-02-14 201538](https://github.com/user-attachments/assets/7ef41835-3d66-4be0-ad6e-45fd6a57d31b))
![Texto alternativo](![Captura de tela 2025-02-14 201538](![Captura de tela 2025-02-14 201618](https://github.com/user-attachments/assets/90c3644c-3887-4f95-ae22-f64304ce34ec)
))


  


     


