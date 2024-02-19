FROM postgres
COPY acme.sql /docker-entrypoint-initdb.d/
