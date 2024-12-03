-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2024 at 02:57 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fsp_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievement`
--

CREATE TABLE `achievement` (
  `idachievement` int(11) NOT NULL,
  `idteam` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `achievement`
--

INSERT INTO `achievement` (`idachievement`, `idteam`, `name`, `date`, `description`) VALUES
(29, 20, 'TIm terfavorit juri', '2024-10-27', 'Tim Terbaik dari juri'),
(30, 20, 'Juara 3 EWS 2024', '2024-10-27', 'Juara 3'),
(31, 21, 'Juara Harapan Badut Cup', '2024-10-27', 'Juara Harapan'),
(32, 21, 'Juara 3 MPL', '2024-10-24', 'Juara 3 MPL'),
(33, 22, 'Juara 1 UBAYA CUP', '2024-10-04', 'PEMENANG UBAYA CUP'),
(34, 22, 'Juara Harapan EWS', '2024-09-29', 'Juara Harapan EWS'),
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
  `idevent` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`idevent`, `name`, `date`, `description`) VALUES
(14, 'BADUT CUP 2099', '2024-10-01', 'Bukan Cyberpunk'),
(15, 'ESPORT WORLD CUP 2020', '2024-10-16', 'EWS 2020'),
(16, 'ESPORT WORLD CUP 2023', '2024-10-10', 'EWS 2023'),
(17, 'ESPORT WORLD CUP 2024', '2024-10-23', 'EWS 2024'),
(18, 'PINJOL CUP', '2024-10-01', 'Menang bebas pinjol'),
(19, 'MPL', '2024-10-14', 'Mobile Premier League'),
(20, 'SURABAYA CHAMPIONSHIP', '2024-10-15', 'Kejuaraan se-Surabaya'),
(21, 'UBAYA CUP', '2024-07-11', 'Lomba antar mahasiswa Ubaya'),
(22, 'Lomba A', '2024-10-21', 'Lomba versi a'),
(23, 'Clover Cup', '2024-10-07', 'Kejuaraan abal-abal'),
(24, 'Indo Cup', '2024-11-07', 'Kejuaraan esport nasional'),
(25, 'UBAYA Esport Festival', '2024-09-08', 'Festival Esport Ubaya'),
(26, 'Jakarta Event', '2024-08-16', 'Lomba di Jakarta'),
(27, 'HEHEHE Champion', '2024-11-04', 'HAHAHAHA'),
(28, 'Loser Cup', '2024-08-08', 'Kejuaran pecundang');

-- --------------------------------------------------------

--
-- Table structure for table `event_teams`
--

CREATE TABLE `event_teams` (
  `idevent` int(11) NOT NULL,
  `idteam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `event_teams`
--

INSERT INTO `event_teams` (`idevent`, `idteam`) VALUES
(14, 29),
(14, 35),
(14, 49),
(15, 38),
(16, 47),
(17, 34),
(17, 36),
(17, 42),
(17, 43),
(17, 44),
(17, 45),
(18, 33),
(19, 48),
(20, 39),
(20, 46),
(21, 23),
(21, 24),
(22, 28),
(22, 30),
(22, 31),
(23, 37),
(23, 39),
(24, 27),
(25, 25),
(25, 41),
(25, 50),
(26, 21),
(26, 22),
(26, 24),
(26, 40),
(27, 21),
(27, 26),
(27, 42),
(27, 51),
(28, 20),
(28, 23);

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `idgame` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idjoin_proposal` int(11) NOT NULL,
  `idmember` int(11) NOT NULL,
  `idteam` int(11) NOT NULL,
  `description` varchar(100) DEFAULT 'role preference: support, attacker, dll',
  `status` enum('waiting','approved','rejected') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `join_proposal`
--

INSERT INTO `join_proposal` (`idjoin_proposal`, `idmember`, `idteam`, `description`, `status`) VALUES
(9, 4, 20, 'halo saya ingin bergabung', 'approved'),
(10, 4, 20, 'halo', 'approved'),
(11, 4, 22, 'I WANT TO GO IN', 'approved'),
(12, 4, 23, 'HALO SAYA INGNIN MASUK', 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `idmember` int(11) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile` enum('admin','member') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`idmember`, `fname`, `lname`, `username`, `password`, `profile`) VALUES
(2, 't', 't', 'test', '$2y$10$OhD5hEru6uMtacKzEODq7.oij55X7PvPuaEbnDTJGqfq8q9N9a2zu', 'admin'),
(3, 'Admin', 'nimda', 'Admin', '$2y$10$HEmPRYNfMFgA6DOcF6boK.xA5IzLa.Et5ODHJAdlhLd95OUayZDii', 'admin'),
(4, 'willy', 'himawan', 'willy', '$2y$10$vdmGYpl1xWV/XVf16cczcOpPqY12UPJEDRYTJZODO2n70qNdw2MZK', 'member'),
(5, 'edward', 'leonardo', 'edward', '$2y$10$a4gZUIX4QTT8pYq5mbwvHeFDp5yGsItndqRfsBtfg4VSzhXgm957m', 'member'),
(6, 'aaron', 'aaron', 'aaron', '$2y$10$a96KKXwNp1HxMn91xvIwRe5AV3mY8aTQWgNRkLDQyblwaiYQ7kD3W', 'member'),
(7, 'w', 'w', 'willyyy', '$2y$10$banvUqDOg7GxCQgzCeSHZuvEwS5PYExCP.ZCkZbWuJdUWqjJezbpO', 'member');

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `idteam` int(11) NOT NULL,
  `idgame` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`idteam`, `idgame`, `name`) VALUES
(20, 18, 'EVOS L'),
(21, 19, 'RRQ V'),
(22, 19, 'STRIKE'),
(23, 20, 'FNATIC'),
(24, 20, 'SOUL'),
(25, 21, 'KING M'),
(26, 21, 'Blaze'),
(27, 23, 'PPX'),
(28, 22, 'Liquids'),
(29, 22, 'POLO'),
(30, 23, 'LevelUp'),
(31, 24, 'Rizz'),
(32, 24, 'Gyattt'),
(33, 26, 'GEDAGEDI'),
(34, 26, 'SIUUU'),
(35, 27, 'PESSI'),
(36, 27, 'Pride'),
(37, 28, 'LeBonBon'),
(38, 28, 'Ubaya X'),
(39, 29, 'Ubaya Kings'),
(40, 30, 'EpEp'),
(41, 30, 'Freedom'),
(42, 31, 'EVOS Legend'),
(43, 31, 'BTR'),
(44, 32, 'Slow Start'),
(45, 32, 'Makima'),
(46, 33, 'AWKWK'),
(47, 33, 'Oke Boss'),
(48, 34, 'NAVIS'),
(49, 34, 'One Night'),
(50, 35, 'Wolves'),
(51, 35, 'Muda Mudi'),
(52, 18, 'EVOS H');

-- --------------------------------------------------------

--
-- Table structure for table `team_members`
--

CREATE TABLE `team_members` (
  `idteam` int(11) NOT NULL,
  `idmember` int(11) NOT NULL,
  `description` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `team_members`
--

INSERT INTO `team_members` (`idteam`, `idmember`, `description`) VALUES
(20, 4, 'halo'),
(21, 4, 'Duelist'),
(21, 5, 'Smoker'),
(21, 6, 'Sentinel'),
(22, 4, 'I WANT TO GO IN'),
(23, 4, 'HALO SAYA INGNIN MASUK');

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
  MODIFY `idachievement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `idevent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `idgame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `join_proposal`
--
ALTER TABLE `join_proposal`
  MODIFY `idjoin_proposal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idmember` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `idteam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

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
