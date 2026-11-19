# Battleship
# Grupo

**Grupo5**

## Membros

| Curso | Número | Nome |
|---|---:|---|
| LEI-PL | 130484 | Afonso Araújo Lopes de Almeida Fornelos |
| LEI-PL | 131638 | Martim Manuel Guerreiro Baía |
| LEI-PL | 130501 | Miguel Pinto Lopes de Assunção |
| LEI-PL | 130478 | Dinis Bernardo da Silva Branco Fernandes |

## Scrum Product Backlog — Batalha Naval Online (PaperGames)

### US01 — Aceder à página inicial e ao jogo de Batalha Naval

* **História:** Como **jogador**, quero **aceder à página principal e à secção específica de Batalha Naval**, para **iniciar uma partida ou explorar as opções do jogo**.
* **Critérios de aceitação:**
* A navegação para `/en/` e `/en/battleship` carrega a interface sem erros.
* É possível identificar o jogo de Batalha Naval e iniciar o fluxo de jogo.



### US02 — Consultar guias e regras do jogo

* **História:** Como **jogador**, quero **consultar a documentação com guias de jogo**, para **compreender as regras e mecânicas aplicáveis**.
* **Critérios de aceitação:**
* A partir de `/docs/game-guides/` é possível aceder aos guias disponíveis.
* As instruções permitem perceber o funcionamento das partidas antes ou durante o jogo.



### US03 — Criar um torneio de Batalha Naval

* **História:** Como **organizador**, quero **criar um torneio configurado para Batalha Naval**, para **organizar competições entre vários participantes**.
* **Critérios de aceitação:**
* Ao aceder a `/en/t/create-tournament?game=Battleships` (ou `/en/t/create-tournament`), o jogo de Batalha Naval surge selecionado ou disponível.
* É possível submeter a criação do torneio e obter a respetiva página de gestão/partilha.



### US04 — Consultar e gerir os meus torneios

* **História:** Como **organizador ou participante**, quero **consultar a lista dos meus torneios**, para **acompanhar o estado das competições em que participo ou que criei**.
* **Critérios de aceitação:**
* A página `/en/t/my-tournaments` apresenta os torneios associados ao utilizador/sessão.
* Selecionar um torneio permite abrir a sua página de detalhe.



### US05 — Aceder à página de um torneio específico

* **História:** Como **jogador ou espectador**, quero **abrir a página de um torneio através do seu link direto**, para **ver detalhes, participantes ou estado do torneio**.
* **Critérios de aceitação:**
* O acesso a uma URL de torneio (ex.: `/en/t/H_hQkKxUb`) carrega a vista correspondente do torneio.
* São apresentados os elementos principais de informação e navegação do torneio.



### US06 — Consultar o histórico de partidas de Batalha Naval

* **História:** Como **jogador**, quero **consultar o histórico de partidas filtrado por Batalha Naval**, para **rever resultados anteriores**.
* **Critérios de aceitação:**
* O acesso a `/en/match-history?gameType=Battleships` (ou `/en/match-history`) exibe o registo de partidas.
* Os registos visíveis correspondem ao filtro selecionado (`Battleships`).



### US07 — Gerir lista de amigos

* **História:** Como **jogador**, quero **aceder à área de amigos**, para **gerir contactos e facilitar partidas com outras pessoas**.
* **Critérios de aceitação:**
* A página `/en/friends` carrega a secção social de amigos.
* Os controlos de gestão/visualização da lista de amigos respondem às interações do utilizador.



### US08 — Utilizar o chat da plataforma

* **História:** Como **jogador**, quero **aceder à funcionalidade de chat**, para **comunicar com outros utilizadores na plataforma**.
* **Critérios de aceitação:**
* A página `/en/chat` apresenta a interface de mensagens.
* O campo de interação/envio de mensagens está acessível na interface.



### US09 — Explorar a loja e itens cosméticos/moedas virtuais

* **História:** Como **jogador**, quero **navegar pela loja e pelas categorias de moedas virtuais, emojis e avatares**, para **personalizar o meu perfil ou adquirir itens**.
* **Critérios de aceitação:**
* As páginas `/en/shop`, `/en/shop/virtual-coins`, `/en/shop/emojis` e `/en/shop/avatars` carregam corretamente.
* Cada secção apresenta os respetivos itens ou opções disponíveis.



### US10 — Consultar planos e modalidades de subscrição/serviços

* **História:** Como **utilizador**, quero **consultar as páginas de planos (`Gruppo`, `Plus` e `Games as a Service`)**, para **conhecer as opções disponíveis na plataforma**.
* **Critérios de aceitação:**
* As rotas `/en/pricing/gruppo`, `/en/pricing/plus` e `/en/pricing/games-as-a-service` abrem sem erro.
* Cada página apresenta informação clara sobre a respetiva modalidade.



### US11 — Navegar para outros jogos do catálogo

* **História:** Como **jogador**, quero **aceder a outros jogos disponíveis na plataforma** (como Xadrez, Damas, Connect 4, Gomoku, Tic-Tac-Toe, Gamão, Reversi, Dots and Boxes, Gin Rummy, Mancala ou Cribbage), para **experimentar diferentes modalidades**.
* **Critérios de aceitação:**
* As páginas de cada jogo (ex.: `/en/chess`, `/en/checkers`, `/en/connect4`, `/en/gomoku`, `/en/tic-tac-toe`, `/en/backgammon`, `/en/reversi`, `/en/dots-and-boxes`, `/en/gin-rummy`, `/en/mancala`, `/en/cribbage`) carregam a respetiva interface.
* A navegação entre jogos mantém a consistência da aplicação.



### US12 — Consultar novidades (`changelog`), blogue e documentação para programadores

* **História:** Como **utilizador ou programador**, quero **aceder ao `changelog`, ao blogue (ex.: artigo `ranka`) e ao portal de programadores**, para **acompanhar atualizações e recursos técnicos**.
* **Critérios de aceitação:**
* As URLs `/en/changelog`, `/en/blog/ranka` e `[https://developers.papergames.io/](https://developers.papergames.io/)` carregam com sucesso.
* O conteúdo de atualizações e documentação apresenta-se legível e acessível.



### US13 — Consultar políticas legais e de moderação de conteúdos

* **História:** Como **utilizador**, quero **consultar a política de privacidade, os termos e condições e a política de moderação de conteúdos**, para **conhecer as regras de utilização e privacidade do serviço**.
* **Critérios de aceitação:**
* As páginas `/en/blog/privacy-policy`, `/en/blog/terms-conditions` e `/en/blog/content-moderation-` carregam corretamente.
* Os textos legais e de moderação ficam acessíveis para leitura.



---
