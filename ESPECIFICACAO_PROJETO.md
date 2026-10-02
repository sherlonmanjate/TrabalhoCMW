# Especificação do Projeto — CharlesWifi

## 1. Identificação
- Projeto: CharlesWifi
- Grupo: 3
- Turma: 3L6LASIR 1T
- Tema: A — Teste de Cobertura Wi-Fi

## 2. Objetivo
Desenvolver uma aplicação Android capaz de pesquisar redes Wi-Fi próximas, apresentar SSID e RSSI e permitir filtrar redes pelo nome.

## 3. Funcionalidades
- Pesquisa de redes Wi-Fi.
- Filtro por SSID.
- Apresentação do RSSI.
- Classificação da intensidade.
- Lista através de RecyclerView.

## 4. Activities
**MainActivity:** entrada do SSID, permissões e início da pesquisa.

**ResultsActivity:** pesquisa, processamento e apresentação dos resultados.

## 5. Comunicação
Intent envia o filtro da MainActivity para ResultsActivity.

## 6. Funcionalidade de rede
Uso de WifiManager, startScan(), BroadcastReceiver e getScanResults().

## 7. Interface
Uso de ConstraintLayout, ImageView, TextView, TextInputLayout, Button e RecyclerView.

## 8. Permissões
Uso de permissões relacionadas ao Wi-Fi, localização e dispositivos Wi-Fi próximos.

## 9. Testes
O aplicativo deve ser testado em diferentes locais do campus para comparar os valores RSSI.

## 10. Evidências
O README deve conter screenshots da implementação, compilação e das três fases de teste:
1. Tela inicial;
2. Pesquisa;
3. Resultados.
