-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 15-06-2014 a las 09:29:41
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `libreria`
--
CREATE SCHEMA IF NOT EXISTS `libreria` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `libreria` ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `ID_LIBRO` int(5) NOT NULL AUTO_INCREMENT,
  `ISBN` int(13) NOT NULL,
  `TITULO` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `AUTOR` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `CANTIDAD` int(4) NOT NULL,
  `PRECIO` int(4) NOT NULL,
  PRIMARY KEY (`ID_LIBRO`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=36 ;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`ID_LIBRO`, `ISBN`, `TITULO`, `AUTOR`, `CANTIDAD`, `PRECIO`) VALUES
(1, 111111111, 'El señor de los Anillos', 'Tolkien', 12, 20),
(2, 222222222, 'Harry Potter', 'Rowling', 20, 21),
(3, 333333333, '100000km tras los ovnis', 'Benitez', 3, 32),
(4, 444444444, 'Robots', 'Asimov', 4, 25),
(5, 555555555, 'Colmillo Blanco', 'London', 1, 42),
(6, 666666666, 'Viaje al poder de la mente', 'Punset', 7, 12),
(7, 777777777, 'Diamond', 'Stewart', 14, 6),
(8, 888888888, 'Javascript tutorial', 'Mendoza', 3, 51),
(9, 999999999, 'Python tutorial', 'Mendoza', 2, 49),
(10,892348978, 'Aprendizaje PHP', 'Mendoza', 43, 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` tinyint(4) NOT NULL,
  `USER` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `PASS` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

INSERT INTO `usuario` (`ID_USUARIO`, `TIPO`, `USER`, `PASS`) VALUES
(1, 1, 'Jorge', 1234),
(2, 0, 'Francisco', 1234);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
