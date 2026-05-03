# Car-Rental-Apps

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2026 at 07:55 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/_!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT _/;
/_!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS _/;
/_!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION _/;
/_!40101 SET NAMES utf8mb4 _/;

--
-- Database: `rentcar`
--

---

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
`id` int(11) NOT NULL,
`username` varchar(50) DEFAULT NULL,
`password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

---

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
`id` int(11) NOT NULL,
`car_id` int(11) DEFAULT NULL,
`brand` varchar(50) DEFAULT NULL,
`model` varchar(50) DEFAULT NULL,
`price` double DEFAULT NULL,
`status` varchar(50) DEFAULT NULL,
`image` text DEFAULT NULL,
`date` date DEFAULT NULL,
`plate_number` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `car_id`, `brand`, `model`, `price`, `status`, `image`, `date`, `plate_number`) VALUES
(4, 4, 'Toyota', 'Innova', 500000, 'Available', 'C:\\\\Users\\\\Hype G12\\\\Downloads\\\\indah.jpg', '2026-05-03', 'B1234AY'),
(5, 5, 'Toyota', 'Innova New', 500000, 'Not Available', 'C:\\\\Users\\\\Hype G12\\\\Downloads\\\\bikini-bottom.jpg', '2026-05-03', 'F123AB');

---

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
`id` int(11) NOT NULL,
`customer_id` int(11) DEFAULT NULL,
`firstName` varchar(50) DEFAULT NULL,
`lastName` varchar(50) DEFAULT NULL,
`gender` varchar(20) DEFAULT NULL,
`car_id` int(11) DEFAULT NULL,
`brand` varchar(50) DEFAULT NULL,
`model` varchar(50) DEFAULT NULL,
`total` double DEFAULT NULL,
`date_rented` date DEFAULT NULL,
`date_return` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `customer_id`, `firstName`, `lastName`, `gender`, `car_id`, `brand`, `model`, `total`, `date_rented`, `date_return`) VALUES
(1, 0, 'Indah', 'Oktav', 'Female', 1, 'Toyota', 'Avanza', 1650, '2026-05-03', '2026-05-06'),
(2, 2, 'Upin', 'Ipin', 'Male', 2, 'Toyota', 'Innova', 900000, '2026-05-05', '2026-05-08'),
(3, 3, 'bernard', 'bear', 'Male', 2, 'Toyota', 'Innova', 600000, '2026-05-03', '2026-05-05'),
(4, 4, 'Rudi ', 'Tabuty', 'Male', 5, 'Toyota', 'Innova New', 1500000, '2026-05-03', '2026-05-06');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/_!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT _/;
/_!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS _/;
/_!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION _/;
