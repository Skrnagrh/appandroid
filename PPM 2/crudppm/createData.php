<?php
// require_once 'connection.php';

// if ($con) {
//     $namaBarang = $_POST['namaBarang'];
//     $hargaBarang = $_POST['hargaBarang'];
//     $supplier = $_POST['supplier'];

//     $insert = "INSERT INTO barang(namaBarang,hargaBarang,supplier) VALUES('".$namaBarang."','".$hargaBarang."','".$supplier."')";
//     // $insert = "INSERT INTO barang(hargaBarang) VALUES('".$hargaBarang."')";
    

//     if ($namaBarang != "") {
//         $result = mysqli_query($con, $insert);
//         $response = array();

//         if ($result) {
//             array_push($response, array(
//                 'status' => 'OK'
//             ));
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


require_once 'connection.php';

if ($con){
    $namaBarang = $_POST['namaBarang'];
    $hargaBarang = $_POST['hargaBarang'];
    $supplier = $_POST['supplier'];

    $insert = "INSERT INTO barang(NamaPelanggan,JenisBarang,HargaBarang) VALUES('$namaBarang','$hargaBarang','$supplier') ";


    if($namaBarang != "" && $hargaBarang !="" && $supplier!=""){
        $result = mysqli_query($con, $insert);
        $response = array();

        if($result){
            array_push($response, array(
                'status' => 'berhasil menambahkan data'
            ));
        }else{
            array_push($response, array(
                'status' => 'gagal'
            ));
        }
    }else{
        array_push($response, array(
            'status' => 'gagal'
        ));
    }
}else {
    array_push($response, array(
        'status' => 'failed'
    ));
}
echo json_encode(array("server_response"=> $response));
mysqli_close($con);




?>



   