package com.psycho.psychohelp.appointment.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psycho.psychohelp.patient.domain.model.entity.Patient;
import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import com.psycho.psychohelp.shared.domain.model.AuditModel;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@With
@Entity
@Table(name = "appointments")
public class Appointment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String meetUrl;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String Motive;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String PersonalHistory;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String TestRealized;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String Treatment;

    @NotNull
    private String ScheduleDate;

    @NotNull
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "psychologist_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Psychologist psychologist;

    public Appointment(Long id, String meetUrl, String motive, String personalHistory, String testRealized, String treatment, String scheduleDate, Status status, Patient patient, Psychologist psychologist) {
        this.id = id;
        this.meetUrl = meetUrl;
        Motive = motive;
        PersonalHistory = personalHistory;
        TestRealized = testRealized;
        Treatment = treatment;
        ScheduleDate = scheduleDate;
        this.status = status;
        this.patient = patient;
        this.psychologist = psychologist;
    }
}

