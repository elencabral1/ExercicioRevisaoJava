<h1> Aplicação IASI </h1>

<h2>Integrantes:</h2>

<p>Caio Ribeiro Rodrigues - RM: 99759</p>
<p>Eduardo Jablinski - RM: 550975</p>
<p>Elen Cabral - RM: 98790</p>
<p>Guilherme Riofrio Quaglio - RM: 550137</p>
<p>Mary Speranzini - RM: 550242</p>

<h2>Descrição</h2>
<p>Nessa aplicação Java utilizamos a IDE IntelliJ, construímos a arquitetura de um programa de gerenciamento de 
produtos para uma empresa que fabrica brinquedos infantis. Ela é capaz de realizar operações 
básicas de CRUD (Create, Read, Update, Delete) sobre uma base de dados Oracle que 
compreende a proposta requisitada, possui endpoints configurados para receber requisições 
HTTP, que foram testados posteriormente utilizando o software Insomnia, e realiza a consulta 
na tabela TDS_TB_Brinquedos no banco de dados Oracle_FIAP utilizando o SQL Developer. 
Adicionamos também as bibliotecas Lombok, para simplificar a criação de código, e HATEOAS, para facilitar a implementação de links de navegação entre os recursos na API.</p>

<h2>Link do versionamento</h2>
<p>https://exerciciorevisaojava.onrender.com</p>

<h2>Funcionalidades</h2>
<ul>
    <li>Criar: Adicionar novos brinquedos ao sistema.</li>
    <li>Ler: Recuperar informações sobre brinquedos, incluindo detalhes como nome, tipo, classificação, tamanho e preço.</li>
    <li>Atualizar: Modificar informações de brinquedos existentes.</li>
    <li>Deletar: Remover brinquedos do sistema.</li>
</ul>

<h2>Configuração do Spring Initializer e dependências</h2>

<img src="https://github.com/user-attachments/assets/c471b26d-9ed4-49f1-ad22-db9740fa52cc" alt="springInitializer" width="500"/><br><br>
<img src="https://github.com/user-attachments/assets/8393ab13-d660-4d28-bfd9-90f913332569" alt="dependencies" width="400"/><br><br>

<h2>Listagem de todos os endpoints</h2>
<img src="https://github.com/user-attachments/assets/41500aa3-182c-47a6-96f3-8a66f1049523" alt="endpoints" width="500"/><br><br>

<h3>Requisição GET /api/brinquedos</h3>
<p>Método: GET<br>
URL: /api/brinquedos<br>
Requisição: Nenhuma<br>
Resposta: Lista de todos os brinquedos cadastrados no sistema.</p>
<img src="https://github.com/user-attachments/assets/08492093-3043-4f2c-b9a7-9bb81826bd46" alt="getAll" width="500"/><br><br>
<img src="https://github.com/user-attachments/assets/e495207c-4cc0-483b-ae50-6df2b4b85e21" alt="getAll" width="500"/><br><br>

<h3>Requisição GET /api/brinquedos/{id}</h3>
<p>Método: GET<br>
URL: /api/brinquedos/{id}<br>
Requisição: Nenhuma<br>
Resposta: Informações do brinquedo com o ID especificado.</p>
<img src="https://github.com/user-attachments/assets/fa69b9e4-775d-4509-b76b-1670a6606103" alt="getId" width="500"/><br><br>
<img src="https://github.com/user-attachments/assets/06cbefa3-daff-449e-8d64-8c1360fcaa7f" alt="getId" width="500"/><br><br>

<h3>Requisição POST /api/brinquedos</h3>
<p>Método: POST<br>
URL: /api/brinquedos<br>
Requisição: Novo brinquedo a ser adicionado ao sistema, em formato JSON.<br>
<img src="https://github.com/user-attachments/assets/24a0dd4d-b9d8-4ad4-810d-96684d2dc64f" alt="create" width="500"/><br><br>

<h3>Requisição PUT /api/brinquedos/{id}</h3>
<p>Método: PUT<br>
URL: /api/brinquedos/{id}<br>
Requisição: Atualização de brinquedo no sistema, em formato JSON.<br>
<img src="https://github.com/user-attachments/assets/b2038f65-e425-4a78-9065-a704bf1669a4" alt="update" width="500"/><br><br>

<h3>Requisição DELETE /api/brinquedos/{id}</h3>
<p>Método: DELETE<br>
URL: /api/brinquedos/{id}<br>
Requisição: Nenhuma<br>
Resposta: Nenhuma</p>
<img src="https://github.com/user-attachments/assets/9b187207-0091-4171-9565-ed71e890ba49" alt="delete" width="500"/><br><br>

