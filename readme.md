# Mariadb XA >= 10.5 bug replication

This project replicates a bug in the replication feature of Mariadb >= 10.5 when XA transactions are involved.

## Regarding the bug

This bug only seems to happen if the following conditions are true:

- `replicate_do_db` is present on the slave
- A schema outside of `replicate_do_db` is touched either because:
  - DML statements are executed with a schema selected that is not listed in `replicate_do_db`
including none (e.g. `jdbc:mariadb://localhost:3306` or `jdbc:mariadb://localhost:3306/junkschema`
vs `jdbc:mariadb://localhost:3306/srcschema`)
  - DML statements are executed on a schema outside of those listed in `replicate_do_db`

## How to run:

### Start Docker
Execute the following commands inside the `./database_bugged_slave_setup` directory:
```bash
docker-compose down --volumes
docker-compose up --build
```

### Run test script
Then run any of the sql script starting with bad_ on the master to crash replication. Repeat the
"[start docker](#start-docker)" step afterward to return to a clean slate.

#### DML outside replicate_do_db
[bad_dml_outside_schema.sql](bad_dml_outside_schema.sql)
```bash
mariadb --user=root --password=master --host=localhost --port=3306 < bad_dml_outside_schema.sql 
```

#### No USE statement
[bad_no_use.sql](bad_no_use.sql)
```bash
mariadb --user=root --password=master --host=localhost --port=3306 < bad_no_use.sql
```

#### USE statement outside of replicate_do_db but DML inside
[bad_use_outside_schema.sql](bad_use_outside_schema.sql)
```bash
mariadb --user=root --password=master --host=localhost --port=3306 < bad_use_outside_schema.sql
```

### Control
A good_ script is provided for control purpose.
[good_use_inside_schema.sql](good_use_inside_schema.sql)
```bash
mariadb --user=root --password=master --host=localhost --port=3306 < good_use_inside_schema.sql
```
A setup without `replicate_do_db` is also provided under `database_ok_slave_setup`.
