-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 09, 2025 at 11:55 AM
-- Server version: 8.0.40-0ubuntu0.22.04.1
-- PHP Version: 8.1.2-1ubuntu2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `native_160422011`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievement`
--

CREATE TABLE `achievement` (
  `idachievement` int NOT NULL,
  `idteam` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `achievement`
--

INSERT INTO `achievement` (`idachievement`, `idteam`, `name`, `date`, `description`) VALUES
(29, 20, 'TIm terfavorit juri', '2024-10-27', 'Tim Terbaik dari juri'),
(30, 20, 'Juara 3 EWS 2024', '2024-10-27', 'Juara 3'),
(31, 21, 'Juara Harapan Badut Cup', '2024-10-27', 'Juara Harapan'),
(32, 21, 'Juara 3 MPL', '2023-10-24', 'Juara 3 MPL'),
(33, 22, 'Juara 1 UBAYA CUP', '2022-10-04', 'PEMENANG UBAYA CUP'),
(34, 22, 'Juara Harapan EWS', '2021-09-29', 'Juara Harapan EWS'),
(35, 23, 'JUARA 3 Indo CUP', '2024-09-29', 'Juara 3'),
(36, 23, 'Juara 2 Liga', '2024-09-30', 'Juara 2'),
(37, 24, 'Juara 1 Liga', '2024-10-27', 'Juara 1 Liga'),
(38, 24, 'Most Popular Team', '2024-09-29', 'Tim terpopular di award'),
(39, 25, 'TIm terbaik', '2024-10-11', 'Tim terbaik'),
(40, 26, 'Most Valueable Team', '2024-11-01', 'TEAM TERKEREN'),
(41, 27, 'Juara 3 Ubaya Sport Festival', '2024-08-28', 'Juara 3'),
(42, 28, 'Juara Harapan Badut Cup', '2024-11-02', 'Juara Harapan'),
(43, 29, 'Juara 1 EWS 2020', '2024-11-06', 'Juara 1'),
(44, 30, 'Juara 3', '2024-10-02', 'Juara 3'),
(45, 31, 'Juara 1', '2024-10-02', 'Juara 1'),
(46, 32, 'Most Brainrot Team', '2024-10-03', 'Team ter brainrot'),
(47, 33, 'Juara 3', '2024-09-30', 'Juara 3'),
(48, 34, 'Juara 1 Pinjol Cup', '2024-10-28', 'Juara 1'),
(49, 35, 'Juara 3 Pinjol Cup', '2024-10-27', 'Juara 3'),
(50, 36, 'Juara Harapan Pinjol Cup', '2024-10-26', 'Juara Harapan'),
(51, 37, 'Juara Harapan Pinjol Cup', '2024-10-29', 'Juara Harapan'),
(52, 38, 'Juara Harapan Badut Cup', '2024-10-27', 'Juara Harapan'),
(53, 39, 'Juara Harapan Badut Cup', '2024-10-27', 'Juara Harapan'),
(54, 40, 'Juara Harapan EWS', '2024-10-11', 'Juara Harapan'),
(55, 41, 'TIM TERKEREN Pinjol Cup', '2024-10-27', 'Tim terkeren pinjol cup'),
(56, 42, 'Indo Cup Juara 1', '2024-10-27', 'Juara 1'),
(57, 43, 'Indo Cup Juara 3', '2024-10-24', 'Juara 3'),
(58, 45, 'Juara 2 Badut Cup', '2024-10-27', 'Juara 2');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `idevent` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `location` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `scope` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`idevent`, `name`, `date`, `location`, `description`, `scope`) VALUES
(14, 'BADUT CUP 2099', '2024-10-01 03:00:00', 'Surabaya', 'Bukan Cyberpunk', 'global'),
(15, 'ESPORT WORLD CUP 2020', '2024-10-16 01:00:00', 'Sidoarjo', 'EWS 2020', 'regional'),
(16, 'ESPORT WORLD CUP 2023', '2024-10-09 18:00:00', 'Jakarta', 'EWS 2023', 'regional'),
(17, 'ESPORT WORLD CUP 2024', '2024-10-22 23:00:00', 'Yogyakarta', 'EWS 2024', 'regional'),
(18, 'PINJOL CUP', '2024-10-01 04:00:00', 'Makassar', 'Menang bebas pinjol', 'regional'),
(19, 'MPL', '2024-10-13 21:00:00', 'Bandung', 'Mobile Premier League', 'regional'),
(20, 'SURABAYA CHAMPIONSHIP', '2024-10-14 22:00:00', 'Malang', 'Kejuaraan se-Surabaya', 'regional'),
(21, 'UBAYA CUP', '2024-07-11 15:00:00', 'Kediri', 'Lomba antar mahasiswa Ubaya', 'regional'),
(22, 'Lomba A', '2024-10-20 18:00:00', 'Bali', 'Lomba versi a', 'regional'),
(23, 'Clover Cup', '2024-10-07 04:00:00', 'Batu', 'Kejuaraan abal-abal', 'regional'),
(24, 'Indo Cup', '2024-11-06 20:00:00', 'Sidoarjo', 'Kejuaraan esport nasional', 'regional'),
(25, 'UBAYA Esport Festival', '2024-09-08 02:00:00', 'Makassar', 'Festival Esport Ubaya', 'regional'),
(26, 'Jakarta Event', '2024-08-16 05:00:00', 'Kendari', 'Lomba di Jakarta', 'regional'),
(27, 'HEHEHE Champion', '2024-11-04 15:00:00', 'Palangkaraya', 'HAHAHAHA', 'regional'),
(28, 'Loser Cup', '2024-08-15 01:00:00', 'Palu', 'Kejuaran pecundang', 'regional');

-- --------------------------------------------------------

--
-- Table structure for table `event_teams`
--

CREATE TABLE `event_teams` (
  `idevent` int NOT NULL,
  `idteam` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `event_teams`
--

INSERT INTO `event_teams` (`idevent`, `idteam`) VALUES
(28, 20),
(26, 21),
(27, 21),
(26, 22),
(21, 23),
(28, 23),
(21, 24),
(26, 24),
(25, 25),
(27, 26),
(24, 27),
(22, 28),
(14, 29),
(22, 30),
(22, 31),
(18, 33),
(17, 34),
(14, 35),
(17, 36),
(23, 37),
(15, 38),
(20, 39),
(23, 39),
(26, 40),
(25, 41),
(17, 42),
(27, 42),
(17, 43),
(17, 44),
(17, 45),
(20, 46),
(16, 47),
(19, 48),
(14, 49),
(25, 50),
(27, 51);

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `idgame` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`idgame`, `name`, `description`) VALUES
(18, 'Mobile Legend', '5V5 MOBA'),
(19, 'Valorant', '5V5 FPS with skill'),
(20, 'Teamfight Tactic', 'Auto Chess'),
(21, 'COD Mobile', '5V5 Classic FPS Mobile'),
(22, 'DOTA2', 'MOBA 5V5'),
(23, 'APEX LEGEND', 'Battle Royale with Skills'),
(24, 'Fortnite', 'Battle Royale'),
(25, 'PUBGM', 'The Classic Battle Royale on Mobile'),
(26, 'Rocket League', 'Soccer with Car'),
(27, 'FIFA', 'Classic Football'),
(28, 'NBA2K', 'Classic Basketball'),
(29, 'Pokemon TCG', 'The Pokemon Card Game'),
(30, 'Free Fire', 'The Garena Battle Royale'),
(31, 'Honor of Kings', '5V5 MOBA'),
(32, 'League of Legend', '5V5 MOBA'),
(33, 'League of Legend Wild Rift', 'league on Mobile'),
(34, 'Counter Strike 2', 'The Classic FPS'),
(35, 'Overwatch ', '5V5 MOBA FPS ');

-- --------------------------------------------------------

--
-- Table structure for table `join_proposal`
--

CREATE TABLE `join_proposal` (
  `idjoin_proposal` int NOT NULL,
  `idmember` int NOT NULL,
  `idteam` int NOT NULL,
  `description` varchar(100) DEFAULT 'role preference: support, attacker, dll',
  `status` enum('waiting','approved','rejected') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `join_proposal`
--

INSERT INTO `join_proposal` (`idjoin_proposal`, `idmember`, `idteam`, `description`, `status`) VALUES
(10, 4, 20, 'halo', 'approved'),
(11, 4, 22, 'I WANT TO GO IN', 'approved'),
(12, 4, 23, 'HALO SAYA INGNIN MASUK', 'approved'),
(19, 4, 21, 'i want to go in', 'waiting'),
(20, 11, 22, 'I want to go in', 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `idmember` int NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`idmember`, `fname`, `lname`, `username`, `password`) VALUES
(2, 't', 't', 'test', '123'),
(3, 'Admin', 'nimda', 'Admin', '123'),
(4, 'willy', 'himawan', 'willy', '123'),
(5, 'edward', 'leonardo', 'edward', '123'),
(6, 'aaron', 'aaron', 'aaron', '123'),
(7, 'w', 'w', 'willyyy', '123'),
(8, 'oakley', 'o', 'oakley', '123'),
(9, 'NMP', 'Admin', 'NMPAdmin', '123'),
(10, 'aaaa', 'aaaa', 'aaaa', 'aaaa'),
(11, 'w', 'w', 'w', 'w');

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `idteam` int NOT NULL,
  `idgame` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `is_open` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`idteam`, `idgame`, `name`, `is_open`) VALUES
(20, 18, 'EVOS L', 0),
(21, 19, 'RRQ V', 0),
(22, 19, 'STRIKE', 1),
(23, 20, 'FNATIC', 1),
(24, 20, 'SOUL', 1),
(25, 21, 'KING M', 1),
(26, 21, 'Blaze', 1),
(27, 23, 'PPX', 1),
(28, 22, 'Liquids', 1),
(29, 22, 'POLO', 1),
(30, 23, 'LevelUp', 1),
(31, 24, 'Rizz', 1),
(32, 24, 'Gyattt', 1),
(33, 26, 'GEDAGEDI', 1),
(34, 26, 'SIUUU', 1),
(35, 27, 'PESSI', 1),
(36, 27, 'Pride', 1),
(37, 28, 'LeBonBon', 1),
(38, 28, 'Ubaya X', 1),
(39, 29, 'Ubaya Kings', 1),
(40, 30, 'EpEp', 1),
(41, 30, 'Freedom', 1),
(42, 31, 'EVOS Legend', 1),
(43, 31, 'BTR', 1),
(44, 32, 'Slow Start', 1),
(45, 32, 'Makima', 1),
(46, 33, 'AWKWK', 1),
(47, 33, 'Oke Boss', 1),
(48, 34, 'NAVIS', 1),
(49, 34, 'One Night', 1),
(50, 35, 'Wolves', 1),
(51, 35, 'Muda Mudi', 1),
(52, 18, 'EVOS H', 1);

-- --------------------------------------------------------

--
-- Table structure for table `team_members`
--

CREATE TABLE `team_members` (
  `idteam` int NOT NULL,
  `idmember` int NOT NULL,
  `description` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `team_members`
--

INSERT INTO `team_members` (`idteam`, `idmember`, `description`) VALUES
(20, 4, 'Duelist'),
(21, 5, 'Smoker'),
(21, 6, 'Sentinel'),
(22, 4, 'Duelist'),
(23, 4, 'Smoker');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`idachievement`),
  ADD KEY `fk_achievement_team1_idx` (`idteam`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`idevent`);

--
-- Indexes for table `event_teams`
--
ALTER TABLE `event_teams`
  ADD PRIMARY KEY (`idevent`,`idteam`),
  ADD KEY `fk_event_has_team_team1_idx` (`idteam`),
  ADD KEY `fk_event_has_team_event1_idx` (`idevent`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`idgame`);

--
-- Indexes for table `join_proposal`
--
ALTER TABLE `join_proposal`
  ADD PRIMARY KEY (`idjoin_proposal`),
  ADD KEY `fk_join_proposal_member1_idx` (`idmember`),
  ADD KEY `fk_join_proposal_team1_idx` (`idteam`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idmember`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`idteam`),
  ADD KEY `fk_team_game1_idx` (`idgame`);

