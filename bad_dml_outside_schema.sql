XA START 'testtx1';
USE junkschema;
INSERT INTO junkschema.junktable (srcidentity,srcnumber) VALUES (1,1);
XA END 'testtx1';
XA PREPARE 'testtx1';
XA COMMIT 'testtx1';
