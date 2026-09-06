## Épicos

| Código | Nome | Justificativa |
|--------|------|---------------|
| **E1** | Dashboard e Monitoramento | Painel central de acompanhamento operacional. Irá depender de dados produzidos por todos os outros épicos — desenvolvido por último, quando há informação real para exibir. Substitui a tela atual que não é intuitiva e abre outras telas, para cards cards dinâmicos, contadores por status e atalhos diretos às ações do sistema. |
| **E2** | Captação e Orçamento | Abrange a entrada inicial do fluxo: registro de solicitações do cliente, criação do orçamento pelo atendente, geração de arquivo de orçamento e envio automático ao cliente com link de aprovação por token — sem necessidade de login do cliente. |
| **E3** | Ordem de Serviço e Workflow | Converte orçamentos aprovados em Ordens de Serviço, permitindo a definição de workflows do serviço (tradução, revisão, formatação) e a alocação de recursos em cada etapa. Inclui cadastro de modelos de workflow reutilizáveis. |
| **E4** | Execução de Tradução | Operacionaliza a execução do workflow: notificação do recurso que podem aceitar ou aceitar ou rejeitar, upload do arquivo entregue, roteamento automático para a etapa seguinte e verificação final pelo funcionário antes do envio ao cliente. |
| **E5** | Financeiro | Fecha o ciclo de negócio: geração de fatura de venda (cobrança ao cliente) e fatura de compra (repasse ao recurso) a partir das OS concluídas, controle de status de pagamento e relatório simples de lucro por OS. Escopo reduzido intencionalmente — sem integrações fiscais externas. |
| **E6** | Admin & Configurações | Base cadastral e estrutural de todo o sistema: autenticação, controle de acesso por perfil/role, cadastros de clientes, recursos, serviços, idiomas, tabelas de preço e configurações da empresa. Pré-requisito de todos os demais épicos. |

---
