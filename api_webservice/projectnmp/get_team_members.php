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
$idTeam = $_POST['idteam'] ?? null; // Pastikan $idGame tidak null

if (!$idTeam) {
    echo json_encode([
        "status" => "ERROR",
        "message" => "Missing idTeam"
    ]);
    die();
}

// Query untuk mendapatkan semua tim dalam game
$sql = "SELECT tm.idmember, concat(m.fname, ' ' ,m.lname) as name, tm.description
        FROM team_members tm INNER JOIN member m on tm.idmember = m.idmember 
        WHERE idteam = ?";
$stmt = $mysqli->prepare($sql);
$stmt->bind_param("i", $idTeam);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
    $team_members = $result->fetch_all(MYSQLI_ASSOC); // Ambil semua hasil sebagai array
    echo json_encode([
        "status" => "OK",
        "message" => "Fetch successful",
        "team_members" => $team_members
    ]);
} else {
    echo json_encode([
        "status" => "ERROR",
        "message" => "No members found"
    ]);
}

// Tutup koneksi
$stmt->close();
$mysqli->close();
