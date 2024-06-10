-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2024 a las 16:07:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spotify`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `albumes`
--

CREATE TABLE `albumes` (
  `id_album` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `publicacion` datetime DEFAULT NULL,
  `portada` blob DEFAULT NULL,
  `id_artista` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE `artistas` (
  `id_artista` int(11) NOT NULL,
  `nombre` varchar(55) NOT NULL,
  `imagen` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas_relacionados`
--

CREATE TABLE `artistas_relacionados` (
  `id_artista_principal` int(11) NOT NULL,
  `id_artista_relacionado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canciones`
--

CREATE TABLE `canciones` (
  `id_cancion` int(11) NOT NULL,
  `titulo` varchar(55) NOT NULL,
  `duracion` time NOT NULL,
  `reproducciones` int(11) DEFAULT 0,
  `id_album` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favoritos`
--

CREATE TABLE `favoritos` (
  `id_usuario` int(11) NOT NULL,
  `id_album` int(11) NOT NULL,
  `id_cancion` int(11) NOT NULL,
  `tipo_favorito` enum('album','cancion') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id_pago` int(11) NOT NULL,
  `id_suscripcion` int(11) DEFAULT NULL,
  `fecha_pago` date NOT NULL,
  `factura` varchar(55) DEFAULT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlists`
--

CREATE TABLE `playlists` (
  `id_playlist` int(11) NOT NULL,
  `titulo` varchar(55) NOT NULL,
  `total_canciones` int(11) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `estado` enum('activo','eliminado') NOT NULL,
  `fecha_eliminacion` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlists_compartidas`
--

CREATE TABLE `playlists_compartidas` (
  `id_cancion` int(11) NOT NULL,
  `id_playlist` int(11) NOT NULL,
  `id_usuario_agrega` int(11) DEFAULT NULL,
  `fecha_agregado` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguimiento_artistas`
--

CREATE TABLE `seguimiento_artistas` (
  `id_usuario` int(11) NOT NULL,
  `id_artista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripciones`
--

CREATE TABLE `suscripciones` (
  `id_suscripcion` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_renovacion` date NOT NULL,
  `forma_pago` enum('tarjeta_credito','paypal') NOT NULL,
  `numero_tarjeta` varchar(16) DEFAULT NULL,
  `mes_caducidad` int(11) DEFAULT NULL,
  `anyo_caducidad` int(11) DEFAULT NULL,
  `ccv` int(11) DEFAULT NULL,
  `usuario_paypal` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `email` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` enum('M','F','O') NOT NULL,
  `pais` varchar(50) NOT NULL,
  `cp` varchar(10) NOT NULL,
  `tipo` enum('free','premium') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `albumes`
--
ALTER TABLE `albumes`
  ADD PRIMARY KEY (`id_album`),
  ADD KEY `id_artista` (`id_artista`);

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`id_artista`);

--
-- Indices de la tabla `artistas_relacionados`
--
ALTER TABLE `artistas_relacionados`
  ADD PRIMARY KEY (`id_artista_principal`,`id_artista_relacionado`),
  ADD KEY `id_artista_relacionado` (`id_artista_relacionado`);

--
-- Indices de la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`id_cancion`),
  ADD KEY `id_album` (`id_album`);

--
-- Indices de la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD PRIMARY KEY (`id_usuario`,`id_album`,`id_cancion`),
  ADD KEY `id_album` (`id_album`),
  ADD KEY `id_cancion` (`id_cancion`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`id_pago`),
  ADD UNIQUE KEY `factura` (`factura`),
  ADD KEY `id_suscripcion` (`id_suscripcion`);

--
-- Indices de la tabla `playlists`
--
ALTER TABLE `playlists`
  ADD PRIMARY KEY (`id_playlist`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `playlists_compartidas`
--
ALTER TABLE `playlists_compartidas`
  ADD PRIMARY KEY (`id_cancion`,`id_playlist`),
  ADD KEY `id_playlist` (`id_playlist`),
  ADD KEY `id_usuario_agrega` (`id_usuario_agrega`);

--
-- Indices de la tabla `seguimiento_artistas`
--
ALTER TABLE `seguimiento_artistas`
  ADD PRIMARY KEY (`id_usuario`,`id_artista`),
  ADD KEY `id_artista` (`id_artista`);

--
-- Indices de la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  ADD PRIMARY KEY (`id_suscripcion`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `albumes`
--
ALTER TABLE `albumes`
  MODIFY `id_album` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `id_artista` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `canciones`
--
ALTER TABLE `canciones`
  MODIFY `id_cancion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `playlists`
--
ALTER TABLE `playlists`
  MODIFY `id_playlist` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  MODIFY `id_suscripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `albumes`
--
ALTER TABLE `albumes`
  ADD CONSTRAINT `albumes_ibfk_1` FOREIGN KEY (`id_artista`) REFERENCES `artistas` (`id_artista`);

--
-- Filtros para la tabla `artistas_relacionados`
--
ALTER TABLE `artistas_relacionados`
  ADD CONSTRAINT `artistas_relacionados_ibfk_1` FOREIGN KEY (`id_artista_principal`) REFERENCES `artistas` (`id_artista`),
  ADD CONSTRAINT `artistas_relacionados_ibfk_2` FOREIGN KEY (`id_artista_relacionado`) REFERENCES `artistas` (`id_artista`);

--
-- Filtros para la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD CONSTRAINT `canciones_ibfk_1` FOREIGN KEY (`id_album`) REFERENCES `albumes` (`id_album`);

--
-- Filtros para la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD CONSTRAINT `favoritos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `favoritos_ibfk_2` FOREIGN KEY (`id_album`) REFERENCES `albumes` (`id_album`),
  ADD CONSTRAINT `favoritos_ibfk_3` FOREIGN KEY (`id_cancion`) REFERENCES `canciones` (`id_cancion`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_suscripcion`) REFERENCES `suscripciones` (`id_suscripcion`);

--
-- Filtros para la tabla `playlists`
--
ALTER TABLE `playlists`
  ADD CONSTRAINT `playlists_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `playlists_compartidas`
--
ALTER TABLE `playlists_compartidas`
  ADD CONSTRAINT `playlists_compartidas_ibfk_1` FOREIGN KEY (`id_cancion`) REFERENCES `canciones` (`id_cancion`),
  ADD CONSTRAINT `playlists_compartidas_ibfk_2` FOREIGN KEY (`id_playlist`) REFERENCES `playlists` (`id_playlist`),
  ADD CONSTRAINT `playlists_compartidas_ibfk_3` FOREIGN KEY (`id_usuario_agrega`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `seguimiento_artistas`
--
ALTER TABLE `seguimiento_artistas`
  ADD CONSTRAINT `seguimiento_artistas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `seguimiento_artistas_ibfk_2` FOREIGN KEY (`id_artista`) REFERENCES `artistas` (`id_artista`);

--
-- Filtros para la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  ADD CONSTRAINT `suscripciones_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
