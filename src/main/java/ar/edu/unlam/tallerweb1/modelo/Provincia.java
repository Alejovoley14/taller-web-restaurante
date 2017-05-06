package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Provincia")
public class Provincia extends Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String descripcion;
    @OneToMany(mappedBy = "provincia")
    private Collection<Departamento> departamentos=new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Collection<Departamento> departamentos) {
        this.departamentos = departamentos;
    }


}
