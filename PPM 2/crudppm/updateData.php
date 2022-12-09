<?php
require_once 'connection.php';

// if ($con) {
//     $id = $_POST['id'];
//     $namaBarang = $_POST['namaBarang'];
//     $hargaBarang = $_POST['hargaBarang'];
//     $supplier = $_POST['supplier'];

//     $getData = "SELECT * FROM barang WHERE id = '$id'";

//     if ($nama != "") {
//         $result = mysqli_query($con, $getData);
//         $rows = mysqli_num_rows($result);
//         $response = array();

//         if ($rows > 0) {
//             // $update = "UPDATE barang SET namaBarang = '$namaBarang' , hargaBarang = '$hargaBarang', supplier = '$supplier'  WHERE id = '$id'";
//             $update = "UPDATE barang SET namaBarang='".$namaBarang."', hargaBarang='".$hargaBarang."', supplier='".$supplier."' WHERE id='".$id."'";
//             $exequery = mysqli_query($con, $update);

//             if ($exequery) {
//                 array_push($response, array(
//                     'status' => 'OK'
//                 ));
//             } else {
//                 array_push($response, array(
//                     'status' => 'FAILED'
//                 ));
//             }
//         } else {
//             array_push($response, array(
//                 'status' => 'FAILED'
//             ));
//         }
//     } else {
//         array_push($response, array(
//             'status' => 'FAILED'
//         ));
//     }
// } else {
//     array_push($response, array(
//         'status' => 'FAILED'
//     ));
// }

// echo json_encode(array("server_response" => $response));
// mysqli_close($con);



    $connection = mysqli_connect("localhost","root","","db_listrik");
    
     $id = $_POST["id"];
     $namaBarang = $_POST["namaBarang"];
     $hargaBarang = $_POST["hargaBarang"];
     $supplier = $_POST["supplier"];
     
     $sql = "UPDATE barang SET  NamaPelanggan = '$namaBarang', JenisBarang = '$hargaBarang', HargaBarang = '$supplier' WHERE id = '$id' ";
     
     $result = mysqli_query($connection,$sql);
     
     if($result){
         echo "Data Updated";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($connection);
     
   


?>