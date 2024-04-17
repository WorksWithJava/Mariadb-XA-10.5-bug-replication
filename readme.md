# Mariadb XA 10.5 bug replication

This project replicates a bug in the replication feature of Mariadb 10.5 when XA transactions are involved.

## Regarding the bug

This bug only seems to happen if the following conditions are true:

- `replicate_do_db` is present on the slave
- A schema outside of `replicate_do_db` is touched either because:
  - DML statements are executed with a schema selected that is not listed in `replicate_do_db`
including none (e.g. `jdbc:mariadb://localhost:3306` or `jdbc:mariadb://localhost:3306/junkschema`
vs `jdbc:mariadb://localhost:3306/srcschema`)
  - DML statements are executed on a schema outside of those listed in `replicate_do_db`

## How to run:

Execute the following commands inside the `./database_bugged_slave_setup` directory:
```bash
sudo docker-compose down --volumes
sudo docker-compose up --build
```

Then run any of the sql script starting with bad_ to crash replication. A good_ script is provided
for control purpose.
