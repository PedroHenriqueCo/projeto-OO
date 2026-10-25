

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
| 2.1 | Verificação da autonomia em operação real. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Verificar o tempo de funcionamento do Micromouse com uma carga completa e estimar a quantidade de corridas possíveis nos labirintos de teste. | A autonomia energética foi estimada com base na capacidade da bateria e no consumo previsto dos componentes. A simulação do circuito pode complementar a análise do consumo e da alimentação, contribuindo para estimar o tempo de funcionamento e a quantidade de corridas por carga. | Pendente | Pendente | A autonomia total depende também do perfil de movimento e deve ser estimada com dados de consumo e duração das corridas. |
| 2.2 | Medição do consumo em repouso e em operação real. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Avaliar o consumo elétrico do sistema em repouso e durante a navegação, incluindo a partida dos motores. | O consumo energético foi analisado a partir das especificações dos componentes. A simulação do circuito permite avaliar a corrente e a tensão nos estados de repouso e operação, desde que os componentes e os perfis de carga sejam representados adequadamente. | Pendente | Pendente | Comparar os resultados simulados com as especificações técnicas dos componentes. |
| 2.3 | Teste do carregador da bateria. | 21/10/2026 | 24/10/2026 | PedroHenriqueCo | Verificar a compatibilidade do carregador com a bateria LiPo 2S, a tensão final das células, o balanceamento e o tempo de recarga. | A compatibilidade do carregador foi analisada com base nas especificações da bateria LiPo 2S e do equipamento de recarga, considerando a tensão de carregamento, o balanceamento das células e a corrente permitida. | Pendente | Pendente | Análise baseada na documentação técnica dos equipamentos. |
| 2.4 | Teste dos barramentos de alimentação. | 21/10/2026 | 24/10/2026 | kevinnsousa | Verificar se as tensões de VBAT, +5V e +3V3 permanecem dentro das faixas de tolerância especificadas. | Os barramentos de alimentação foram analisados pelas tensões nominais dos reguladores e pelos requisitos dos componentes. A simulação do circuito permite verificar os níveis de tensão e avaliar as quedas de tensão sob diferentes condições de carga, conforme os modelos disponíveis. | Pendente | Pendente | Comparar as tensões simuladas com os valores nominais e as tolerâncias especificadas. |
| 2.5 | Verificação das proteções elétricas. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Avaliar as proteções contra inversão de polaridade, sobrecorrente e descarga excessiva da bateria, além do funcionamento da chave geral. | As proteções elétricas foram analisadas com base nos requisitos do circuito e nas especificações dos componentes. A simulação pode verificar o comportamento da chave geral e dos circuitos de proteção representados, incluindo condições de sobrecorrente e inversão de polaridade, quando suportadas pelo modelo. | Pendente | Pendente | A simulação depende da representação adequada das proteções e não substitui a validação física de todos os mecanismos. |
| 2.6 | Verificação da temperatura dos componentes de potência. | 21/10/2026 | 24/10/2026 | UnderwaterVillager | Avaliar se as temperaturas do conversor buck, da ponte H, dos motores e da bateria permanecem dentro dos limites seguros. | O comportamento térmico foi analisado teoricamente com base nas especificações dos fabricantes, nos limites de temperatura e nas características de dissipação de potência dos componentes. | Pendente | Pendente | Análise baseada em datasheets e estimativas térmicas. |
| 2.7 | Verificação da estabilidade energética durante a navegação. | 21/10/2026 | 24/10/2026 | kevinnsouza | Avaliar a estabilidade da alimentação durante acelerações, frenagens e mudanças de sentido, considerando o funcionamento do ESP32 e dos motores. | A estabilidade energética foi analisada considerando a demanda de corrente dos motores e a capacidade dos reguladores. A simulação do circuito pode avaliar variações de tensão e quedas nos barramentos durante mudanças de carga, desde que os modelos dos componentes e as condições de operação sejam representados. | Pendente | Pendente | A simulação ajuda a avaliar a alimentação, mas a ausência de resets ou brownouts do ESP32 deve ser confirmada com testes do firmware e do hardware. |

