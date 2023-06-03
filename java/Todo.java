package com.example.mobileproject.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
   @PrimaryKey(autoGenerate = true)
   private int id;
   private String edittitle;
   private String editcontent;



   @Override
   public String toString() {
      final StringBuffer sb = new StringBuffer("Todo{");
      sb.append("id=").append(id);
      sb.append(", edittitle='").append(edittitle).append('\'');
      sb.append(", editcontent='").append(editcontent).append('\'');
      sb.append('}');
      return sb.toString();
   }

   public Todo(String edittitle, String editcontent) {
      this.edittitle = edittitle;
      this.editcontent = editcontent;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {

      this.id = id;
   }

   public String getEdittitle() {
      return edittitle;
   }

   public void setEdittitle(String title) {

      this.edittitle = edittitle;
   }

   public String getEditcontent() {

      return editcontent;
   }

   public void setEditcontent(String content) {
      this.editcontent = editcontent;
   }
}
