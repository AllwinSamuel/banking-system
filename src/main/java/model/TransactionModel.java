package model;

import java.sql.Timestamp;

public class TransactionModel {
  private int id;
  private Long ano;
  private Timestamp date;
  private Long amount;
  private String type;
  
  public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Long getAno() {
	return ano;
}
public void setAno(Long ano) {
	this.ano = ano;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
public Long getAmount() {
	return amount;
}
public void setAmount(Long amount) {
	this.amount = amount;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
