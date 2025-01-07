<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: *");
error_reporting(E_ERROR | E_PARSE);

// Koneksi ke database
$mysqli = new mysqli("localhost", "native_160422011", "ubaya", "native_160422011");

if ($mysqli->connect_errno) {
    echo json_encode(['result' => 'ERROR', 'message' => 'Failed to connect DB']);
    die();
}
$mysqli->set_charset("UTF8");

$idGame = $_POST['idgame'];

// Query untuk mendapatkan semua tim dalam game
$sql = "SELECT 
            a.name AS 'name', 
            YEAR(a.date) AS 'year', 
            t.name AS 'team'
        FROM 
            achievement a
        INNER JOIN 
            team t ON a.idteam = t.idteam
        WHERE 
            t.idteam IN (SELECT idteam FROM team WHERE idgame = ?)";

$stmt = $mysqli->prepare($sql);
$stmt->bind_param("i", $idGame);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
    $achievements = $result->fetch_all(MYSQLI_ASSOC); // Ambil semua hasil sebagai array
    echo json_encode([
        "status" => "OK",
        "message" => "Fetch successful",
        "achievements" => $achievements
    ]);
} else {
    echo json_encode([
        "status" => "ERROR",
        "message" => "No Achievements found"
    ]);
}

// Tutup koneksi
$stmt->close();
$mysqli->close();
?>