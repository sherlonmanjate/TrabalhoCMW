# 📶 Trabalho CMW - Wifi

Aplicação Android desenvolvida para o **Tema A — Teste de Cobertura Wi-Fi**, permitindo pesquisar redes Wi-Fi próximas, identificar o SSID e apresentar a intensidade do sinal através do RSSI.

## 🎓 Informações
- **Instituição:** Universidade São Tomás de Moçambique (USTM)
- **Faculdade:** Faculdade de Ciências e Tecnologias de Informação
- **Curso:** Administração de Sistemas de Informação e Redes
- **Turma:** 3L6LASIR 1T
- **Grupo:** 3
- **Tema:** A — Teste de Cobertura Wi-Fi
- **Projeto:** CharlesWifi
- **Plataforma:** Android
- **Linguagem:** Java
- **IDE:** Android Studio
- **Compile SDK:** 35
- **Minimum SDK:** 23

## 👥 Membros
1. Edmilson Anselmo Mugabe — 2023111036
2. Kelvin Charles Combane — 202301931
3. Sherlon Abel de Afonso Manjate — 2020111198
4. Nome completo — Nº

## 📌 Descrição
O CharlesWifi é uma aplicação Android criada para realizar testes de cobertura Wi-Fi em diferentes locais do campus. A aplicação pesquisa redes próximas e apresenta SSID, RSSI e classificação da intensidade.

## 🎯 Objetivos
- Pesquisar redes Wi-Fi próximas.
- Identificar SSID.
- Obter RSSI.
- Filtrar pelo nome da rede.
- Apresentar resultados organizados.
- Classificar a intensidade.
- Utilizar duas Activities e Intent.
- Utilizar ConstraintLayout, RecyclerView, WifiManager e BroadcastReceiver.

## ⚙️ Funcionalidades
### Pesquisa Wi-Fi
Utiliza os recursos Wi-Fi do Android para pesquisar redes próximas.

### Filtro
O utilizador pode escrever o nome completo ou parte do nome da rede. Se deixar vazio, a aplicação pode apresentar todas as redes encontradas.

### Informações
Cada resultado apresenta:
- SSID
- RSSI
- Qualidade

## 📊 Classificação
| RSSI | Qualidade |
|---|---|
| ≥ -50 dBm | Excelente |
| -51 a -60 dBm | Boa |
| -61 a -70 dBm | Regular |
| < -70 dBm | Fraca |

## 📱 Activities
### MainActivity
Tela inicial para inserir o SSID, solicitar permissões e iniciar a pesquisa.

### ResultsActivity
Realiza a pesquisa, processa os resultados e apresenta a lista.

## 🔗 Intent
O filtro digitado na MainActivity é enviado para ResultsActivity através de Intent.

Fluxo:
```text
MainActivity → Intent → ResultsActivity → Pesquisa Wi-Fi → Resultados
```

## 📡 WifiManager
A pesquisa utiliza:
```java
wifiManager.startScan();
wifiManager.getScanResults();
```
O SSID é obtido por `result.SSID` e o RSSI por `result.level`.

## 📢 BroadcastReceiver
O BroadcastReceiver aguarda `WifiManager.SCAN_RESULTS_AVAILABLE_ACTION` e, quando os resultados estão disponíveis, atualiza a lista.

## 📋 RecyclerView
Apresenta as redes em forma de lista, mostrando SSID, RSSI e qualidade.

## 🔌 WifiAdapter
Liga os objetos `WifiNetwork` aos itens do RecyclerView.

## 🧱 WifiNetwork
Representa cada rede encontrada e armazena SSID e RSSI, além de determinar a qualidade do sinal.

## 🎨 Interface
O CharlesWifi possui uma interface própria, com tela inicial centralizada, fundo escuro, ícone Wi-Fi, campo de pesquisa e botão **ANALISAR WI-FI**. A tela de resultados utiliza uma lista organizada.

## 🔐 Permissões
```text
ACCESS_WIFI_STATE
CHANGE_WIFI_STATE
ACCESS_FINE_LOCATION
ACCESS_COARSE_LOCATION
NEARBY_WIFI_DEVICES
```

## 🧪 Teste do aplicativo
### Fase 1 — Tela inicial
Tela para escrever o nome da rede e iniciar a análise.

