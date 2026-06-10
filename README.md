# Projeto Final Fabiano - FAETEC

## 🛠️ Tecnologias

- **Java** — JDK 25 (Temurin)
- **Maven** — Gerenciamento de dependências e build
- **MySQL / MariaDB** — Banco de dados relacional
- **IntelliJ IDEA** — IDE recomendada

## 📂 Estrutura do Projeto

```
├── docs/
│   ├── diagramas/
│   │   ├── der/            # Modelo Entidade-Relacionamento (PlantUML)
│   │   ├── casos-de-uso/   # Casos de uso (PlantUML)
│   │   └── classes/        # Diagrama de classes (PlantUML)
│   └── sql/
│       ├── schema.sql      # DDL — criação das tabelas
│       └── seed.sql        # DML — dados de exemplo
├── src/                    # Código Java
│   └── main/
│       └── java/com/faetec/projetofinal/
│           ├── Main.java
│           ├── model/      # Classes do domínio
│           └── ui/         # Interface com o usuário
├── pom.xml
└── ProjetoFinal_01.pdf     # Enunciado do professor
```

## 🚀 Como executar

### Pré-requisitos

- JDK 25 (Temurin) — [instalar via SDKMan](https://sdkman.io)
- MySQL ou MariaDB instalado e rodando
- IntelliJ IDEA

### Passos

1. **Clone o repositório**
   ```bash
   git clone <url-do-repositorio>
   cd ProjetoFinalFabiano
   ```

2. **Abra no IntelliJ**
   - File → Open → selecione a pasta do projeto
   - O IntelliJ detecta o `pom.xml` automaticamente
   - Clique em **"Load Changes"** quando o banner Maven aparecer

3. **Configure o banco de dados**
   - Execute `docs/sql/schema.sql` no MySQL para criar as tabelas
   - (Opcional) Execute `docs/sql/seed.sql` para dados de exemplo

4. **Execute**
   - Abra `Main.java` e clique no ícone ▶ ao lado do método `main`
   - Ou no terminal: `mvn clean compile exec:java`

## 👥 Contribuição

1. Faça `git pull` para atualizar seu repositório local
2. Crie uma branch para sua feature: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m "Descrição do que foi feito"`
4. Faça push: `git push origin minha-feature`
5. Abra um Pull Request no GitHub

## 📄 Licença

Trabalho acadêmico — uso exclusivamente educacional.