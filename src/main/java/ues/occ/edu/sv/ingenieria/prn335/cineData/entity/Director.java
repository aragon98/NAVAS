/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.cineData.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "director", catalog = "cinev2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
    @NamedQuery(name = "Director.findByIdDirector", query = "SELECT d FROM Director d WHERE d.idDirector = :idDirector"),
    @NamedQuery(name = "Director.findByNombre", query = "SELECT d FROM Director d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Director.findByApellido", query = "SELECT d FROM Director d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Director.findByActivo", query = "SELECT d FROM Director d WHERE d.activo = :activo")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_director", nullable = false)
    private Integer idDirector;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDirector")
    private List<Pelicula> peliculaList;

    public Director() {
    }

    public Director(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Director(Integer idDirector, String nombre, String apellido, boolean activo) {
        this.idDirector = idDirector;
        this.nombre = nombre;
        this.apellido = apellido;
        this.activo = activo;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDirector != null ? idDirector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.idDirector == null && other.idDirector != null) || (this.idDirector != null && !this.idDirector.equals(other.idDirector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.occ.edu.sv.ingenieria.prn335.entity.Director[ idDirector=" + idDirector + " ]";
    }
    
}
