SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `apdb` DEFAULT CHARACTER SET utf8 ;
USE `apdb` ;

-- -----------------------------------------------------
-- Table `apdb`.`campaigns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apdb`.`campaigns` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `access` INT(11) NOT NULL,
  `rpg_type` VARCHAR(45) NOT NULL,
  `description` VARCHAR(600) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `apdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apdb`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `incorrect_login` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `apdb`.`characters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apdb`.`characters` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(600) NOT NULL,
  `class` VARCHAR(45) NOT NULL,
  `race` VARCHAR(45) NOT NULL,
  `level` INT(11) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `users_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  INDEX `fk_characters_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_characters_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `apdb`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `apdb`.`episodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apdb`.`episodes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(600) NOT NULL,
  `date` DATETIME NULL DEFAULT NULL,
  `order_number` INT(11) NOT NULL,
  `campaigns_id` INT(11) NOT NULL,
  `users_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `campaigns_id`),
  INDEX `fk_episodes_campaigns1_idx` (`campaigns_id` ASC),
  INDEX `fk_episodes_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_episodes_campaigns1`
    FOREIGN KEY (`campaigns_id`)
    REFERENCES `apdb`.`campaigns` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_episodes_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `apdb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `apdb`.`characters_has_episodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apdb`.`characters_has_episodes` (
  `characters_id` INT(11) NOT NULL,
  `episodes_id` INT(11) NOT NULL,
  PRIMARY KEY (`characters_id`, `episodes_id`),
  INDEX `fk_characters_has_episodes_episodes1_idx` (`episodes_id` ASC),
  INDEX `fk_characters_has_episodes_characters_idx` (`characters_id` ASC),
  CONSTRAINT `fk_characters_has_episodes_characters`
    FOREIGN KEY (`characters_id`)
    REFERENCES `apdb`.`characters` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_characters_has_episodes_episodes1`
    FOREIGN KEY (`episodes_id`)
    REFERENCES `apdb`.`episodes` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `apdb`.`users_has_campaigns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apdb`.`users_has_campaigns` (
  `users_id` INT(11) NOT NULL,
  `campaigns_id` INT(11) NOT NULL,
  `role` INT(11) NOT NULL,
  PRIMARY KEY (`users_id`, `campaigns_id`),
  INDEX `fk_users_has_campaigns_campaigns1_idx` (`campaigns_id` ASC),
  CONSTRAINT `fk_users_has_campaigns_campaigns1`
    FOREIGN KEY (`campaigns_id`)
    REFERENCES `apdb`.`campaigns` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_campaigns_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `apdb`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
