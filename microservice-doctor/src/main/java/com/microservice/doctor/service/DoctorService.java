package com.microservice.doctor.service;


import com.microservice.doctor.dtos.DoctorDTO;
import com.microservice.doctor.dtos.DoctorRequest;
import com.microservice.doctor.dtos.DoctorUpdateRequest;
import com.microservice.doctor.exeption.DoctorNotFoundException;
import com.microservice.doctor.mapper.MapperDoctor;
import com.microservice.doctor.model.Doctor;
import com.microservice.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MapperDoctor mapperDoctor;

    /// ---- Operaciones ABML ----
    /// Crear un doctor:
    public Mono<DoctorDTO> createDoctor(DoctorRequest request) {
        Doctor doctor = mapperDoctor.toEntity(request);
        return doctorRepository.save(doctor)
                .map(mapperDoctor::toDto);
    }

    //Eliminar un doctor:
    public Mono<Void> deleteDoctor(String id_doctor) {
        return doctorRepository.findById(id_doctor)
                .switchIfEmpty(Mono.error(new DoctorNotFoundException(id_doctor)))
                .flatMap(existingDoctor -> doctorRepository.deleteById(id_doctor));
    }

    //Buscar por id:
    public Mono<DoctorDTO> findById(String id_doctor){
        return doctorRepository.findById(id_doctor)
                .switchIfEmpty(Mono.error(new DoctorNotFoundException(id_doctor)))
                .map(mapperDoctor::toDto);
    }

    //Buscar todos los medicos:
    public Flux<DoctorDTO> findAll(){
        return doctorRepository.findAll()
                .map(mapperDoctor::toDto);
    }

    //Acualizar medico:
    public Mono<DoctorDTO> changeDoctor(String idDoctor, Mono<DoctorUpdateRequest> requestMono) {
        return doctorRepository.findById(idDoctor)
                // 1️⃣ Si no existe el doctor, lanza excepción
                .switchIfEmpty(Mono.error(new DoctorNotFoundException(idDoctor)))

                // 2️⃣ Si existe, mapea el DTO de actualización a entidad y setea el ID existente
                .flatMap(existingDoctor ->
                        requestMono.map(updateRequest -> {
                            Doctor updatedDoctor = mapperDoctor.toEntityUpdate(updateRequest);
                            updatedDoctor.setId_doctor(existingDoctor.getId_doctor());
                            return updatedDoctor;
                        })
                )

                // 3️⃣ Guarda el doctor actualizado en la base de datos
                .flatMap(doctorRepository::save)

                // 4️⃣ Devuelve el DTO final
                .map(mapperDoctor::toDto);
    }





}
