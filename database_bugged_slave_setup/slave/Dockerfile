FROM mariadb:10.5

COPY ./00000001_setup_replication.sql /docker-entrypoint-initdb.d

COPY ./slave.cnf /etc/mysql/conf.d
