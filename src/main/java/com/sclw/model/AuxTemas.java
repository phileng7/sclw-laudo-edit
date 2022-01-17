package com.sclw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(indexes = @Index(name = "idx_tpexame_id", columnList = "tipo_exame_id, id"))
public class AuxTemas implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer idAuto;
		
		private Integer id;
		
		@Column(columnDefinition="TEXT")
		private String nome;
		
		@ManyToOne
		@JoinColumn(name="tipo_exame_id")
		private AuxTipoExame auxTipoExameTemas;

		public AuxTemas() {
			super();
		}

		public AuxTemas(Integer id, String nome, AuxTipoExame auxTipoExameTemas) {
			super();
			this.id = id;
			this.nome = nome;
			this.auxTipoExameTemas = auxTipoExameTemas;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AuxTemas other = (AuxTemas) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}
		
}

