package net.mertysr.hibernate.model.comment;

import net.mertysr.hibernate.model.comment.Comment;

public class Private implements Comment{
	@Override
	  public void comment() {
	    System.out.println( "Your vehicle is private." );
	  }
}