### Fase 2 — Pesquisa
Pesquisa das redes Wi-Fi disponíveis nas proximidades.

### Fase 3 — Resultados
Lista das redes encontradas com SSID, RSSI e classificação.

## 📸 Screenshots
Adicionar no README as imagens da implementação, compilação e testes.

### MainActivity
Implementação da tela principal.
```markdown
![MainActivity](LINK_DA_IMAGEM)
```

### Permissões
Configuração das permissões.
```markdown
![Permissões](LINK_DA_IMAGEM)
```

### Intent
Comunicação entre Activities.
```markdown
![Intent](LINK_DA_IMAGEM)
```

### WifiManager
Pesquisa das redes Wi-Fi.
```markdown
![WifiManager](LINK_DA_IMAGEM)
```

### BroadcastReceiver
Receção dos resultados.
```markdown
![BroadcastReceiver](LINK_DA_IMAGEM)
```

### RecyclerView
Lista das redes encontradas.
```markdown
![RecyclerView](LINK_DA_IMAGEM)
```

## 🏗️ Estrutura
```text
CharlesWifi
├── app
│   └── src/main
│       ├── java/mz/ustm/charleswifi
│       │   ├── MainActivity.java
│       │   ├── ResultsActivity.java
│       │   ├── WifiNetwork.java
│       │   └── WifiAdapter.java
│       ├── res
│       │   ├── drawable
│       │   ├── layout
│       │   │   ├── activity_main.xml
│       │   │   ├── activity_results.xml
│       │   │   └── item_wifi.xml
│       │   └── values
│       └── AndroidManifest.xml
├── build.gradle
├── settings.gradle
├── gradle.properties
├── README.md
└── ESPECIFICACAO_PROJETO.md
```

## 🛠️ Tecnologias
- Android Studio
- Java
- Android SDK
- ConstraintLayout
- Material Components
- RecyclerView
- WifiManager
- BroadcastReceiver
- Intent

## ▶️ Como executar
1. Abrir a pasta CharlesWifi no Android Studio.
2. Aguardar a sincronização do Gradle.
3. Conectar um dispositivo Android ou utilizar emulador.
4. Executar com **Run ▶**.
5. Ativar Wi-Fi.
6. Ativar localização quando solicitado.
7. Escrever o nome da rede ou deixar vazio.
8. Clicar em **ANALISAR WI-FI**.
9. Visualizar os resultados.

## 📍 Teste de cobertura
O aplicativo pode ser testado em diferentes locais do campus, como sala de aula, biblioteca, laboratório e cantina, comparando os valores RSSI obtidos.

| Local | SSID | RSSI | Qualidade |
|---|---|---:|---|
| Sala de aula | USTM-WIFI | -45 dBm | Excelente |
| Biblioteca | USTM-WIFI | -58 dBm | Boa |
| Laboratório | USTM-WIFI | -65 dBm | Regular |
| Cantina | USTM-WIFI | -74 dBm | Fraca |

> Os valores são apenas exemplos. No relatório devem ser utilizados os valores reais obtidos durante os testes.

## ⚠️ Observações
- O número de redes depende do local.
- O RSSI pode variar durante a utilização.
- Paredes e distância afetam o sinal.
- O Android pode limitar a frequência das pesquisas.
- As permissões solicitadas devem ser concedidas.

## 📚 Conclusão
O CharlesWifi demonstra de forma prática a pesquisa de redes Wi-Fi em Android e aplica conceitos de Activities, Intent, Widgets, ConstraintLayout, RecyclerView, Adapter, WifiManager, BroadcastReceiver e permissões Android.

## 📁 Conteúdo do repositório
- Código-fonte completo.
- Layouts XML.
- AndroidManifest.
- Classes Java.
- README.md.
- ESPECIFICACAO_PROJETO.md.
- Recursos gráficos.
- Configurações Gradle.
- Screenshots da implementação, compilação e testes.

## 🎓 Projeto Académico
**Universidade São Tomás de Moçambique — USTM**  
**Faculdade de Ciências e Tecnologias de Informação**  
**Curso:** Administração de Sistemas de Informação e Redes  
**Turma:** 3L6LASIR 1T  
**Grupo:** 3  
**Tema:** A — Teste de Cobertura Wi-Fi  
**Projeto:** CharlesWifi  
**Ano Lectivo:** 2026
