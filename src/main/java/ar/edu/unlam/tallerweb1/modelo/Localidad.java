package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Localidad")
public class Localidad  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String Descripcion;
    @ManyToOne(optional = false)
    private Departamento departamento;
    @OneToMany(mappedBy = "localidad")
    private Collection<Domicilio> domicilios = new ArrayList<>();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Collection<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(Collection<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }


}
