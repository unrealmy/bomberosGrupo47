-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2023 a las 21:45:35
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bomberos47`
--
CREATE DATABASE IF NOT EXISTS `bomberos47` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bomberos47`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

CREATE TABLE `bombero` (
  `idBombero` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `NombreApellido` varchar(50) NOT NULL,
  `FechaNac` date NOT NULL,
  `Celular` varchar(20) NOT NULL,
  `grupoSanguineo` varchar(30) NOT NULL,
  `CodBrigada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`idBombero`, `dni`, `NombreApellido`, `FechaNac`, `Celular`, `grupoSanguineo`, `CodBrigada`) VALUES
(1, 123, 'llama sakaa', '1990-04-23', '123', 'A-', 5),
(2, 12313, 'voluntario a ', '2017-10-11', '123123', 'AB', 5),
(4, 1413412, 'voluntario c', '2016-10-12', '14124', 'AB', 5),
(5, 1414414, 'd', '2012-10-16', '12312', 'AB', 5),
(6, 123, 'z', '2023-10-02', '123', 'AB', 5),
(7, 124441, 'f', '2015-10-15', '123', 'AB', 5),
(8, 123, 'eqqe', '2015-10-01', '123', 'AB', 5),
(10, 54321, 'bomber   ito', '1999-10-06', '111444', 'AB', 4),
(12, 544321, 'onfire', '1998-10-08', '333123', 'AB', 4),
(13, 440055, 'salvador dali', '1975-10-16', '13132', 'O', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

CREATE TABLE `brigada` (
  `CodBrigada` int(11) NOT NULL,
  `NombreBr` varchar(30) NOT NULL,
  `Especialidad` varchar(40) NOT NULL,
  `Libre` tinyint(4) NOT NULL,
  `NroCuartel` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`CodBrigada`, `NombreBr`, `Especialidad`, `Libre`, `NroCuartel`, `estado`) VALUES
(0, 'no asignada', 'null', 0, 1, 1),
(1, 'delta', 'rescates en montaña', 1, 1, 1),
(3, 'alfa', 'incendios', 1, 1, 1),
(4, 'alfa', 'accidentes de tráfico', 1, 1, 1),
(5, 'alfa2', 'inundaciones', 1, 1, 1),
(10, 'omega', 'salvamento', 1, 3, 1),
(11, 'delta', 'salvamento', 1, 3, 1),
(12, 'alfa2', 'salvamento', 0, 4, 1),
(13, 'qqqqq', 'accidentes de tráfico', 1, 3, 0),
(14, 'omega1', 'prevención', 1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `CodCuartel` int(11) NOT NULL,
  `NombreCuartel` varchar(30) NOT NULL,
  `Direccion` varchar(30) NOT NULL,
  `CoorX` int(11) NOT NULL,
  `CoorY` int(11) NOT NULL,
  `Telefono` varchar(30) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`CodCuartel`, `NombreCuartel`, `Direccion`, `CoorX`, `CoorY`, `Telefono`, `Correo`, `estado`) VALUES
(1, 'llamaMoto', 'falsa123', 143, 96, '1303456', 'llama@hotmail.com', 1),
(3, 'flama', '911', 212, 33, '432', 'xb@', 1),
(4, '9 de julio', 'calle 13', 131, 54, '233123', 'yahoo@hotmail.com', 1),
(5, 'wwewwe', 'calle', 115, 158, '1233232', 'e', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `Codigo` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `FechaSiniestro` date NOT NULL,
  `CoordX` int(11) NOT NULL,
  `CoordY` int(11) NOT NULL,
  `Detalles` text NOT NULL,
  `FechaResol` date NOT NULL,
  `Puntuacion` int(11) NOT NULL,
  `CodBrigada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `siniestro`
--

INSERT INTO `siniestro` (`Codigo`, `tipo`, `FechaSiniestro`, `CoordX`, `CoordY`, `Detalles`, `FechaResol`, `Puntuacion`, `CodBrigada`) VALUES
(2, 'salvamento', '2022-04-23', 147, 61, 'de dolares  j11', '2022-04-23', 7, 5),
(3, 'incendios', '2023-10-11', 123, 12, 'asdasd', '2023-10-12', 12, 1),
(4, 'incendios', '2023-10-12', 123, 12, 'asdasd', '2023-10-11', 12, 1),
(5, 'rescates en montaña', '2023-10-11', 123, 12, 'asdasd', '0000-00-00', 12, 1),
(6, 'rescates en montaña', '2023-10-12', 190, 109, 'desprendimiento', '2023-10-08', 12, 1),
(13, 'inundaciones', '2023-10-13', 2, 3, 'sfd', '2023-10-12', 2, 1),
(14, 'inundaciones', '2023-10-05', 70, 145, 'eewrasd', '2023-10-05', 2, 1),
(15, 'accidentes de tráfico', '2023-10-20', 2, 2, 'sdfjkhkjh', '2023-10-07', 2, 4),
(16, 'salvamento', '2023-10-24', 153, 70, 'eeee', '0000-00-00', 0, 10),
(17, 'salvamento', '2023-10-24', 194, 36, 'eeesdfsdf', '0000-00-00', 0, 12),
(18, 'inundaciones', '2023-10-17', 226, 44, 'masda', '0000-00-00', 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`idBombero`),
  ADD KEY `CodBrigada` (`CodBrigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`CodBrigada`),
  ADD KEY `NroCuartel` (`NroCuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`CodCuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `siniestro_ibfk_1` (`CodBrigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `idBombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `CodBrigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `CodCuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `Codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`CodBrigada`) REFERENCES `brigada` (`CodBrigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`NroCuartel`) REFERENCES `cuartel` (`CodCuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`CodBrigada`) REFERENCES `brigada` (`CodBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
