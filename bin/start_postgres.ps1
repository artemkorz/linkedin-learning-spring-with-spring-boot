#https://www.postgresql.org/docs/current/libpq-envars.html - Environment Variables for auto connecting and executing script
#https://www.postgresql.org/docs/current/libpq-pgpass.html - Password configuration file

$ErrorActionPreference = 'SilentlyContinue'

mkdir -p $HOME/docker/volumes/postgres
rm -rf $HOME/docker/volumes/postgres/data
docker run --rm --name pg-docker -e POSTGRES_PASSWORD = postgres -e POSTGRES_DB = dev -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql postgres
$env:PGPASSWORD='postgres'
psql -U postgres -d dev -h localhost -f schema.sql
psql -U postgres -d dev -h localhost -f data.sql