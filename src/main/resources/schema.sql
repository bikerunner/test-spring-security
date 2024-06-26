CREATE TABLE IF NOT EXISTS `users`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `enabled`  INT         NOT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `authorities`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `username`  VARCHAR(45) NOT NULL,
    `authority` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `authorities`(`username`, `authority`)
VALUES ('john', 'write');

INSERT INTO `users`(`username`, `password`, `enabled`)
VALUES ('john', '12345', '1');