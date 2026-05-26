-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2026 at 05:46 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rentcar`
--

-- --------------------------------------------------------

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

-- --------------------------------------------------------

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
(6, 6, 'Toyota', 'Avanza update', 300000, 'Not Available', 'C:\\\\Users\\\\Hype G12\\\\Downloads\\\\bikini-bottom.jpg', '2026-05-09', 'F267YZ'),
(7, 7, 'Honda', 'Civic update', 350000, 'Not Available', 'C:\\\\Users\\\\Hype G12\\\\Downloads\\\\indah.jpg', '2026-05-09', 'B578XY'),
(12, 13, 'Honda', 'model 12 UPDATE', 350000, 'Available', 'C:\\\\Users\\\\Hype G12\\\\Downloads\\\\decorative-blank-space-mother-s-day.jpg', '2026-05-26', 'F123XY');

-- --------------------------------------------------------

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
(4, 4, 'Rudi ', 'Tabuty', 'Male', 5, 'Toyota', 'Innova New', 1500000, '2026-05-03', '2026-05-06'),
(5, 5, 'test', 'test', 'Female', 4, 'Toyota', 'Innova', 2000000, '2026-05-04', '2026-05-08'),
(6, 6, 'Indah', 'lagi', 'Female', 6, 'Toyota', 'Avanza', 600000, '2026-05-09', '2026-05-11'),
(7, 7, 'Test', 'nama', 'Male', 7, 'Honda', 'Civic', 350000, '2026-05-09', '2026-05-10'),
(8, 8, 'test', 'test', 'Female', 6, 'Toyota', 'Avanza', 600000, '2026-05-14', '2026-05-16'),
(9, 9, 'coba', 'coba', 'Male', 7, 'Honda', 'Civic update', 1400000, '2026-05-16', '2026-05-20'),
(10, 10, 'NAMA 9', 'Nama 9', 'Female', 9, 'brand 9', 'model 9', 900000, '2026-05-14', '2026-05-16'),
(11, 11, 'budi', 'ani', 'Female', 10, 'brand 10', 'model 10', 1500000, '2026-05-17', '2026-05-20'),
(12, 12, 'fizi', 'xyz', 'Male', 6, 'Toyota', 'Avanza', 1500000, '2026-05-17', '2026-05-22'),
(13, 13, 'Rudi', 'agus', 'Male', 7, 'Honda', 'Civic update', 700000, '2026-05-22', '2026-05-24'),
(14, 14, 'Indah', 'oktaviana', 'Female', 6, 'Toyota', 'Avanza update', 600000, '2026-05-24', '2026-05-26'),
(15, 15, 'test', 'test', 'Male', 7, 'Honda', 'Civic update', 350000, '2026-05-24', '2026-05-25'),
(16, 16, 'test', 'test', 'Female', 12, 'Toyota', 'Avanza update', 600000, '2026-05-24', '2026-05-26'),
(17, 17, 'indah', 'indah', 'Female', 12, 'Toyota', 'SUV update', 1000000, '2026-05-24', '2026-05-26'),
(18, 18, 'nama', 'nama belakang', 'Male', 7, 'Honda', 'Civic update', 1050000, '2026-05-24', '2026-05-27'),
(19, 19, 'INDAH', 'OKTAV', 'Female', 6, 'Toyota', 'Avanza update', 300000, '2026-05-26', '2026-05-27');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `date_rented` date DEFAULT NULL,
  `date_return` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `date_invoice` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `customer_id`, `first_name`, `last_name`, `car_id`, `brand`, `model`, `date_rented`, `date_return`, `total`, `amount`, `balance`, `date_invoice`) VALUES
(1, 16, 'test', 'test', 12, 'Toyota', 'Avanza update', '2026-05-24', '2026-05-26', 600000, 1000000, 400000, '2026-05-24'),
(2, 17, 'indah', 'indah', 12, 'Toyota', 'SUV update', '2026-05-24', '2026-05-26', 1000000, 1000000, 0, '2026-05-24'),
(3, 18, 'nama', 'nama belakang', 7, 'Honda', 'Civic update', '2026-05-24', '2026-05-27', 1050000, 1100000, 50000, '2026-05-24'),
(4, 19, 'INDAH', 'OKTAV', 6, 'Toyota', 'Avanza update', '2026-05-26', '2026-05-27', 300000, 300000, 0, '2026-05-26');

-- --------------------------------------------------------

--
-- Table structure for table `late_return`
--

CREATE TABLE `late_return` (
  `late_id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `late_days` int(11) DEFAULT NULL,
  `fine` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `date_returned` date DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `late_return`
--

INSERT INTO `late_return` (`late_id`, `customer_id`, `late_days`, `fine`, `amount`, `balance`, `date_returned`, `brand`, `model`) VALUES
(1, 2, 3, 0, 0, 0, '2026-05-24', 'Toyota', 'Innova'),
(2, 18, 3, 0, 0, 0, '2026-05-30', 'Honda', 'Civic update'),
(3, 5, 3, 150000, 200000, 50000, '2026-05-21', 'Toyota', 'Innova'),
(4, 4, 3, 150000, 200000, 50000, '2026-05-26', 'Toyota', 'Innova New');

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
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`);

--
-- Indexes for table `late_return`
--
ALTER TABLE `late_return`
  ADD PRIMARY KEY (`late_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `late_return`
--
ALTER TABLE `late_return`
  MODIFY `late_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
