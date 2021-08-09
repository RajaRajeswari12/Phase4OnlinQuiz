package com.onlineExam.OnlineQuiz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DbSequence {

	 @Id
	    private String id;

	    private long seq;

	    public DbSequence() {}

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public long getSeq() {
	        return seq;
	    }

	    public void setSeq(long seq) {
	        this.seq = seq;
	    }

		@Override
		public String toString() {
			return "DbSequence [id=" + id + ", seq=" + seq + "]";
		}
	    
	    
}