--
-- Indexes for table `team_members`
--
ALTER TABLE `team_members`
  ADD PRIMARY KEY (`idteam`,`idmember`),
  ADD KEY `fk_team_has_member_member1_idx` (`idmember`),
  ADD KEY `fk_team_has_member_team_idx` (`idteam`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievement`
--
ALTER TABLE `achievement`
  MODIFY `idachievement` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `idevent` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `idgame` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `join_proposal`
--
ALTER TABLE `join_proposal`
  MODIFY `idjoin_proposal` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idmember` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `idteam` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `fk_achievement_team1` FOREIGN KEY (`idteam`) REFERENCES `team` (`idteam`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `event_teams`
--
ALTER TABLE `event_teams`
  ADD CONSTRAINT `fk_event_has_team_event1` FOREIGN KEY (`idevent`) REFERENCES `event` (`idevent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_event_has_team_team1` FOREIGN KEY (`idteam`) REFERENCES `team` (`idteam`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `join_proposal`
--
ALTER TABLE `join_proposal`
  ADD CONSTRAINT `fk_join_proposal_member1` FOREIGN KEY (`idmember`) REFERENCES `member` (`idmember`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_join_proposal_team1` FOREIGN KEY (`idteam`) REFERENCES `team` (`idteam`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `fk_team_game1` FOREIGN KEY (`idgame`) REFERENCES `game` (`idgame`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team_members`
--
ALTER TABLE `team_members`
  ADD CONSTRAINT `fk_team_has_member_member1` FOREIGN KEY (`idmember`) REFERENCES `member` (`idmember`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_team_has_member_team` FOREIGN KEY (`idteam`) REFERENCES `team` (`idteam`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
