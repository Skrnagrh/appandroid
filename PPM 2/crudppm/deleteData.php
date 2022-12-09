<?php
require_once 'connection.php';

if ($con) {
    $id = $_POST['id'];

    $getData = "SELECT * FROM barang WHERE id = '$id'";

    if ($id != "") {
        $result = mysqli_query($con, $getData);
        $rows = mysqli_num_rows($result);
        $response = array();

        if ($rows > 0) {
            $delete = "DELETE  FROM barang WHERE id = '$id'";
            $exequery = mysqli_query($con, $delete);

            if ($exequery) {
                array_push($response, array(
                    'status' => 'OK'
                ));
            } else {
                array_push($response, array(
                    'status' => 'FAILED'
                ));
            }
        } else {
            array_push($response, array(
                'status' => 'FAILED'
            ));
        }
    } else {
        array_push($response, array(
            'status' => 'FAILED'
        ));
    }
} else {
    array_push($response, array(
        'status' => 'FAILED'
    ));
}

echo json_encode(array("server_response" => $response));
mysqli_close($con);




// include 'config.php';

// $id = $_POST['id'];

// // Create connection
// $conn = mysqli_connect($servername, $username, $password, $dbname);
// // Check connection
// if (!$conn) {
//     die("Connection failed: " . mysqli_connect_error());
// }

// $query = "delete from barang  where id=".$id;

// $response = mysqli_query($conn, $query) or die('Error query:  '.$query);
// $result["errormsg"]="Success";

// if ($response == 1){
// 	echo json_encode($result);
// }
// else{
// 	$result["errormsg"]="Fail";
// 	echo json_encode($result);
// }






?>

