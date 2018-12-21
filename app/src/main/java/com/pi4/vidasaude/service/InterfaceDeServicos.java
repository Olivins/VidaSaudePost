package com.pi4.vidasaude.service;

import com.pi4.vidasaude.Domain.Consulta;
import com.pi4.vidasaude.Domain.Especialidade;
import com.pi4.vidasaude.Domain.Medico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterfaceDeServicos {

    @GET("/especialidades.php")
    Call<List<Especialidade>> especialidades();

    @GET("/medicos.php")
    Call<List<Medico>> medicos(); //

    /*@GET("/{id}.php")
    Call<List<Medico>> medicosById(@Path("id") String idEspecialidade); //muito errado*/

    @GET("/medicos_especialidade.php?id={id}")
    Call<List<Medico>> medicosByEspecialidade(@Path("id") String idEspecialidade);

    @GET("/medicosById.php")
    Call<List<Medico>> medicosById(@Query("id") String id); //recebe Query e converte em GET no endpoint

    @POST("/pacientes.php")
    Call<Consulta> consulta(@Query("nome") String nome, @Query("telefone") String telefone, @Query("idMedico") int idMedico);

}
