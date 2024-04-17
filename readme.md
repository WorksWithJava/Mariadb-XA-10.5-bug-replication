# Mariadb XA 10.5 bug replication

This project replicates a bug in the replication feature of Mariadb 10.5 when XA transactions are involved.

This program will insert a row in the database then send a message to an in-memory ActiveMQ 5 broker.

## Regarding the bug

This bug only seems to happen if the following conditions are true:

- More than one participant is present in the XA transaction
- `replicate_do_db` is present on the slave
- A schema outside of `replicate_do_db` is touched either because:
  - DML statements are executed with a schema selected that is not listed in `replicate_do_db`
including none (e.g. `jdbc:mariadb://localhost:3306` or `jdbc:mariadb://localhost:3306/junkschema`
vs `jdbc:mariadb://localhost:3306/srcschema`)
  - DML statements are executed on a schema outside of those listed in `replicate_do_db`

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
