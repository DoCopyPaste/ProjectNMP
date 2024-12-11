<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: *");
error_reporting(E_ERROR | E_PARSE);
$mysqli = new mysqli("localhost", "native_160422011", "ubaya", "native_160422011");

if ($c->connect_errno) {
    echo json_encode(array('result' => 'ERROR', 'message' => 'Failed to connect DB'));
    die();
}
$mysqli->set_charset("UTF8");

// Dapatkan semua game
$sql = "SELECT * FROM game";
$stmt = $mysqli->prepare($sql);
$stmt->execute();
$result = $stmt->get_result();
if($result){
    $games = []; // Array untuk menyimpan data game
    while ($row = $result->fetch_assoc()) {
        $games[] = $row; // Tambahkan setiap baris hasil ke array
    }
    echo json_encode([
        "status" => "OK",
        "message" => "fetch successful",
        "games" => $games
    ]);
}