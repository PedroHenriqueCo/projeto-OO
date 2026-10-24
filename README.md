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
| 2.1 | Verificação da autonomia em operação real. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Verificar o tempo de funcionamento do Micromouse com uma carga completa e estimar a quantidade de corridas possíveis nos labirintos de teste. | Foi realizada uma análise teórica da autonomia da bateria, considerando sua capacidade e o consumo estimado dos componentes. A análise serviu de base para estimar o tempo de funcionamento e a quantidade de corridas possíveis por carga. | Pendente | Pendente | Resultado baseado em estimativas, sem confirmação por teste físico. |
| 2.2 | Medição do consumo em repouso e em operação real. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Avaliar o consumo elétrico do sistema em repouso e durante a navegação, incluindo os picos de corrente na partida dos motores. | Foi realizada uma análise do consumo energético com base nas especificações dos componentes e em pesquisas técnicas. Foram considerados os diferentes estados de funcionamento do robô para avaliar a demanda de corrente do sistema. | Pendente | Pendente | Comparar as estimativas com os requisitos de consumo dos componentes (#114) e a escolha da bateria (#106). |
| 2.3 | Teste do carregador da bateria. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Verificar a compatibilidade do carregador com a bateria LiPo 2S, a tensão final das células, o balanceamento e o tempo de recarga. | Foi realizada uma análise das especificações técnicas do carregador e da bateria LiPo 2S, considerando a tensão de carga, a compatibilidade dos conectores, o balanceamento das células e a corrente de recarga permitida. | Pendente | Pendente | A compatibilidade foi avaliada documentalmente; o tempo real de recarga e o balanceamento precisam de confirmação por medição. |
| 2.4 | Teste dos barramentos de alimentação. | 21/10/2026 | 24/10/2026 | kelvinnsousa | Verificar se as tensões de VBAT, +5V e +3V3 permanecem dentro das faixas de tolerância especificadas. | Foi realizada uma análise das tensões nominais dos barramentos e das especificações dos reguladores de tensão. Também foram consideradas as possíveis quedas de tensão decorrentes da demanda dos componentes durante a operação. | Pendente | Pendente | Resultado baseado na documentação técnica, sem confirmação de medições físicas. |
| 2.5 | Verificação das proteções elétricas. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Avaliar as proteções contra desligamento inadequado, inversão de polaridade, sobrecorrente e descarga excessiva da bateria. | Foram analisados os requisitos de proteção elétrica e as especificações dos componentes responsáveis pela alimentação e segurança do circuito. A análise considerou os limites de corrente e as condições seguras de operação da bateria. | Pendente | Pendente | A análise documental não comprova, por si só, o funcionamento efetivo das proteções. |
| 2.6 | Verificação da temperatura dos componentes de potência. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Avaliar se as temperaturas do conversor buck, da ponte H, dos motores e da bateria permanecem dentro dos limites seguros. | Foi realizada uma análise dos limites térmicos especificados pelos fabricantes e das possíveis perdas de potência dos componentes. Foram considerados os efeitos do consumo elétrico e da dissipação de calor durante a operação. | Pendente | Pendente | As temperaturas efetivas dos componentes não foram confirmadas por medições físicas. |
| 2.7 | Verificação da estabilidade energética durante a navegação. | 21/10/2026 | 24/10/2026 | kelvinnsouza | Avaliar a estabilidade da alimentação durante acelerações, frenagens e mudanças de sentido, identificando possíveis resets ou brownouts do ESP32. | Foi realizada uma análise teórica da estabilidade energética, considerando os picos de corrente dos motores, a capacidade dos reguladores e as possíveis quedas de tensão nos barramentos. Foram identificados fatores que podem comprometer a alimentação e causar reinicializações do ESP32. | Pendente | Pendente | A ausência de resets durante a navegação só pode ser confirmada por testes práticos ou registros de telemetria. |


