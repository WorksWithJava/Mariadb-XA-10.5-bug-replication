FROM mariadb:11.3

COPY ./00000001_create_schema.sql /docker-entrypoint-initdb.d
COPY ./00000002_create_replication_user.sql /docker-entrypoint-initdb.d

COPY ./master.cnf /etc/mysql/conf.d
