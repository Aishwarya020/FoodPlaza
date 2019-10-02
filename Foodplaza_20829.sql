-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 08, 2019 at 12:57 PM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.4-7ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Foodplaza_20829`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin20829`
--

CREATE TABLE `Admin20829` (
  `admn_id` int(11) NOT NULL,
  `admn_email` varchar(100) NOT NULL,
  `admn_password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Admin20829`
--

INSERT INTO `Admin20829` (`admn_id`, `admn_email`, `admn_password`) VALUES
(1, 'squadinfotech@gmail.com', 'c0d3r123');

-- --------------------------------------------------------

--
-- Table structure for table `Cart20829`
--

CREATE TABLE `Cart20829` (
  `cartid` int(11) NOT NULL,
  `foodid` int(20) DEFAULT NULL,
  `custemailid` varchar(50) DEFAULT NULL,
  `foodqty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cart20829`
--

INSERT INTO `Cart20829` (`cartid`, `foodid`, `custemailid`, `foodqty`) VALUES
(1, 1, 'abc@gmail.com', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Customer20829`
--

CREATE TABLE `Customer20829` (
  `custid` int(11) NOT NULL,
  `custname` varchar(50) DEFAULT NULL,
  `custemailid` varchar(50) NOT NULL,
  `custpassword` varchar(50) DEFAULT NULL,
  `custaddress` varchar(50) DEFAULT NULL,
  `custnumber` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer20829`
--

INSERT INTO `Customer20829` (`custid`, `custname`, `custemailid`, `custpassword`, `custaddress`, `custnumber`) VALUES
(1, 'abc', 'abc@gmail.com', 'abcd2089', 'Mumbai', '9865324152'),
(5, 'Sidharth', 'accc@ymail.com', 'asasasasas', 'SD', '1209121212'),
(6, 'Aishwarya PQ', 'aish@ymail.com', 'abcd1234', 'Romies', '1234567890'),
(3, 'abcq', 'hat@gmail.com', 'dffd451234', 'Pune', '1235555123');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `foodid` int(11) NOT NULL,
  `foodname` varchar(50) NOT NULL,
  `foodtype` varchar(50) NOT NULL,
  `foodcategory` varchar(50) NOT NULL,
  `fooddescription` varchar(50) NOT NULL,
  `foodprice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`foodid`, `foodname`, `foodtype`, `foodcategory`, `fooddescription`, `foodprice`) VALUES
(6, 'Biriyani', 'veg', 'veg', 'spicy', 300),
(7, 'Dal Fry', 'veg', 'veg', 'Garlic and red chilly topped', 70),
(9, 'Jeera Rice', 'veg', 'veg', 'Rice with jeera add on ', 55);

-- --------------------------------------------------------

--
-- Table structure for table `Order20829`
--

CREATE TABLE `Order20829` (
  `orderid` int(11) NOT NULL,
  `custemailid` varchar(60) DEFAULT NULL,
  `orderdate` varchar(60) DEFAULT NULL,
  `totalbill` double(10,1) DEFAULT NULL,
  `orderstatus` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Order20829`
--

INSERT INTO `Order20829` (`orderid`, `custemailid`, `orderdate`, `totalbill`, `orderstatus`) VALUES
(1, 'abc', 'Sun Jun 30 13:27:53 IST 2019', 20.0, NULL),
(2, 'abc', 'Sun Jun 30 13:29:17 IST 2019', 0.0, 'Processing');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin20829`
--
ALTER TABLE `Admin20829`
  ADD PRIMARY KEY (`admn_email`),
  ADD UNIQUE KEY `admn_id` (`admn_id`);

--
-- Indexes for table `Cart20829`
--
ALTER TABLE `Cart20829`
  ADD PRIMARY KEY (`cartid`);

--
-- Indexes for table `Customer20829`
--
ALTER TABLE `Customer20829`
  ADD PRIMARY KEY (`custemailid`),
  ADD UNIQUE KEY `custid` (`custid`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`foodid`);

--
-- Indexes for table `Order20829`
--
ALTER TABLE `Order20829`
  ADD PRIMARY KEY (`orderid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin20829`
--
ALTER TABLE `Admin20829`
  MODIFY `admn_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Cart20829`
--
ALTER TABLE `Cart20829`
  MODIFY `cartid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Customer20829`
--
ALTER TABLE `Customer20829`
  MODIFY `custid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `foodid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `Order20829`
--
ALTER TABLE `Order20829`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
