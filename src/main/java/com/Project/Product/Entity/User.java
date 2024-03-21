package com.Project.Product.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	private String userName;
	@NotBlank(message = "Invalid Email")
	@NotNull(message = "Invalid Email")
	@Column(unique = true)
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", message = "Invalid email ")
	private String userEmail;
    @NotBlank(message = "Password is required")
	@NotNull(message = "Password is required")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must"
			+ " contain at least one letter, one number, one special character")
	private String userPassword;
	@Min(value = 600000000 , message = "Phone Number is Invalid / Phone Number First Digit > 6 ")
	@Max(value = 999999999 , message = "Phone Number is Invalid / Phone Number < 9999999999")
	private long userPhone;
	
	
//	@Getter @Setter Enough From Lombok
	
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getUserEmail() {
//		return userEmail;
//	}
//	public void setUserEmail(String userEmail) {
//		this.userEmail = userEmail;
//	}
//	public String getUserPassword() {
//		return userPassword;
//	}
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//	public long getUserPhone() {
//		return userPhone;
//	}
//	public void setUserPhone(long userPhone) {
//		this.userPhone = userPhone;
//	}
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
//				+ userPassword + ", userPhone=" + userPhone + "]";
//	}
//	
	
	
	
	

}
