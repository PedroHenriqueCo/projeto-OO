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
![Texto alternativo](![Captura de tela 2025-02-14 201538](![Captura de tela 2025-02-14 201656](https://github.com/user-attachments/assets/dc3d44f7-653b-4d06-8507-442b1dc0c3a3)
))

# Testes de Energia

> Apresentar com detalhes os testes feitos para conferir se os objetivos do *hardware* foram atendidos, incluindo:
>
> 1. Verificação da autonomia em operação real:
>    - Tempo de operação medido do carregamento completo até o limite seguro de descarga, com o robô navegando no labirinto de testes;
>    - Número de corridas possíveis com uma carga estimado para os labirintos 4x4, 8x4 e 12x4;
>    - Curva de tensão da bateria registrada pela telemetria durante o teste;
>    - Autonomia medida comparada com a estimada no dimensionamento da bateria.
> 2. Medição do consumo em repouso e em operação:
>    - Consumo medido em repouso (ESP32 ligado, motores parados);
>    - Consumo medido em operação (motores, sensores e Wi-Fi ativos) e no pico de partida dos motores;
>    - Leitura do monitor de energia comparada com a medição do multímetro;
>    - Resultados comparados com o consumo estimado (Requisitos de consumo dos componentes #114) e com a capacidade da bateria (Escolha da bateria #106).
> 3. Teste do carregador da bateria:
>    - Carregador comprado, compatível com LiPo 2S e com o conector da bateria;
>    - Carga balanceada verificada: tensão de cada célula medida ao fim da carga (≈ 4,20 V por célula, 8,4 V no total;
>    - Tempo de recarga completa medido, para planejar as corridas no dia da apresentação;
>    - Corrente de carga configurada dentro do limite da bateria (≤ 1C).
> 4. Teste dos barramentos de alimentação:
>    - VBAT, +5V e +3V3 medidos com multímetro sem carga e com os subsistemas ligados;
>    - Tensões dentro da faixa de tolerância definida nos requisitos;
>    - Queda de tensão em cada barramento medida com os motores em funcionamento.
> 5. Verificação das proteções elétricas:
>    - Chave geral desliga todo o robô;
>    - Proteção contra inversão de polaridade verificada (conector polarizado ou circuito de proteção);
>    - Proteção contra sobrecorrente (fusível/PTC) verificada sem colocar a LiPo em curto direto;
>    - Monitoramento de subtensão da bateria (limite de descarga da LiPo 2S) verificado pelo monitor de energia.
> 6. Verificação da temperatura dos componentes de potência:
>    - Temperatura medida no buck, na ponte H, nos motores e na bateria em repouso e após operação contínua;
>    - Medição também no pico de consumo (motores em partida/travados por poucos segundos);
>    - Temperaturas comparadas com os limites dos datasheets e com a análise de dissipação térmica;
>    - Bateria LiPo dentro da faixa segura de operação.
> 7. Verificação da estabilidade energética durante a navegação:
>    - Tensões de VBAT, +5V e +3V3 monitoradas pela telemetria durante as corridas;
>    - Nenhum reset ou brownout do ESP32 durante acelerações, frenagens e trocas de sentido dos motores;
>    - Causa do reset registrada pelo firmware (motivo do último reset do ESP32) e verificada após cada corrida;
>    - Falhas encontradas registradas como sub-issues com causa e correção.



| **ID** | **Descrição** | **Data de Início** | **Data de Conclusão** | **Responsável** | **Resultados Esperados** | **Resultados Obtidos** | **Aprovação Interna (S/N)** | **Aprovação do Orientador (S/N)** | **Observações** |
|:------:|---------------|--------------------|-----------------------|-----------------|--------------------------|------------------------|:---------------------------:|:--------------------------------:|-----------------|
| 2.1 | Verificação da autonomia da bateria durante a operação do Micromouse. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Verificar se a bateria fornece energia suficiente para manter o robô em funcionamento durante as corridas. | Teste realizado no período informado; resultados quantitativos pendentes de confirmação. | Pendente | Pendente | Registrar o tempo de operação e a tensão da bateria durante o teste. |
| 2.2 | Estimativa da quantidade de corridas realizadas com uma carga completa da bateria. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Estimar a quantidade de corridas possíveis nos labirintos de teste com uma carga completa. | Resultados quantitativos pendentes de confirmação. | Pendente | Pendente | Considerar o consumo de energia e a duração de cada corrida. |
| 2.3 | Monitoramento da tensão da bateria durante o funcionamento do robô. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Verificar a variação da tensão durante a operação e identificar quedas que possam afetar o funcionamento. | Resultados das medições pendentes de confirmação. | Pendente | Pendente | Utilizar os registros da telemetria, caso disponíveis. |
| 2.4 | Medição do consumo elétrico do sistema em repouso e durante a operação. | 21/10/2026 | 24/10/2026 | kelvinnsousa | Verificar se o consumo de energia está de acordo com os requisitos dos componentes e com a capacidade da bateria. | Valores medidos pendentes de confirmação. | Pendente | Pendente | Registrar as correntes e tensões medidas. |
| 2.5 | Verificação do funcionamento do carregador da bateria LiPo 2S. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Confirmar a compatibilidade do carregador com a bateria e verificar se a recarga ocorre dentro dos limites especificados pelo fabricante. | Resultados dos testes do carregador pendentes de confirmação. | Pendente | Pendente | Registrar o tempo de recarga e as tensões das células, se medidos. |
| 2.6 | Verificação das tensões dos barramentos de alimentação do circuito. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Confirmar que VBAT, +5V e +3V3 permanecem dentro das faixas de tensão especificadas. | Resultados das medições dos barramentos pendentes de confirmação. | Pendente | Pendente | Realizar medições com multímetro, em repouso e sob carga, conforme aplicável. |
| 2.7 | Verificação da estabilidade elétrica e das proteções do sistema durante a operação. | 21/10/2026 | 24/10/2026 | kelvinnsouza | Verificar a estabilidade da alimentação e o funcionamento das proteções elétricas para evitar falhas e danos aos componentes. | Resultados dos testes de estabilidade e proteção pendentes de confirmação. | Pendente | Pendente | Registrar eventuais falhas, resets ou quedas de tensão observadas. |
| 2.16 | | | | | | | | | |

