-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2024 a las 12:57:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

--SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
--START TRANSACTION;
--SET time_zone = "+00:00";


--/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
--/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
--/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
--/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cul_ampolla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clients`
--

CREATE TABLE `clients` (
  `ClientID` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `CorreuElectrònic` varchar(255) DEFAULT NULL,
  `DataRegistre` datetime DEFAULT NULL,
  `ClientRecomanadorID` int(11) DEFAULT NULL,
  `DireccionID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direcciones`
--

CREATE TABLE `direcciones` (
  `DireccionID` int(11) NOT NULL,
  `Calle` varchar(255) NOT NULL,
  `Numero` varchar(10) NOT NULL,
  `Piso` varchar(10) DEFAULT NULL,
  `Puerta` varchar(10) DEFAULT NULL,
  `Ciudad` varchar(100) NOT NULL,
  `CP` varchar(10) NOT NULL,
  `Pais` varchar(100) NOT NULL,
  `Telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleats`
--

CREATE TABLE `empleats` (
  `EmpleatID` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `CorreuElectrònic` varchar(255) NOT NULL,
  `DataContracte` date DEFAULT NULL,
  `DireccionID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `MarcaID` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `ProveedorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `ProveedorID` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Fax` varchar(20) DEFAULT NULL,
  `NIF` varchar(20) NOT NULL,
  `DireccionID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ulleres`
--

CREATE TABLE `ulleres` (
  `UlleresID` int(11) NOT NULL,
  `MarcaID` int(11) DEFAULT NULL,
  `GraduacioI` varchar(50) DEFAULT NULL,
  `GraduacioD` varchar(50) DEFAULT NULL,
  `TipusMuntura` enum('Flotant','Pasta','Metàl·lica') DEFAULT NULL,
  `ColorMuntura` varchar(50) DEFAULT NULL,
  `ColorVidre` varchar(50) DEFAULT NULL,
  `Preu` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `VentaID` int(11) NOT NULL,
  `ClientID` int(11) DEFAULT NULL,
  `UlleresID` int(11) DEFAULT NULL,
  `FechaVenta` date DEFAULT NULL,
  `Importe` decimal(10,2) DEFAULT NULL,
  `VendedorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ClientID`),
  ADD KEY `ClientRecomanadorID` (`ClientRecomanadorID`),
  ADD KEY `DireccionID` (`DireccionID`);

--
-- Indices de la tabla `direcciones`
--
ALTER TABLE `direcciones`
  ADD PRIMARY KEY (`DireccionID`);

--
-- Indices de la tabla `empleats`
--
ALTER TABLE `empleats`
  ADD PRIMARY KEY (`EmpleatID`),
  ADD KEY `DireccionID` (`DireccionID`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`MarcaID`),
  ADD KEY `ProveedorID` (`ProveedorID`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`ProveedorID`),
  ADD UNIQUE KEY `NIF` (`NIF`),
  ADD KEY `DireccionID` (`DireccionID`);

--
-- Indices de la tabla `ulleres`
--
ALTER TABLE `ulleres`
  ADD PRIMARY KEY (`UlleresID`),
  ADD KEY `MarcaID` (`MarcaID`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`VentaID`),
  ADD KEY `ClientID` (`ClientID`),
  ADD KEY `UlleresID` (`UlleresID`),
  ADD KEY `VendedorID` (`VendedorID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clients`
--
ALTER TABLE `clients`
  MODIFY `ClientID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `direcciones`
--
ALTER TABLE `direcciones`
  MODIFY `DireccionID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleats`
--
ALTER TABLE `empleats`
  MODIFY `EmpleatID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `MarcaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `ProveedorID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ulleres`
--
ALTER TABLE `ulleres`
  MODIFY `UlleresID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `VentaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`ClientRecomanadorID`) REFERENCES `clients` (`ClientID`),
  ADD CONSTRAINT `clients_ibfk_2` FOREIGN KEY (`DireccionID`) REFERENCES `direcciones` (`DireccionID`);

--
-- Filtros para la tabla `empleats`
--
ALTER TABLE `empleats`
  ADD CONSTRAINT `empleats_ibfk_1` FOREIGN KEY (`DireccionID`) REFERENCES `direcciones` (`DireccionID`);

--
-- Filtros para la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD CONSTRAINT `marcas_ibfk_1` FOREIGN KEY (`ProveedorID`) REFERENCES `proveedores` (`ProveedorID`);

--
-- Filtros para la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD CONSTRAINT `proveedores_ibfk_1` FOREIGN KEY (`DireccionID`) REFERENCES `direcciones` (`DireccionID`);

--
-- Filtros para la tabla `ulleres`
--
ALTER TABLE `ulleres`
  ADD CONSTRAINT `ulleres_ibfk_1` FOREIGN KEY (`MarcaID`) REFERENCES `marcas` (`MarcaID`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `clients` (`ClientID`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`UlleresID`) REFERENCES `ulleres` (`UlleresID`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`VendedorID`) REFERENCES `empleats` (`EmpleatID`);
COMMIT;

--/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
--/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
--/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
