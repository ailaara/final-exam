-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2022 at 08:06 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_sepeda`
--

-- --------------------------------------------------------

--
-- Table structure for table `sepeda_gowes`
--

CREATE TABLE `sepeda_gowes` (
  `kode` int(11) NOT NULL,
  `tipe` varchar(64) NOT NULL,
  `merk` varchar(64) NOT NULL,
  `harga` decimal(11,2) NOT NULL,
  `stok` int(11) NOT NULL,
  `jenis` varchar(64) NOT NULL,
  `ban` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sepeda_gowes`
--

INSERT INTO `sepeda_gowes` (`kode`, `tipe`, `merk`, `harga`, `stok`, `jenis`, `ban`) VALUES
(9, 'Ducati L 2000', 'Ducati', '3500.00', 19, 'BMX', 'Ducati-XL-1000'),
(10, 'Nmax 3000', 'Nmax', '1500000.00', 15, 'Gunung', 'Ricard M 150'),
(11, 'Sonic 450 Z', 'Sonic', '4000.00', 20, 'Lipat', 'So nika z90');

-- --------------------------------------------------------

--
-- Table structure for table `sepeda_listrik`
--

CREATE TABLE `sepeda_listrik` (
  `kode` int(11) NOT NULL,
  `tipe` varchar(64) NOT NULL,
  `merk` varchar(64) NOT NULL,
  `harga` decimal(11,2) NOT NULL,
  `stok` int(11) NOT NULL,
  `kecepatan` varchar(64) NOT NULL,
  `baterai` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sepeda_listrik`
--

INSERT INTO `sepeda_listrik` (`kode`, `tipe`, `merk`, `harga`, `stok`, `kecepatan`, `baterai`) VALUES
(1, 'Sonic 4000', 'Sonic', '54000.00', 30, '100km/h', '85V');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `nama` varchar(64) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total` decimal(11,2) NOT NULL,
  `pembayaran` decimal(11,2) NOT NULL,
  `kembalian` decimal(11,2) NOT NULL,
  `tanggal` date NOT NULL,
  `kategori` varchar(64) NOT NULL,
  `kode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `nama`, `jumlah`, `total`, `pembayaran`, `kembalian`, `tanggal`, `kategori`, `kode`) VALUES
(6, 'Rudi', 1, '1500000.00', '1500000.00', '0.00', '2022-10-30', 'Gowes', 10),
(7, 'Niko', 1, '1500000.00', '1500000.00', '0.00', '2022-10-30', 'Gowes', 10),
(9, 'Uding', 1, '3500.00', '3500.00', '0.00', '2022-10-30', 'Gowes', 9),
(10, 'Ridho', 1, '3500.00', '3500.00', '0.00', '2022-10-30', 'Gowes', 9),
(11, 'Saleh', 2, '108000.00', '109000.00', '1000.00', '2022-10-30', 'Listrik', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sepeda_gowes`
--
ALTER TABLE `sepeda_gowes`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `sepeda_listrik`
--
ALTER TABLE `sepeda_listrik`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sepeda_gowes`
--
ALTER TABLE `sepeda_gowes`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `sepeda_listrik`
--
ALTER TABLE `sepeda_listrik`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
