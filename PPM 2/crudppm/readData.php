<?php
require_once 'connection.php';

$query = "SELECT * FROM barang";
$result = mysqli_query($con, $query);
$response = array();

while ($row = mysqli_fetch_array($result)) {
    array_push($response, array(
        "id" => $row[0],
        "NamaPelanggan" => $row[1],
        "JenisBarang" => $row[2],
        "HargaBarang" => $row[3]
    ));
}

echo json_encode(array("server_response" => $response));
mysqli_close($con);
?>