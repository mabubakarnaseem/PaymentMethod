CREATE TABLE IF NOT EXISTS `payment_methods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `display_name` varchar(150) DEFAULT NULL,
  `payment_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `payment_plans` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `net_amount` float DEFAULT 0,
  `tax_amount` float DEFAULT 0,
  `gross_amount` float DEFAULT 0,
  `currency` varchar(150) DEFAULT NULL,
  `duration` varchar(50) DEFAULT NULL,
  `pm_fk` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (pm_fk) REFERENCES payment_methods(id)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;



