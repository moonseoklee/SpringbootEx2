package net.slipp.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_question_writer"))	
	private User writer;
	
	private String title;
	private String contents;
	
	private LocalDateTime createDate;
	
	
	public Question() {}
	
	public Question(User writer, String title, String contents) {		
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
	}

	  public void update(String title, String contents) {
		  this.title = title;
		  this.contents = contents;
		// TODO Auto-generated method stub
		
	}
}
