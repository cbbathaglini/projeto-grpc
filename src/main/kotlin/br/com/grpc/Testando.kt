package br.com.grpc

import java.io.FileInputStream
import java.io.FileOutputStream

fun main(args : Array<String>){

    val request = FuncionarioRequest.newBuilder()
        .setNome("Carine")
        .setCpf("888.888.888-88")
        .setIdade(24)
        .setSalario(2021.0)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(
            Endereco.newBuilder()
                .setLogradouro("Avenida Coronel Marcos")
                .setCep("00000-000")
                .setComplemento("Casa 4")
                .build()
        )
        .build()

    println("Request: " + request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder().mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE).build()

    println("Request2: " + request2)
}