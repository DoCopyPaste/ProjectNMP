<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: *");
error_reporting(E_ALL);
ini_set('display_errors', 1);

$mysqli = new mysqli("localhost", "root", "", "projectnmp");

if ($mysqli->connect_errno) {
    echo json_encode(array('status' => 'ERROR', 'message' => 'Failed to connect DB: ' . $mysqli->connect_error));
    die();
}

$mysqli->set_charset("UTF8");

$firstName = $_POST['first_name'];
$lastName = $_POST['last_name'];
$username = $_POST['username'];
$password = $_POST['password'];

// Validasi input
if (empty($firstName) || empty($lastName) || empty($username) || empty($password)) {
    echo json_encode(["status" => "ERROR", "message" => "All fields are required."]);
    exit();
}

// Cek apakah username sudah ada
$stmt = $mysqli->prepare("SELECT * FROM users WHERE username = ?");
$stmt->bind_param("s", $username);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    echo json_encode(["status" => "ERROR", "message" => "Username already exists."]);
    exit();
}

// Simpan data pengguna
$stmt = $mysqli->prepare("INSERT INTO users (first_name, last_name, username, password) VALUES (?, ?, ?, ?)");
$stmt->bind_param("ssss", $firstName, $lastName, $username, $password);
if ($stmt->execute()) {
    echo json_encode(["status" => "OK", "message" => "User registered successfully."]);
} else {
    echo json_encode(["status" => "ERROR", "message" => "Failed to register user."]);
}

$stmt->close();
$mysqli->close();
?>
