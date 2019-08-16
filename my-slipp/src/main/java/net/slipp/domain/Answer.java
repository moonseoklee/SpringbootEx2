package net.slipp.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
	private Question question;
	
	@Lob
	private String contents;
	
	private Answer() {
	}
	
	public Answer(User writer,Question question,String contents) {
		this.writer = writer;
		this.contents = contents;
		this.question = question;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Answer other = (Answer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", writer=" + writer + ", contents=" + contents + "]";
	}
		
		

	

}
