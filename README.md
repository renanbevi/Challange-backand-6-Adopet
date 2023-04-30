Alura Challenge Back End #6
API REST desenvolvida durante o Challenge Back End #6 da Alura.

A API está disponível em:

Em breve o Deploy.

Considerações
Neste desafio utilizei Java em conjunto com Spring boot e banco de dados Mysql

Funcionalidades
Essa API implementa as seguintes especificações:

Rotas no padrão REST.
Validações feitas conforme as regras de negócio do challenge Back-and 6
Banco de dados para a persistência de informações.
Autenticação via JWT.
Rotas implementadas
rotas de autenticação /login todas as rotas são protegidas. Para acessa-las é necessário em cada request enviar um token de autenticação no header:

{'Authorization': 'token'}

Para obter esse token basta acessar a rota /login enviando no body da requisição das credenciais de um usuário cadastrado no sistema:

{
    'username': 'renanbevi@gmail.com',
    'password': '123456'
}
Essa rota fornecerá uma mensagem se o login foi efetuado com sucesso ou não e um token válido por 60 segundos. Após esse tempo é necessário obter um novo token.

Para cadastrar um Tutor novo , semelhante a etapa de login, deve-se enviar as credenciais de um novo usuário para a rota POST /tutores, nesse instante já receberá um token válido.

Rotas do projeto
Method	Route	Body Param.	Response.
GET	/videos/free	-	-
POST	/auth/register	{'username', 'password'}	{'message', 'token'}
POST	/auth/login	{'username', 'password'}	{'message', 'token'}
Rotas Protegidas
Method	Route	Body Param.	Query Param.
GET	/videos	-	-
GET	/videos/?search={title}	-	título do vídeo
GET	/videos/{id}	-	id do vídeo
POST	/videos	{'title', 'description', 'url', 'category_id'}	-
PUT	/videos/{id}	{'title', 'description', 'url', 'category_id'}	id do vídeo
PATCH	/videos/{id}	{'title', 'description', 'url', 'category_id'}	id do vídeo
DELETE	/videos/{id}	-	id do vídeo
GET	/categories	-	-
GET	/categories/{id}	-	id da categoria
POST	/categories	{'title', 'color'}	-
PUT	/categories/{id}	{'title', 'color'}	id da categoria
PATCH	/categories/{id}	{'title', 'color'}	id da categoria
DELETE	/categories/{id}	-	id da categoria
Pré-requisitos
Python 3.10.8
Flask 2.2.2
SQLite (Caso queira mudar o sgbd, basta trocar as credenciais no SQLAlchemy)
Principais Bibliotecas
Flask	
Flask SQLAlchemy	Modelos e buscar no Banco de Dados
Flask Migrate	Migrações no Banco de Dados
Flask Marshmalow	Serialização e Validação de JSON
Python dotenv	Lidar com variáveis de ambiente
Pytest	Testes automatizados
Como rodar a aplicação
Variáveis de Ambiente


SQLALCHEMY_DATABASE_URI = Conexão com o banco de dados.

SECRET_KEY = Necessário para autenticação via JWT.

Configuração do ambiente e instalação de dependências
Após baixar e entrar na raiz do projeto, crie um ambiente virtual e ative-o:


Cronograma
Semana 1
 Criação da API CRUD tutor, pets, abrigos
 Integração com o banco de dados MYSQL
 
Semana 2
 Criação do CRUD Adoção
 Regras de negócios para adoção de pet
Semana 3 e 4
 Paginação
 Autenticação
 Deploy 
 
 Instrutores do challenge: Camila Pessôa e Emerson Laranja.
 Com a ajuda do professor: Rodrigo da Silva Ferreira
