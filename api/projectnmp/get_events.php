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

// Query untuk mendapatkan semua tim dalam game
$sql = "SELECT e.date, e.name, e.description, t.name as 'team', g.name as 'game', g.idgame FROM event e INNER JOIN event_teams et on e.idevent = et.idevent INNER JOIN team t on et.idteam = t.idteam INNER JOIN game g on t.idgame = g.idgame";
$stmt = $mysqli->prepare($sql);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
    $events = $result->fetch_all(MYSQLI_ASSOC); // Ambil semua hasil sebagai array
    echo json_encode([
        "status" => "OK",
        "message" => "Fetch successful",
        "events" => $events
    ]);
} else {
    echo json_encode([
        "status" => "ERROR",
        "message" => "No events found"
    ]);
}

// Tutup koneksi
$stmt->close();
$mysqli->close();
