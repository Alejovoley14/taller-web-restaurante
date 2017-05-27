package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Sebastian on 04/05/2017.
 */
@Entity(name = "Departamento")
public class Departamento  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 200)
    private String descripcion;
    @ManyToOne(optional = false)
    private Provincia provincia;
    @OneToMany(mappedBy = "departamento")
    private Collection<Localidad> localidades=new ArrayList<>();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Collection<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(Collection<Localidad> localidades) {
        this.localidades = localidades;
    }
}
