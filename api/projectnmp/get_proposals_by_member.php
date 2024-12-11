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

$idMember = $_POST['idmember'];

// Dapatkan semua game
$sql = "SELECT jp.idjoin_proposal as id, g.name as game_name, jp.status as status, t.name as team_name FROM join_proposal jp inner join team t on jp.idteam = t.idteam inner join game g on t.idgame = g.idgame where jp.idmember = ?";
$stmt = $mysqli->prepare($sql);
$stmt->bind_param("i", $idMember);
$stmt->execute();
$result = $stmt->get_result();

if ($result && $result->num_rows > 0) {
    $proposals = $result->fetch_all(MYSQLI_ASSOC); // Ambil semua hasil sebagai array
    echo json_encode([
        "status" => "OK",
        "message" => "Fetch successful",
        "proposals" => $proposals
    ]);
} else {
    echo json_encode([
        "status" => "ERROR",
        "message" => "No proposals found $_POST"
    ]);
}