# Projeto-Pratica_Profissional-ADS-Backend

### Sobre

Projeto de prática profissional ADS 5 Semestre Mackenzie

Backend em Java utilizando JDBC e MySQL

##### Integrantes
* Carlos Rodrigues de Oliveira
* Daniel do Rosário Rocha
* Jose luiz Gonçalves
* Paulo Batista De Oliveira 

---
### Git

#### Fluxo
- Acesar via terminal/CmDer a pasta do projeto.

- Acessar a branch **develop**
```
$ git checkout develop
```

- Criar uma branch nova com seu nome
```
$ git checkout -b develop-<nome>
```

- Incluir / alterar arquivos na pasta do projeto.

- Verificar quais e se os arquivos na pasta do projeto foram alterados.
```
$ git status
```

- Adicionar o pacote, fazer o commit com o comentario sobre as alterações e subir as alterações para repositório remoto
```
$ git add .
$ git commit -m "desricao resumida da alteracao"
$ git push origin develop-<nome>
```

- Após esses passos, Solicitar Pull Request pelo site do git para a branch **develop**


#### Comandos úteis

- Verificar status do repositório local (apenas sobre a branch atual)
```
$ git status
```

- Adicionar arquivos ao pacote para commitar e subir pararepositório remoto
  - Adiciona somente um arquivo
```
$ git add <nome do arquivo>
```
  - Adiciona todos os arquivos modificados
```
$ git 
```

- Commitar pacote
```
$ git commit -m "desricao resumida da alteracao"
```

#### CUIDADO COM OS COMANDOS A SEGUIR

- excluir branch local
```
$ git remote -d <nome da branch>
```

- Remover mudanças no repositorio local
```
$ git checkout .
```

- Remover mudanças depois do add
```
$ git reset <nome do arquivo>
```

- Remover commit local antes de subir para repositório remoto
```
$ git reset HEAD~1
```


---
### Links

[Trello](https://trello.com/b/erxcpe1q)

[Documentação](https://github.com/DanielRRocha/Projeto-Pratica_Profissional-ADS-Documentacao)

[Backend](https://github.com/DanielRRocha/Projeto-Pratica_Profissional-ADS-Backend)

[Frontend](https://github.com/DanielRRocha/Projeto-Pratica_Profissional-ADS-Frontend)