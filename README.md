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
| 2.1 | | | | | | | | | |
| 2.2 | | | | | | | | | |
| 2.3 | | | | | | | | | |
| 2.4 | | | | | | | | | |
| 2.5 | | | | | | | | | |
| 2.6 | | | | | | | | | |
| 2.7 | | | | | | | | | |
| 2.8 | | | | | | | | | |
| 2.9 | | | | | | | | | |
| 2.10 | | | | | | | | | |
| 2.12 | | | | | | | | | |
| 2.13 | | | | | | | | | |
| 2.15 | | | | | | | | | |
| 2.16 | | | | | | | | | |

# Testes de Energia

| **ID** | **Descrição** | **Data de Início** | **Data de Conclusão** | **Responsável** | **Resultados Esperados** | **Resultados Obtidos** | **Aprovação Interna (S/N)** | **Aprovação do Orientador (S/N)** | **Observações** |
|:------:|---------------|--------------------|-----------------------|-----------------|--------------------------|------------------------|:---------------------------:|:--------------------------------:|-----------------|
| 2.1 | Testar a autonomia da bateria LiPo 2S durante a navegação do Micromouse em labirinto, do carregamento completo até o limite seguro de descarga. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Determinar o tempo de operação contínua do robô e verificar se a autonomia atende aos requisitos definidos no dimensionamento da bateria. | Aguardando confirmação das medições de autonomia realizadas. | Pendente | Pendente | Registrar o tempo de operação, a tensão inicial e final e as condições do teste. |
| 2.2 | Estimar a quantidade de corridas que o Micromouse consegue realizar com uma carga completa nos labirintos 4x4, 8x4 e 12x4. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Determinar a quantidade estimada de corridas por carga para cada labirinto, considerando o consumo de energia e a autonomia medidos. | Aguardando dados de consumo e duração das corridas para estimar a quantidade de execuções por carga. | Pendente | Pendente | Comparar os resultados entre os três tamanhos de labirinto. |
| 2.3 | Registrar a curva de tensão da bateria durante a navegação por meio da telemetria do robô. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Monitorar a variação da tensão durante as corridas e identificar quedas que possam comprometer o funcionamento do sistema. | Aguardando confirmação dos registros de telemetria e dos valores de tensão obtidos durante os testes. | Pendente | Pendente | Comparar a autonomia observada com a estimativa de dimensionamento da bateria. |
| 2.4 | Medir o consumo elétrico em repouso, com o ESP32 ligado e os motores parados. | 21/10/2026 | 24/10/2026 | kelvinnsousa | Determinar a corrente consumida em repouso e verificar sua compatibilidade com os requisitos de consumo dos componentes (#114). | Aguardando confirmação das medições de corrente e tensão em repouso. | Pendente | Pendente | Registrar os valores medidos e compará-los com o consumo estimado. |
| 2.5 | Medir o consumo elétrico durante a operação, com motores, sensores e Wi-Fi ativos, incluindo o pico de corrente na partida dos motores. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Identificar o consumo durante a operação normal e os picos de corrente, verificando se a bateria e os circuitos de alimentação suportam a demanda. | Aguardando confirmação das medições de consumo durante a operação e na partida dos motores. | Pendente | Pendente | Comparar com os requisitos de consumo dos componentes (#114) e com a escolha da bateria (#106). |
| 2.6 | Comparar as leituras do monitor de energia com as medições realizadas por multímetro. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Verificar a consistência das leituras de tensão e corrente do monitor de energia em relação ao multímetro. | Aguardando confirmação dos valores registrados pelos dois instrumentos. | Pendente | Pendente | Registrar as diferenças encontradas e avaliar a precisão das leituras. |
| 2.7 | Verificar o carregador adquirido para a bateria LiPo 2S, incluindo compatibilidade elétrica e compatibilidade do conector. | 21/10/2026 | 24/10/2026 | kelvinnsouza | Confirmar que o carregador é adequado para uma bateria LiPo 2S e que permite realizar a recarga de forma segura. | Aguardando confirmação do modelo do carregador e dos testes de compatibilidade realizados. | Pendente | Pendente | Conferir as especificações do carregador, da bateria e dos conectores antes da utilização. |
| 2.8 | Verificar a tensão individual das células da bateria ao final da recarga e medir o tempo necessário para uma carga completa. | 21/10/2026 | 24/10/2026 | A definir | Confirmar a carga balanceada, com aproximadamente 4,20 V por célula e 8,40 V no conjunto, além de determinar o tempo de recarga. | Aguardando confirmação das tensões individuais das células e do tempo de recarga medido. | Pendente | Pendente | Utilizar carregador balanceador apropriado para LiPo 2S e respeitar as especificações do fabricante. |
| 2.9 | Verificar a corrente de carga configurada no carregador e sua compatibilidade com o limite permitido pela bateria. | 21/10/2026 | 24/10/2026 | A definir | Confirmar que a corrente de carga respeita o limite especificado pelo fabricante e não ultrapassa 1C quando esse for o limite estabelecido. | Aguardando confirmação da corrente configurada e das especificações da bateria. | Pendente | Pendente | O limite de corrente deve ser confirmado no datasheet da bateria. |
| 2.10 | Medir as tensões dos barramentos VBAT, +5V e +3V3 com o circuito sem carga e com os subsistemas ligados. | 21/10/2026 | 24/10/2026 | A definir | Verificar se os barramentos permanecem dentro das faixas de tensão previstas nos requisitos elétricos do projeto. | Aguardando confirmação das medições dos três barramentos nas condições especificadas. | Pendente | Pendente | Registrar as tensões em vazio e sob carga utilizando multímetro. |
| 2.12 | Medir a queda de tensão nos barramentos de alimentação durante o funcionamento dos motores. | 21/10/2026 | 24/10/2026 | A definir | Confirmar que as quedas de tensão durante a operação não comprometem a alimentação dos sensores, do ESP32 e dos demais componentes. | Aguardando confirmação das tensões medidas durante o funcionamento dos motores. | Pendente | Pendente | Comparar as medições em repouso e sob carga, considerando as tolerâncias especificadas. |
| 2.13 | Verificar as proteções elétricas do Micromouse, incluindo chave geral, proteção contra inversão de polaridade, sobrecorrente e subtensão. | 21/10/2026 | 24/10/2026 | A definir | Confirmar o funcionamento da chave geral e das proteções implementadas, evitando danos aos componentes e descarga excessiva da bateria. | Aguardando confirmação dos testes funcionais das proteções elétricas. | Pendente | Pendente | Não provocar curto-circuito direto na LiPo. Documentar o método utilizado para validar cada proteção. |
| 2.15 | Verificar a temperatura do conversor buck, da ponte H, dos motores e da bateria em repouso e após operação contínua e picos de consumo. | 21/10/2026 | 24/10/2026 | A definir | Confirmar que os componentes operam dentro dos limites de temperatura especificados pelos fabricantes, incluindo a bateria. | Aguardando confirmação das temperaturas medidas durante os diferentes regimes de funcionamento. | Pendente | Pendente | Registrar as temperaturas e compará-las com os limites dos datasheets. |
| 2.16 | Verificar a estabilidade da alimentação durante a navegação, monitorando os barramentos, possíveis resets e eventos de brownout do ESP32. | 21/10/2026 | 24/10/2026 | A definir | Confirmar que a alimentação permanece estável durante acelerações, frenagens e mudanças de sentido, sem resets ou brownouts inesperados. | Aguardando confirmação dos registros de telemetria e da verificação dos motivos de reset após as corridas. | Pendente | Pendente | Registrar falhas identificadas e documentar suas causas e correções em sub-issues. |



  


     


