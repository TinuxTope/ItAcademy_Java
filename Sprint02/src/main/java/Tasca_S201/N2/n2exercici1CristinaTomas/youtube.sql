-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2024 a las 15:37:31
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
-- Base de datos: `youtube`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canales`
--

CREATE TABLE `canales` (
  `id_canal` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `fecha_creacion` date NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `id_comentario` int(11) NOT NULL,
  `texto_comentario` text NOT NULL,
  `fecha_hora_comentario` datetime NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_video` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiquetas`
--

CREATE TABLE `etiquetas` (
  `id_etiqueta` int(11) NOT NULL,
  `nombre_etiqueta` varchar(100) NOT NULL,
  `id_video` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likescomentarios`
--

CREATE TABLE `likescomentarios` (
  `id_usuario` int(11) NOT NULL,
  `id_comentario` int(11) NOT NULL,
  `tipo` enum('like','dislike') NOT NULL,
  `fecha_hora_like_dislike` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likesvideos`
--

CREATE TABLE `likesvideos` (
  `id_usuario` int(11) NOT NULL,
  `id_video` int(11) NOT NULL,
  `tipo` enum('like','dislike') NOT NULL,
  `fecha_hora_like_dislike` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlists`
--

CREATE TABLE `playlists` (
  `id_playlist` int(11) NOT NULL,
  `nombre` varchar(55) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `estado` enum('publica','privada') NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlistsvideos`
--

CREATE TABLE `playlistsvideos` (
  `id_playlist` int(11) NOT NULL,
  `id_video` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suscripciones`
--

CREATE TABLE `suscripciones` (
  `id_usuario` int(11) NOT NULL,
  `id_canal` int(11) NOT NULL,
  `fecha_suscripcion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` enum('M','F','O') NOT NULL,
  `pais` varchar(50) NOT NULL,
  `codigo_postal` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videos`
--

CREATE TABLE `videos` (
  `id_video` int(11) NOT NULL,
  `titulo` varchar(55) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `tamano` int(11) NOT NULL,
  `archivo_video` varchar(55) NOT NULL,
  `duracion` time NOT NULL,
  `thumbnail` blob NOT NULL,
  `reproducciones` int(11) DEFAULT 0,
  `likes` int(11) DEFAULT 0,
  `dislikes` int(11) DEFAULT 0,
  `estado` enum('publico','oculto','privado') NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `fecha_hora_publicacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `canales`
--
ALTER TABLE `canales`
  ADD PRIMARY KEY (`id_canal`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_video` (`id_video`);

--
-- Indices de la tabla `etiquetas`
--
ALTER TABLE `etiquetas`
  ADD PRIMARY KEY (`id_etiqueta`),
  ADD KEY `id_video` (`id_video`);

--
-- Indices de la tabla `likescomentarios`
--
ALTER TABLE `likescomentarios`
  ADD PRIMARY KEY (`id_usuario`,`id_comentario`),
  ADD KEY `id_comentario` (`id_comentario`);

--
-- Indices de la tabla `likesvideos`
--
ALTER TABLE `likesvideos`
  ADD PRIMARY KEY (`id_usuario`,`id_video`),
  ADD KEY `id_video` (`id_video`);

--
-- Indices de la tabla `playlists`
--
ALTER TABLE `playlists`
  ADD PRIMARY KEY (`id_playlist`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `playlistsvideos`
--
ALTER TABLE `playlistsvideos`
  ADD PRIMARY KEY (`id_playlist`,`id_video`),
  ADD KEY `id_video` (`id_video`);

--
-- Indices de la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  ADD PRIMARY KEY (`id_usuario`,`id_canal`),
  ADD KEY `id_canal` (`id_canal`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `videos`
--
ALTER TABLE `videos`
  ADD PRIMARY KEY (`id_video`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `canales`
--
ALTER TABLE `canales`
  MODIFY `id_canal` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `id_comentario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `etiquetas`
--
ALTER TABLE `etiquetas`
  MODIFY `id_etiqueta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `playlists`
--
ALTER TABLE `playlists`
  MODIFY `id_playlist` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `videos`
--
ALTER TABLE `videos`
  MODIFY `id_video` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `canales`
--
ALTER TABLE `canales`
  ADD CONSTRAINT `canales_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `comentarios_ibfk_2` FOREIGN KEY (`id_video`) REFERENCES `videos` (`id_video`);

--
-- Filtros para la tabla `etiquetas`
--
ALTER TABLE `etiquetas`
  ADD CONSTRAINT `etiquetas_ibfk_1` FOREIGN KEY (`id_video`) REFERENCES `videos` (`id_video`);

--
-- Filtros para la tabla `likescomentarios`
--
ALTER TABLE `likescomentarios`
  ADD CONSTRAINT `likescomentarios_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `likescomentarios_ibfk_2` FOREIGN KEY (`id_comentario`) REFERENCES `comentarios` (`id_comentario`);

--
-- Filtros para la tabla `likesvideos`
--
ALTER TABLE `likesvideos`
  ADD CONSTRAINT `likesvideos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `likesvideos_ibfk_2` FOREIGN KEY (`id_video`) REFERENCES `videos` (`id_video`);

--
-- Filtros para la tabla `playlists`
--
ALTER TABLE `playlists`
  ADD CONSTRAINT `playlists_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `playlistsvideos`
--
ALTER TABLE `playlistsvideos`
  ADD CONSTRAINT `playlistsvideos_ibfk_1` FOREIGN KEY (`id_playlist`) REFERENCES `playlists` (`id_playlist`),
  ADD CONSTRAINT `playlistsvideos_ibfk_2` FOREIGN KEY (`id_video`) REFERENCES `videos` (`id_video`);

--
-- Filtros para la tabla `suscripciones`
--
ALTER TABLE `suscripciones`
  ADD CONSTRAINT `suscripciones_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `suscripciones_ibfk_2` FOREIGN KEY (`id_canal`) REFERENCES `canales` (`id_canal`);

--
-- Filtros para la tabla `videos`
--
ALTER TABLE `videos`
  ADD CONSTRAINT `videos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
