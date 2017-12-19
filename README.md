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

- For quick testing you can directly index document using following url command

```
POST http://localhost:9200/test/user/_bulk
{"index": {"_id": 14}}
{"age": 21,"name": "Shubham 123"}
{"index": {"_id": 15}}
{"age": 21,"name": "Zbham .2"}
{"index": {"_id": 16}}
{"age": 21,"name": "bham .2"}
{"index": {"_id": 17}}
{"age": 21,"name": "Shubham"}
{"index": {"_id": 18}}
{"age": 21,"name": "Shubhaz"}
{"index": {"_id": 19}}
{"age": 21,"name": "Zbham"}
{"index": {"_id": 20}}
{"age": 21,"name": "Shubham .2"}
{"index": {"_id": 21}}
{"age": 21,"name": "Z.bham .2"}
{"index": {"_id": 22}}
{"age": 21,"name": "b.ham .2"}
{"index": {"_id": 23}}
{"age": 21,"name": "Sh.ubham"}
{"index": {"_id": 24}}
{"age": 21,"name": "Shu.bhaz"}
{"index": {"_id": 25}}
{"age": 21,"name": "Zbh.am"}
{"index": {"_id": 26}}
{"age": 21,"name": "bh.am .2"}
{"index": {"_id": 27}}
{"age": 21,"name": "Z'bham .2"}
{"index": {"_id": 28}}
{"age": 21,"name": "Z/bham .2"}
{"index": {"_id": 29}}
{"age": 21,"name": "Z$bham .2"}
{"index": {"_id": 30}}
{"age": 21,"name": "Z(bham .2"}
{"index": {"_id": 31}}
{"age": 21,"name": "Z)bham .2"}
```

### Endpoints

- POST `/users/` with following request body to create a new document on elasticsearch

```json
{"age": 21,"name": "Z)bham .2"}
```

- GET `/users/search?freeText=so` to search in the existing documents on elasticsearch.
- Default it'll sort on the user's name field. 

### Config

- You can check the mapping & setting in `src/main/resources/mappings` & `src/main/resources/settings` directory