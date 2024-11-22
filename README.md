# **ClearVolt Dashboard**

## **Descrição**
O **ClearVolt Dashboard** é um aplicativo que oferece gerenciamento inteligente de placas solares. Ele permite monitorar dados como potência, status e data de última limpeza das placas, além de possibilitar operações de controle e limpeza automatizada.

O projeto utiliza **Android Jetpack**, incluindo **Room**, **ViewModel**, **LiveData**, e segue o padrão **MVVM** para garantir escalabilidade e manutenção do código.

---

## **Recursos**
- **Gerenciamento de Placas Solares**: Adicionar, atualizar e excluir informações das placas solares.
- **Monitoramento de Status**: Verificar o estado atual de cada placa solar.
- **Limpeza Automática**: Marcar placas como limpas remotamente.
- **Persistência de Dados**: Uso de Room para armazenamento local eficiente e confiável.

---

## **Tecnologias Utilizadas**
- **Kotlin**
- **Room Database**
- **MVVM Architecture**
- **Android Jetpack Components**
  - ViewModel
  - LiveData
  - Room

---

## **Configuração do Ambiente**

### **Pré-requisitos**
Certifique-se de ter instalado:
- **Android Studio** (recomendado: versão mais recente)
- **Gradle** configurado no projeto
- **JDK 11+**

### **Configuração do Projeto**
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/clearvolt-dashboard.git
   cd clearvolt-dashboard
2. Abra o projeto no Android Studio.
3. Sincronize o projeto com o Gradle.
4. Conecte um dispositivo físico ou inicie um emulador para rodar o aplicativo.
   

###**Estrutura do Projeto**
##**1. Banco de Dados**
#*Room Database*
O banco de dados é configurado usando o Room para armazenar informações sobre as placas solares. Ele contém:

- *Entidade:* PlacaSolarEntity
  Representa os dados de cada placa solar: nome, potência, última limpeza e status.

- *DAO (Data Access Object):* PlacaSolarDao
  Fornece métodos de CRUD (Create, Read, Update, Delete):

  - listarPlacas(): Retorna uma lista de todas as placas solares.
  - inserirPlaca(): Insere uma nova placa no banco de dados.
  - atualizarPlaca(): Atualiza uma placa existente.
  - deletarPlaca(): Remove uma placa do banco de dados.
  - limparPlaca(): Marca uma placa como limpa.

##**2. ViewModel**
A PlacaSolarViewModel interage com o repositório para fornecer os dados à UI. Utiliza LiveData para gerenciar os dados em tempo real e garantir que a UI seja atualizada automaticamente.

##**3. Repository**
O PlacaSolarRepository é responsável pela lógica de acesso aos dados e fornece uma interface entre o ViewModel e o DAO
