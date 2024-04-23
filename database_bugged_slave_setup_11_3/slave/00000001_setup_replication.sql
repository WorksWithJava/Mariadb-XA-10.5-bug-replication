CHANGE MASTER TO
    MASTER_HOST ='mariadb-master',
    MASTER_USER ='slave_user',
    MASTER_PASSWORD ='slave_password',
    MASTER_PORT =3306,
    MASTER_CONNECT_RETRY =10;
