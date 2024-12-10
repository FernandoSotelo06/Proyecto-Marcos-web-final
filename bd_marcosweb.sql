-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 10-12-2024 a las 22:54:51
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
-- Base de datos: `bd_marcosweb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(255) NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL,
  `Estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`, `Estado`) VALUES
(17, '2', 'Juan Guerrero Solis', 'Los Alamos', '1'),
(18, '1', 'Maria Rosas Villanueva', 'Los Laureles 234', '1'),
(19, '3', 'Andres de Santa Cruz', 'Av. La Frontera 347', '1'),
(20, '4', 'Andres Mendoza', 'Chosica, Lurigancho', '1'),
(22, '912731232', 'pepe', 'su casa', 'Activo'),
(23, '91273112311', 'tito', 'la otra casa', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(155, 94, 1, 1, 150),
(156, 95, 1, 1, 150),
(157, 96, 1, 1, 150),
(158, 96, 2, 3, 20),
(159, 97, 1, 1, 150),
(160, 97, 3, 3, 800),
(161, 98, 1, 1, 150),
(162, 98, 4, 2, 500),
(163, 99, 4, 4, 500),
(164, 99, 19, 4, 50),
(165, 100, 1, 1, 150);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(255) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(255) DEFAULT NULL,
  `Estado` varchar(255) DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`) VALUES
(1, '123', 'Pedro Hernandez', '988252459', '1', 'emp01'),
(2, '123', 'Roman Riquelme', '988252459', '1', 'Jo46'),
(3, '123', 'Palermo Suarez', '453536458', '1', 'Em22'),
(8, '07877541', 'Jesus Lujan', '999666333', '1', 'Lagarto'),
(9, '07877543', 'Pepito Quispe actu', '999666336', 'Inactivo', ''),
(11, '07873532', 'Antonio Santiago', '98718240', 'Activo', 'Mr-32'),
(19, '72528755', 'Alvaro Chang Espinoza', '999333666', 'Inactivo', 'A-chan1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'Teclado Logitech 345', 150, 94, 'Activo'),
(2, 'Mouse Logitech 567', 20, 95, 'Activo'),
(3, 'Laptop Lenovo Ideapad 520', 800, 97, 'Activo'),
(4, 'HeadPhones Sony M333', 500, 92, 'Activo'),
(19, 'mouse inalambrico Logitech', 50, 6, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdEmpleado`, `NumeroSerie`, `FechaVentas`, `Monto`, `Estado`) VALUES
(94, 18, 2, '000000001', '2024-08-12', 150, '1'),
(95, 18, 2, '000000002', '2024-08-12', 150, '1'),
(96, 18, 2, '000000003', '2024-08-12', 210, '1'),
(97, 18, 2, '000000004', '2024-08-12', 2550, '1'),
(98, 18, 2, '000000005', '2024-08-12', 1150, '1'),
(99, 18, 2, '000000006', '2024-08-12', 2200, '1'),
(100, 18, 2, '000000007', '2024-08-12', 150, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdEmpleado`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=166;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
