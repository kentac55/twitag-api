# Twitag API

## Build

```bash
sbt dist
```

## Docker build

```bash
sbt docker:publishLocal
docker run --rm -p 9000:9000 twitag-api:1.0-SNAPSHOT
```

## OAS

```bash
docker run --rm -p 9000:9000 twitag-api:1.0-SNAPSHOT
curl localhost:9000/assets/swagger.json
```

### w/ viewer

access to `http://localhost:9000/docs/swagger-ui/index.html?url=/assets/swagger.json#/`

## test

```bash
sbt test
```
