CREATE SCHEMA srcschema;

USE srcschema;

CREATE TABLE `srctable`
(
    `srcidentity` int(11) NOT NULL,
    `srcnumber`   int(11) NOT NULL,
    PRIMARY KEY (`srcidentity`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;

CREATE SCHEMA junkschema;

USE junkschema;

CREATE TABLE `junkschema`
(
    `srcidentity` int(11) NOT NULL,
    `srcnumber`   int(11) NOT NULL,
    PRIMARY KEY (`srcidentity`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci
