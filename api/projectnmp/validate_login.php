<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: *");
error_reporting(E_ERROR | E_PARSE);
$mysqli = new mysqli("localhost", "root", "", "projectnmp");
if ($c->connect_errno) {
    echo json_encode(array('result' => 'ERROR', 'message' => 'Failed to connect DB'));
    die();
}
$mysqli->set_charset("UTF8");
// Ambil data dari permintaan POST
$username = $_POST['username'];
$password = $_POST['password'];

// Validasi input
if (!isset($username) || !isset($password)) {
    echo json_encode(["status" => "ERROR", "message" => "Invalid input"]);
    exit();
}

// Query untuk memeriksa kredensial pengguna
$stmt = $mysqli->prepare("SELECT * FROM users WHERE username = ? AND password = ?");
$stmt->bind_param("ss", $username, $password);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    echo json_encode(["status" => "OK", "message" => "Login successful"]);
} else {
    echo json_encode(["status" => "ERROR", "message" => "Invalid username or password"]);
}

$stmt->close();
$mysqli->close();
?>