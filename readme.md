# Mariadb XA 10.5 bug replication

This project replicates a bug in the replication feature of Mariadb 10.5 when XA transactions are involved.

This program will insert a row in the database then send a message to an in-memory ActiveMQ 5 broker.

## Regarding the bug

This bug only seems to happen if the following conditions are true:

- `replicate_do_db` is present on the slave
- DML statements are executed without a database selected (e.g. `jdbc:mariadb://localhost:3306` vs `jdbc:mariadb://localhost:3306/srcschema`)

## Prerequisites:

In order to run this project, the following are needed:
- Java JDK 11
- Maven 3

## How to run:

Execute the following commands inside the `./database_bugged_slave_setup` directory:
```bash
sudo docker-compose down --volumes
sudo docker-compose up --build
```

Then start the project using the following commands:
```bash
mvn clean package
java -jar ./target/xa_stress_tester.jar --spring.profiles.active=insert
```

There is a secondary Spring boot profile for delete instead of inserts:
```bash
# mvn clean package
java -jar ./target/xa_stress_tester.jar --spring.profiles.active=delete
```
It is designed to be run in parallel to the insert script.
