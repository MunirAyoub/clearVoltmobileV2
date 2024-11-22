# ClearVolt Dashboard

## Descrição
O ClearVolt Dashboard é um aplicativo que oferece gerenciamento inteligente de placas solares. Ele permite monitorar dados como potência, status e data de última limpeza das placas, além de possibilitar operações de controle e limpeza automatizada.

O projeto utiliza Android Jetpack, incluindo Room, ViewModel, LiveData, e segue o padrão MVVM para garantir escalabilidade e manutenção do código.

## Recursos
- **Gerenciamento de Placas Solares**: Adicionar, atualizar e excluir informações das placas solares.
- **Monitoramento de Status**: Verificar o estado atual de cada placa solar.
- **Limpeza Automática**: Marcar placas como limpas remotamente.
- **Persistência de Dados**: Uso de Room para armazenamento local eficiente e confiável.

## Tecnologias Utilizadas
- **Kotlin**
- **Room Database**
- **MVVM Architecture**
- **Android Jetpack Components**:
  - **ViewModel**
  - **LiveData**
  - **Room**

## Configuração do Ambiente

### Pré-requisitos
Certifique-se de ter instalado:
- **Android Studio** (recomendado: versão mais recente)
- **Gradle** configurado no projeto
- **JDK 11+**

### Configuração do Projeto
Clone este repositório:
```bash
git clone https://github.com/seu-usuario/clearvolt-dashboard.git
cd clearvolt-dashboard
Abra o projeto no Android Studio. Sincronize o Gradle para baixar as dependências. Conecte um dispositivo ou emulador para testar o aplicativo.

Estrutura do Projeto
1. Banco de Dados
Configuração
O banco de dados foi implementado usando Room. Ele contém:

Entidade: PlacaSolarEntity
Representa os dados das placas solares, como nome, potência, última limpeza e status.
kotlin
Copiar código
@Entity(tableName = "placa_solar")
data class PlacaSolarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val potencia: Double,
    val ultimaLimpeza: String,
    val status: Boolean
)
DAO: PlacaSolarDao
Define as operações de CRUD:
kotlin
Copiar código
@Dao
interface PlacaSolarDao {

    @Insert
    suspend fun inserirPlaca(placaSolar: PlacaSolarEntity)

    @Update
    suspend fun atualizarPlaca(placaSolar: PlacaSolarEntity)

    @Delete
    suspend fun deletarPlaca(placaSolar: PlacaSolarEntity)

    @Query("SELECT * FROM placa_solar")
    fun listarPlacas(): LiveData<List<PlacaSolarEntity>>

    @Query("UPDATE placa_solar SET status = 1 WHERE id = :id")
    suspend fun limparPlaca(id: Int)
}
2. ViewModel
A PlacaSolarViewModel conecta o banco de dados à interface de usuário, permitindo:

Gerenciar dados em tempo real com LiveData.
Executar operações assíncronas sem bloquear a UI.
kotlin
Copiar código
class PlacaSolarViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlacaSolarRepository
    val placas: LiveData<List<PlacaSolarEntity>>

    init {
        val dao = AppDatabase.getDatabase(application).placaSolarDao()
        repository = PlacaSolarRepository(dao)
        placas = repository.allPlacas
    }

    fun inserirPlaca(placa: PlacaSolarEntity) {
        repository.insert(placa)
    }

    fun atualizarPlaca(placa: PlacaSolarEntity) {
        repository.update(placa)
    }

    fun deletarPlaca(placa: PlacaSolarEntity) {
        repository.delete(placa)
    }

    fun limparPlaca(id: Int) {
        repository.limpar(id)
    }
}
3. Repository
O PlacaSolarRepository é responsável por:

Interagir diretamente com o PlacaSolarDao.
Fornecer métodos para a ViewModel.
kotlin
Copiar código
class PlacaSolarRepository(private val placaSolarDao: PlacaSolarDao) {

    val allPlacas: LiveData<List<PlacaSolarEntity>> = placaSolarDao.listarPlacas()

    suspend fun insert(placaSolar: PlacaSolarEntity) {
        placaSolarDao.inserirPlaca(placaSolar)
    }

    suspend fun update(placaSolar: PlacaSolarEntity) {
        placaSolarDao.atualizarPlaca(placaSolar)
    }

    suspend fun delete(placaSolar: PlacaSolarEntity) {
        placaSolarDao.deletarPlaca(placaSolar)
    }

    suspend fun limpar(id: Int) {
        placaSolarDao.limparPlaca(id)
    }
}
Testes
Banco de Dados
Teste instrumentado utilizando uma instância em memória do Room.
Verifica as operações CRUD do PlacaSolarDao.
Repository
Teste unitário com mocks para validar a integração entre DAO e ViewModel.
ViewModel
Garantia de que os dados são expostos corretamente via LiveData.
Validação de chamadas assíncronas.
Contribuindo
Faça um fork do repositório.
Crie um branch para sua funcionalidade:
bash
Copiar código
git checkout -b feature/nova-funcionalidade
Commit suas alterações:
bash
Copiar código
git commit -m "Adiciona nova funcionalidade"
Envie para o branch principal:
bash
Copiar código
git push origin feature/nova-funcionalidade
Abra um Pull Request.
Licença
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais informações.
