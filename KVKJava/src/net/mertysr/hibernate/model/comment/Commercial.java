package net.mertysr.hibernate.model.comment;

import net.mertysr.hibernate.model.comment.Comment;

	public class Commercial implements Comment{
		@Override
		  public void comment() {
		    System.out.println( "Your vehicle is commercial." ); //interpreter behaivor
		  }
	}
