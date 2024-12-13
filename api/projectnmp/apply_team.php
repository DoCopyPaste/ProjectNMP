<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: *");
error_reporting(E_ERROR | E_PARSE);

$mysqli = new mysqli("localhost", "native_160422011", "ubaya", "native_160422011");

if ($mysqli->connect_errno) {
    echo json_encode(array('status' => 'ERROR', 'message' => 'Failed to connect DB'));
    die();
}
$mysqli->set_charset("UTF8");

// Ambil parameter dari POST
$idmember = $_POST['idmember'] ?? null;
$idteam = $_POST['idteam'] ?? null;
$description = $_POST['description'] ?? null;
$status = $_POST['status'] ?? null;

if (!$idmember || !$idteam || !$description || !$status) {
    echo json_encode(["status" => "ERROR", "message" => "All fields are required."]);
    exit();
}

// Cek apakah username sudah ada
$stmt = $mysqli->prepare("SELECT * FROM join_proposal WHERE idmember = ? and idteam = ?");
$stmt->bind_param("ii", $idmember, $idteam);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    echo json_encode(["status" => "ERROR", "message" => "Existing proposal already exist."]);
    exit();
}

// Siapkan query SQL
$sql = "INSERT INTO join_proposal (idmember, idteam, description, status) VALUES (?, ?, ?, ?)";
$stmt = $mysqli->prepare($sql);

if (!$stmt) {
    echo json_encode(["status" => "ERROR", "message" => "Failed to prepare statement."]);
    die();
}

$stmt->bind_param("iiss", $idmember, $idteam, $description, $status);

if ($stmt->execute()) {
    echo json_encode(["status" => "OK", "message" => "Proposal submitted successfully."]);
} else {
    echo json_encode(["status" => "ERROR", "message" => "Failed to submit proposal: " . $stmt->error]);
}

$stmt->close();
$mysqli->close();
?>
