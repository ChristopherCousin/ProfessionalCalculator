-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-02-2019 a las 08:54:37
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `calculadora`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `Username` varchar(255) NOT NULL,
  `Log` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `log`
--

INSERT INTO `log` (`Username`, `Log`) VALUES
('admin', '(5-5) = 0.0'),
('root', '(30.0+10) = 40.0'),
('root', '(40.0--10.0) = 0.0'),
('root', '(15X25X3) = 1125.0'),
('root', '(1125.0-25) = 1100.0'),
('root', '(1100.0+1.8) = 1101.8'),
('root', '(1101.8/25555555) = 4.311391398073726E-5'),
('root', '(2) = 2'),
('root', '(25+-10.0) = 15.0'),
('root', '(15.0X5) = 75.0'),
('root', '(75.0--15.0) = 0.0'),
('root', '(5--5.0) = 0.0'),
('root', '(5-5) = 0.0'),
('root', '(55--20.0) = 0.0'),
('root', '(50--20.0) = 30.0'),
('root', '(50--20.0) = 30.0'),
('root', '(20--20.0) = 0.0'),
('root', '(50--20.0) = 0.0'),
('root', '(50--20.0) = 70.0'),
('root', '(50--60.0) = 110.0'),
('root', '(55+3) = 58.0'),
('root', '(33+33) = 66.0'),
('root', '(333+6-65.98) = 273.02'),
('root', '(50+32) = 82.0'),
('root', '(50-665) = -615.0'),
('root', '(8+6) = 2.0'),
('root', '(56-56) = 0.0'),
('root', '(55-666) = -611.0'),
('root', '(-611.0) = -611.0'),
('root', '(58-57446) = -57388.0'),
('root', '(15--5.0) = 20.0'),
('root', '(20.0+50) = 70.0'),
('root', '(70.0X2+5) = 145.0'),
('root', '(50) = 50'),
('root', '(50X2) = 100.0'),
('root', '(-100.0+50) = -50.0'),
('root', '(12X5) = 60.0'),
('root', '(60.0+52) = 112.0'),
('root', '(-112.0X2) = -224.0'),
('root', '(-224.0-200) = -424.0'),
('root', '(El 15.0% de ?100) = 15.0'),
('root', '(sqr(15.0)225.0X02.5) = 562.5'),
('root', '(562.5+-0.52) = 561.98'),
('root', '(50+-50.0) = 0.0'),
('root', '(50+-15.0002) = 34.9998'),
('root', '(-34.9998X-25.0) = 874.995');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `Username` varchar(255) NOT NULL,
  `Surname` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`Username`, `Surname`, `Email`, `Password`) VALUES
('admin', 'admin', 'admin@gmail.com', '5996978sa'),
('root', 'asd', 'root@gmail.com', 'root');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
