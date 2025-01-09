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

// Ambil data dari permintaan POST
$idGame = $_POST['idgame'] ?? null; // Pastikan $idGame tidak null

if (!$idGame) {
    echo json_encode([
        "status" => "ERROR",
        "message" => "Missing idGame"
    ]);
    die();
}

// Query untuk mendapatkan semua tim dalam game
$sql = "SELECT idteam, name FROM team WHERE idgame = ?";
$stmt = $mysqli->prepare($sql);
$stmt->bind_param("i", $idGame);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
    $teams = $result->fetch_all(MYSQLI_ASSOC); // Ambil semua hasil sebagai array
    echo json_encode([
        "status" => "OK",
        "message" => "Fetch successful",
        "teams" => $teams
    ]);
} else {
    echo json_encode([
        "status" => "ERROR",
        "message" => "No teams found"
    ]);
}

// Tutup koneksi
$stmt->close();
$mysqli->close();
?>