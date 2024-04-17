XA START 'testtx1';
USE junkschema;
INSERT INTO srcschema.srctable (srcidentity,srcnumber) VALUES (2,2);
XA END 'testtx1';
XA PREPARE 'testtx1';
XA COMMIT 'testtx1';
