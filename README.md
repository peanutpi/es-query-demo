### Description

- This repo is for a demo regarding querying & sorting for an elasticsearch index.

#### Versions

- Elasticsearch : 2.4.6
- Spring boot : 1.5.9.RELEASE

#### setup

- Start elsticsearch
- you can use docker-compose for quick setup if you've docker & docker-compose setup already
- from the project root directory run following command

```
docker-compose up -d
```

- check that elasticsearch is started by accessing `http://localhost:9200/`
- Open sense using `http://localhost:5601/app/sense`

- Start the server using following command

```
mvn clean spring-boot:run
```

- after the server is started successfully you'll be able to see a index in elasticsearch `test` with type `user`

### Endpoints

- POST `/users/` with following request body to create a new document on elasticsearch

```json
{"age": 21,"name": "Z)bham .2"}
```

- GET `/users/search?freeText=so` to search in the existing documents on elasticsearch.
- Default it'll sort on the user's name field. 

### Config

- You can check the mapping & setting in `src/main/resources/mappings` & `src/main/resources/settings` directory